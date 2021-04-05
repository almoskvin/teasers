package com.github.almoskvin.teasers;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Sort an array of Player, firstly by Score, secondly by Name. Use comparator.
 */
public class ArraySortComparator {

    @Data
    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public Player[] compare(Player[] unsorted) {

        Checker checker = new Checker();
        Arrays.sort(unsorted, checker);

        // Java 8+ version of the 'Checker' comparator
        /*Comparator<Player> playerComparator = Comparator.nullsFirst(
                Comparator.comparing(Player::getScore)
                        .reversed()
                        .thenComparing(Comparator.nullsFirst(Comparator.comparing(Player::getName)))
        );
        Arrays.sort(unsorted, playerComparator);*/
        return unsorted;
    }

    private static class Checker implements Comparator<Player> {
        @Override
        public int compare(Player o1, Player o2) {
            if (o1 == null) {
                return o2 == null ? 0 : -1;
            }
            if (o2 == null) {
                return 1;
            }
            // comparing by score
            if (o1.score > o2.score) {
                return -1;
            }
            if (o1.score < o2.score) {
                return 1;
            }
            if (o1.name == null) {
                return o2.name == null ? 0 : -1;
            }
            if (o2.name == null) {
                return 1;
            }
            if (o1.name.equals(o2.name)) {
                return 0;
            }
            for (int i = 0; i < o1.name.length() && i < o2.name.length(); i++) {
                if (o1.name.charAt(i) > o2.name.charAt(i)) {
                    return 1;
                }
                if (o1.name.charAt(i) < o2.name.charAt(i)) {
                    return -1;
                }
            }
            return Integer.compare(o1.name.length(), o2.name.length());
        }
    }
}
