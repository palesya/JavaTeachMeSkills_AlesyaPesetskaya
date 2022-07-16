package com.tms.service;

import lombok.Data;

import java.util.Scanner;

@Data
public class UserBetService {

    private int betNumber;

    public int askForPairNumber() {
        System.out.println("What number do you want to bet on (from 1 to 3)?");
        Scanner scanner = new Scanner(System.in);
        betNumber = scanner.nextInt()-1;
        if (betNumber < 0 || betNumber > 2) {
            System.out.println("We have only 3 pairs in this race. \nPlease, reenter number from 1 to 3.");
            askForPairNumber();
        }
        return betNumber;
    }
}
