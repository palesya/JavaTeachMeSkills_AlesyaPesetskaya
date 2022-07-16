package com.tms.service;

import com.tms.model.Pair;
import com.tms.model.PairDataBase;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class RacingService {

    private int numberOfCircles;
    private PairDataBase dataBase;

    private int betNumber;
    private String betHorseName;
    private List<Map.Entry<Pair, Double>> lastResults;
    private Map<Pair, Double> speedOfAllPairs = new HashMap<>();

    public void askForPairNumber() {
        System.out.println("What number do you want to bet on (from 1 to 3)?");
        Scanner scanner = new Scanner(System.in);
        betNumber = scanner.nextInt();
        if (betNumber < 1 || betNumber > 3) {
            System.out.println("We have only 3 pairs in this race. \nPlease, reenter number from 1 to 3.");
            askForPairNumber();
        }
    }

    public RacingService(int numberOfCircles, PairDataBase dataBase) {
        this.numberOfCircles = numberOfCircles;
        this.dataBase = dataBase;
    }

    public void printPairsInfo() {
        List<Pair> allPairs = dataBase.getAllPairs();
        System.out.println("---------PARTICIPANTS---------");
        for (int i = 0; i < allPairs.size(); i++) {
            String horseName = allPairs.get(i).getHorse().getName();
            String riderName = allPairs.get(i).getRider().getName();
            System.out.println("Pair " + (i + 1) + " Horse " + horseName + ", Rider " + riderName);
        }
        betHorseName = allPairs.get(betNumber - 1).getHorse().getName();
    }

    private List<Map.Entry<Pair, Double>> returnCircleResults() {
        List<Pair> allPairs = dataBase.getAllPairs();
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


    private double countSpeed(Pair pair) {
        double quality = pair.getRider().getQuality();
        int horseSpeed = pair.getHorse().getSpeed();
        double unexpectedConditions = 0.5 + (Math.random() * 0.9);
        return (quality + 0.2) * horseSpeed * unexpectedConditions;
    }

    public void printResultsOfEachCircle() throws InterruptedException {
        for (int i = 0; i < numberOfCircles; i++) {
            System.out.println("______________________________");
            Thread.sleep(2000);
            System.out.println("Results of circle " + (i + 1) + ":");
            lastResults = returnCircleResults();
        }
    }

    public void checkIfWin() {
        String nameHorseWinner = lastResults.get(0).getKey().getHorse().getName();
        System.out.println("---------RESULTS---------");
        if (Objects.equals(nameHorseWinner, betHorseName)) {
            System.out.println("Congratulations!!!\nYour horse " + betHorseName + " won!!!");
        } else {
            System.out.println("Sorry,\nYour horse " + betHorseName + " didn't win.\nGood luck next time!");
        }
    }


}
