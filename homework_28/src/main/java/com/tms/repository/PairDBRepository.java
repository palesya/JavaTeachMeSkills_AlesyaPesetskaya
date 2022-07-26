package com.tms.repository;

import com.tms.model.Pair;
import com.tms.model.PairDataBase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PairDBRepository {

    @Autowired
    private PairDataBase dataBase;

    public void printPairsInfo() {
        System.out.println("---------PARTICIPANTS---------");
        List<Pair> allPairs = getAllPairs();
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

