package com.github.almoskvin.teasers;

public class ArrayGameCanWin {
    public static boolean canWin(int leap, int[] game) {
        return isSolvable(leap, game, 0);
    }

    private static boolean isSolvable(int leap, int[] game, int pos) {
        if (pos >= game.length) {
            return true;
        } else if (pos < 0 || game[pos] == 1) {
            return false;
        }

        game[pos] = 1;

        return isSolvable(leap, game, pos + 1) || isSolvable(leap, game, pos + leap) || isSolvable(leap, game, pos - 1);
    }
}
