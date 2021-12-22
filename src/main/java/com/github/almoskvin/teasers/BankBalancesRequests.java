package com.github.almoskvin.teasers;

public class BankBalancesRequests {
    public static int[] solution(int[] balances, String[] requests) {
        for (int i = 0; i < requests.length; i++) {
            String request = requests[i];
            final String[] s = request.split(" ");
            if (s.length < 3) { // request doesn't comply with minimum required number of elements
                return new int[]{-1 * (i + 1)};
            }
            int accWithdraw, accDeposit, sum;
            switch (s[0]) {
                case "withdraw":
                    accWithdraw = Integer.parseInt(s[1]) - 1;
                    if (accWithdraw >= balances.length) { // wrong account number
                        return new int[]{-1 * (i + 1)};
                    }
                    sum = Integer.parseInt(s[2]);
                    if (balances[accWithdraw] < sum) { // insufficient funds
                        return new int[]{-1 * (i + 1)};
                    }
                    balances[accWithdraw] -= sum;
                    break;
                case "deposit":
                    accDeposit = Integer.parseInt(s[1]) - 1;
                    if (accDeposit >= balances.length) { // wrong account number
                        return new int[]{-1 * (i + 1)};
                    }
                    sum = Integer.parseInt(s[2]);
                    balances[accDeposit] += sum;
                    break;
                case "transfer":
                    accWithdraw = Integer.parseInt(s[1]) - 1;
                    accDeposit = Integer.parseInt(s[2]) - 1;
                    if (accWithdraw >= balances.length || accDeposit >= balances.length) { // wrong account number
                        return new int[]{-1 * (i + 1)};
                    }
                    sum = Integer.parseInt(s[3]);
                    if (balances[accWithdraw] < sum) { // insufficient funds
                        return new int[]{-1 * (i + 1)};
                    }
                    balances[accWithdraw] -= sum;
                    balances[accDeposit] += sum;
                    break;
                default:
            }
        }
        return balances;
    }
}
