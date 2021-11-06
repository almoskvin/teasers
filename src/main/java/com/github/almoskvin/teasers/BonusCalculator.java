package com.github.almoskvin.teasers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CEO wants to give bonuses to all the managers in the company. He's fair so each manager shall receive equal amount of money.
 * Bonus sum must be integer and must be paid in one transaction from one account to each manager.
 * CEO has N opened accounts with Cn amount of money on each of them. There are M managers in the company.
 *
 * Task: calculate the maximum available bonus. If there isn't enough money to pay at least $1, the answer should be 0.
 *
 * Now, this is a linear search solution which is obviously not perfect. Binary search should be a better fit here.
 */
public class BonusCalculator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] arr = line.split(" ");
        int accNumber = Integer.parseInt(arr[0]);
        int men = Integer.parseInt(arr[1]);
        ArrayList<Integer> acc = new ArrayList<>();
        for (int i = 0; i < accNumber; i++) {
            acc.add(in.nextInt());
        }
        int result = calculateBonusSize(acc, men);
        System.out.println(result);
    }

    public static int calculateBonusSize(List<Integer> acc, int payees) {
        int lumpSum = acc.stream().mapToInt(Integer::intValue).sum();
        int maxBonus = lumpSum / payees;
        if (maxBonus == 0) {
            return 0;
        }
        while (maxBonus > 0) {
            int finalMaxBonus = maxBonus;
            final int lumps = acc.stream()
                    .filter(a -> a >= finalMaxBonus)
                    .map(a -> a / finalMaxBonus)
                    .mapToInt(Integer::intValue)
                    .sum();
            if (lumps >= payees) {
                return finalMaxBonus;
            }
            maxBonus--;
        }
        return 0;
    }
}
