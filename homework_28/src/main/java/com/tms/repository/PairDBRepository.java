package com.tms.repository;

import com.tms.model.Pair;
import com.tms.model.PairDataBase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PairDBRepository {

    private PairDataBase dataBase;

    public void printPairsInfo() {
        List<Pair> allPairs = dataBase.getPairs();
        System.out.println("---------PARTICIPANTS---------");
        for (int i = 0; i < allPairs.size(); i++) {
            String horseName = allPairs.get(i).getHorse().getName();
            String riderName = allPairs.get(i).getRider().getName();
            System.out.println("Pair " + (i + 1) + " Horse " + horseName + ", Rider " + riderName);
        }
    }
    public String getHorseNameById(int id) {
        return dataBase.getPairs().get(id).getHorse().getName();
    }

    public List<Pair> getAllPairs(){
        return dataBase.getPairs();
    }
}

