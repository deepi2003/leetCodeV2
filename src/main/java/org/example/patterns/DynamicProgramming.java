package org.example.patterns;

import java.util.*;
import java.util.stream.Collectors;

public class DynamicProgramming {
    public int climbingStairs(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int temp = 1;
            int startIndex;
            if (i < k) {
                startIndex = 0;
            } else {
                startIndex = i - k + 1;
            }
            for (int j = startIndex; j <= i - 1; j++) {
                temp += dp[j];
            }
            dp[i] = temp;
        }
        return dp[n];
    }


    public int climbingStairsV2(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0)
                    dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }


    public int climbingStairsV4(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1 ;
        for (int i = 2; i <= n; i++) {
            dp[i] =2*dp[i-1];
            if(i-(k+1) >=0) {
                dp[i] -= dp[i-(k+1)];
            }
        }
        return dp[n];
    }

    public int climbingStairsV3(int n, int k) {
        int[] dp = new int[n + 1];
        return climbingStairsV3Helper(k, n, dp);
    }

    int climbingStairsV3Helper(int k, int stairs, int[] dp) {
     if(stairs == 0 ) {
         return 1;
     }
     if(stairs < 0) {
         return 0;
     }
     if(dp[stairs] != 0 ) {
         return dp[stairs];
     }
     int ans = 0;
     for(int i = 1; i <=k; i++) {
         ans += climbingStairsV3Helper(k, stairs-i, dp);
     }
     return dp[stairs] = ans;
    }



    public  int coinChange(int[] coins, int target) {

        List<Integer> list = Arrays.stream(coins)     // IntStream
                .boxed()        // Stream<Integer>
                .collect(Collectors.toList());

        return coinNumbersHelper(list, target, new HashMap<>());
    }

    public  int coinNumbersHelper(List<Integer> coins, int target, HashMap<Integer, Integer> dp) {
        if(target == 0) {
            return 0;
        }
        if(dp.get(target) != null) {
            return dp.get(target);
        }
        if(coins.contains(target)) {
            return 1;
        }
        int res = Integer.MAX_VALUE;
        dp.put(target , -1);
       for(int i = 0;  i< coins.size(); i++) {
           if(target-coins.get(i) >= 0
                   && dp.get(target-coins.get(i)) != null
                   && dp.get(target-coins.get(i)) != -1) {
               res = Math.min(res, coinNumbersHelper(coins, target - coins.get(i), dp)) + 1;
               dp.put(target, res);
           }
       }
       return dp.get(target);
    }

    public  int coinChangeV2(int[] coins, int target) {
        int[] dp = new int[target+1];
        dp[0] = 0;
        for(int i = 1 ; i <=target; i++) {
            int res = Integer.MAX_VALUE;
            for(int coin: coins) {
                if(i-coin >= 0 && dp[i-coin] != -1)
                    res = Math.min(res, dp[i-coin]);
            }
            if(res == Integer.MAX_VALUE)
                dp[i] = -1;
            else {
                dp[i] = res +1;
            }
        }
        return dp[target];
    }

    int maxProfit(int[] prices, int length) {
        int[] dp = new int[length+1];
        dp[0] = 0;
        return maxProfitHelper(prices, length, dp);
    }

    int maxProfitHelper(int[] prices, int length, int[] dp) {
        if(length == 0)
            return 0;
        if(dp[length] != 0)
            return dp[length];
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(length-(i+1) >= 0){
                int k = maxProfitHelper(prices, length-(i+1), dp) + prices[i];
                res = Math.max(res, k);
            }

            dp[length] = res;
        }
        return dp[length];
    }

    int maxProfitV2(int[] prices, int length) {
        int[] dp= new int[length+1];
        dp[0] = 0;
        for(int i = 1; i <= length; i++) {
           int res = Integer.MIN_VALUE;
            int ans;
            for(int j = 1; j <= i; j++) {
                ans = prices[j-1] + dp[i-j];
                res = Math.max(res, ans);
            }
            dp[i] = res;
        }
        return dp[length];
    }

    int jump(int[] jumps) {
        int[] dp = new int[jumps.length+1];
        int endIndex = jumps.length;
        dp[0] =0;
        for(int target = 1; target < endIndex; target++) {
            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < target; i++) {
                int curAns;
                if( i + jumps[i] >= target) {
                    curAns =  dp[i] +1;
                    ans = Math.min(curAns, ans);
                }
            }
            dp[target] = ans;
        }
        return dp[endIndex-1];
    }

    int jumpv2(int[] jumps) {
        int [] dp = new int[jumps.length+1];
        dp[0] = 0;
        return jumpv2Helper(jumps, 0, dp);
    }

        int jumpv2Helper(int[] jumps, int startIndex, int[] dp) {
            if(startIndex >= jumps.length-1) {
                return 0;
            }
            if(dp[startIndex] != 0) {
                return dp[startIndex];
            }
            int curr_ans = Integer.MAX_VALUE;
            for(int i = 1; i <= jumps[startIndex]; i++) {
                int b = jumpv2Helper(jumps, startIndex + i, dp);
                curr_ans = Math.min(curr_ans, b);
            }
            if(curr_ans == Integer.MAX_VALUE) {
                dp[startIndex] = Integer.MAX_VALUE;
                return curr_ans;
            }
            dp[startIndex] = curr_ans+1;
            return dp[startIndex] = curr_ans+1;
        }


    int minFrogJump(int[] price) {
        int [] dp = new int[price.length+1];
        dp[0] = 0;
        dp[1] = Math.abs(price[0] - price[1]);
       for(int i = 2; i < price.length; i++){
           int a = dp[i-1] + Math.abs(price[i] - price[i-1]);
           int b = dp[i-2] + Math.abs(price[i] - price[i-2]);
           dp[i] = Math.min(a,b);

        }

        return dp[price.length-1];
    }


    int adjacentSum( int[] nums){
/*
6, 10, 12, 7, 9, 14


            6(27, 32,27,15, 20)
  12(21, 26)         7(21)     9    14
9    14             14

        10(31, 19, 24)
7(21)       9    14
14


12(21, 26)
9   14





 */

        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[1];
        return adjacentSumHelper(nums, 0, dp);
//        return dp[nums.length-1];
    }

    int adjacentSumHelper(int[] nums, int startingPoint,int [] dp) {
        if(startingPoint == nums.length-1) {
            return nums[startingPoint];
        }
        if(dp[0] != 0) {
            return dp[0];
        }
        int curr_ans = Integer.MIN_VALUE;
        for(int i = startingPoint+2; i < nums.length; i++){
            curr_ans =  Math.max(curr_ans, adjacentSumHelper(nums, i, dp));
        }

        return dp[startingPoint] = curr_ans+ nums[startingPoint];
    }

    int adjacentSumV2( int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], (dp[i-2] + nums[i]));
        }
        return dp[nums.length-1];
    }

    int LongestIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 0;
        for(int i = 1; i< nums.length; i++) {
            int maxS = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]) {
                    maxS = Math.max(dp[j], maxS);
                }
                dp[i] = maxS+1;
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    int BoxStacking(int[][] boxes) {
        int result = 0;
        Arrays.sort(boxes, Comparator.comparingInt(o -> o[2]));
        int [] dp = new int[boxes.length];
        dp[0] = boxes[0][2];
        for(int i = 1; i < boxes.length; i++) {
            for(int j = i-1; j>=0; j--) {
                dp[i] = boxes[i][2];
                if(boxes[j][0] < boxes[i][2] && boxes[j][1] < boxes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+ boxes[i][2]);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    int countBSTs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] =1 ;
        for(int i = 2; i <= n; i++){
            int lefttree = 0;
            for(int j = 1; j<=i; j++) {
                lefttree = lefttree+(dp[j-1]*dp[i-j]);
            }
            dp[i] = lefttree;

        }
        return dp[n];
    }


    public int maxProduct(int[] nums) {
        long[] max = new long[nums.length];
        long[] min = new long[nums.length];
        long res = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for(int i =1; i < nums.length; i++){
            max[i] = Math.max(Math.max(max[i-1]*nums[i], min[i-1]*nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i-1]*nums[i], min[i-1]*nums[i]), nums[i]);
            res = Math.max(res, max[i]);
        }
        return (int)res;
    }




}
