package com.tms.service;

import com.tms.model.Pair;
import com.tms.repository.PairDBRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Data
@Service
public class RacingService{


    private int numberOfCircles;
    @Autowired
    private PairDBRepository repository;
    @Autowired
    private UserBetService betService;

    private String betHorseName;
    private List<Map.Entry<Pair, Double>> lastResults;
    private Map<Pair, Double> speedOfAllPairs = new HashMap<>();

    public RacingService(@Value("5") int numberOfCircles) {
        this.numberOfCircles = numberOfCircles;
    }

    @PostConstruct
    public void init() {
        betService.askForPairNumber();
        repository.printPairsInfo();
    }

    public void startRace() throws InterruptedException {
        for (int i = 0; i < numberOfCircles; i++) {
            System.out.println("______________________________");
            Thread.sleep(2000);
            System.out.println("Results of circle " + (i + 1) + ":");
            lastResults = returnCircleResults();
        }
    }

    @PreDestroy
    public void destroyPreDestroy() {
        checkIfWin();
    }

    private List<Map.Entry<Pair, Double>> returnCircleResults() {
        List<Pair> allPairs = repository.getAllPairs();
        for (Pair pair : allPairs) {
            double totalSpeed = countSpeed(pair);
            if (speedOfAllPairs.get(pair) == null) {
                speedOfAllPairs.put(pair, totalSpeed);
            } else {
                Double previousSpeed = speedOfAllPairs.get(pair);
                speedOfAllPairs.replace(pair, previousSpeed + totalSpeed);
            }
        }
        List<Map.Entry<Pair, Double>> sortedResults = speedOfAllPairs.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        for (int i = 1; i <= sortedResults.size(); i++) {
            System.out.println(i + " place: " + sortedResults.get(i - 1).getKey().getHorse().getName());
            System.out.printf("Sum of speed results %.2f\n", sortedResults.get(i - 1).getValue());
        }
        return sortedResults;
    }

    private void checkIfWin() {
        String nameHorseWinner = lastResults.get(0).getKey().getHorse().getName();
        String betHorseName = repository.getHorseNameById(betService.getBetNumber());
        System.out.println("---------RESULTS---------");
        if (Objects.equals(nameHorseWinner, betHorseName)) {
            System.out.println("Congratulations!!!\nYour horse " + betHorseName + " won!!!");
        } else {
            System.out.println("Sorry,\nYour horse " + betHorseName + " didn't win.\nGood luck next time!");
        }
    }

    private double countSpeed(Pair pair) {
        double quality = pair.getRider().getQuality();
        int horseSpeed = pair.getHorse().getSpeed();
        double unexpectedConditions = 0.5 + (Math.random() * 0.9);
        return (quality + 0.2) * horseSpeed * unexpectedConditions;
    }

}
