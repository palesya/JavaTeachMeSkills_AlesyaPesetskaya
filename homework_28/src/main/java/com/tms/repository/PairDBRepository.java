package com.tms.repository;

import com.tms.model.Pair;
import com.tms.model.PairDataBase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PairDBRepository {

    private PairDataBase dataBase;

    public void printPairsInfo() {
        List<Pair> allPairs = dataBase.getAllPairs();
        System.out.println("---------PARTICIPANTS---------");
        for (int i = 0; i < allPairs.size(); i++) {
            String horseName = allPairs.get(i).getHorse().getName();
            String riderName = allPairs.get(i).getRider().getName();
            System.out.println("Pair " + (i + 1) + " Horse " + horseName + ", Rider " + riderName);
        }
    }
    public String getHorseNameById(int id) {
        return dataBase.getAllPairs().get(id).getHorse().getName();
    }

    public List<Pair> getAllPairs(){
        return dataBase.getAllPairs();
    }
}

