package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BinaryOperator;

public class RecursionExcercise {
    public static int  superDigit(String n, int k) {
        n = n.repeat(k);
        return superDigitHelper(n);
    }

    private static int  superDigitHelper(String str) {
        if(str.length() ==1)
            return Integer.parseInt(str);
        long res = 0;
        for(int i = 0; i < str.length(); i++) {
            res+= Character.getNumericValue(str.charAt(i));
        }
        return superDigitHelper(String.valueOf(res));
    }


    public static int powerSum(int X, int N) {
        return powerSumHelper(X, N, 1);
    }
    private static int powerSumHelper(double target, int power, int current) {
         double pw = Math.pow(current, power);
         if(pw > target)
             return 0;
         if(pw == target)
             return 1;
        return powerSumHelper(target, power, current+1)+ powerSumHelper(target-pw, power, current+1);

    }

    public static long getWays(int n, List<Long> c) {
        return getWaysHelper(n, 0, c);

    }
    public static int getWaysHelper(int n,  int idx, List<Long> c) {
        if(n == 0)
            return 1;
        int ways = 0;
        for(int j = idx; j < c.size(); j++) {
            if(n-c.get(j) >= 0 ){
                ways+= getWaysHelper((int) (n-c.get(j)), j, c);
            }
        }
        return ways;
    }

    public static int coinCombinations(List<Long> denominations, int idx, int target, int[][] dp) {
        // Base Case
        if (target == 0) return 1;
        if (idx == denominations.size() || target < 0) return 0;

        // LookUp in Dp Array
        if (dp[idx][target] != -1) return dp[idx][target];

        // Pick current coin
        int pick = coinCombinations(denominations, idx, (int) (target - denominations.get(idx)), dp);

        // Do not pick current coin
        int nonPick = coinCombinations(denominations, idx + 1, target, dp);

        return dp[idx][target] = pick + nonPick;
    }


}
