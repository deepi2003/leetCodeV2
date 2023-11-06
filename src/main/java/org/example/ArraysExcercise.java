package org.example;

import java.util.*;

public class ArraysExcercise {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) {
           return nums1;
        }
        int num1Index = 0, num2Index = 0;

        while(num1Index < m ) {
                if(nums1[num1Index] > nums2[num2Index]) {
                    int temp = nums1[num1Index];
                    nums1[num1Index] = nums2[num2Index];
                    nums2[num2Index] = temp;
                    nums2 = Arrays.stream(nums2).sorted().toArray();
                }
                num1Index++;
        }
        for(int i = m; i < m+n ;i++, num2Index++) {
            nums1[i] = nums2[num2Index];
        }
        return nums1;
    }


    public int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) {
            return nums1;
        }
        int num2Index = 0;

        for(int i = m; i < m+n; i++, num2Index++) {
            nums1[i] = nums2[num2Index];
        }
        Arrays.sort(nums1);
        return nums1;
    }

    public int[] merge3(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) {
            return nums1;
        }
        int num1Index = m-1, num2Index = n-1, resultIndex = m+n-1;

        while(num2Index >= 0) {
            if ( num1Index >= 0 && nums1[num1Index] > nums2[num2Index]) {
                nums1[resultIndex] = nums1[num1Index];
                num1Index --;
            } else {
                nums1[resultIndex] = nums2[num2Index];
                num2Index --;
            }
            resultIndex --;
        }
        return nums1;
    }

    public int removeElement(int[] nums, int val) {
        int lastSwitchIndex = nums.length-1;
        if(nums.length == 0)
            return 0;
        for(int i = 0; i <= lastSwitchIndex; i++) {
            while(lastSwitchIndex> 0 && nums[lastSwitchIndex] ==val) {
                lastSwitchIndex--;
            }
            if(nums[i] == val) {
                int temp = nums[i];
                nums[i] = nums[lastSwitchIndex];
                nums[lastSwitchIndex] = temp;
                lastSwitchIndex--;
            }
        }

        return lastSwitchIndex+1;
    }


    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
    }


    public int removeElement3(int[] nums, int val) {
        int k = 0;
        for(int n: nums) {
            if(n != val) {
                nums[k] = n;
             }
            k++;
        }
        return k;
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        int i = 0, j=1;
        while(j < nums.length) {
            if(nums[i] >= nums[i+1]) {
                while( j < nums.length && nums[j] <= nums[i]) {
                    j++;
                }
                if(j< nums.length) {
                    int temp = nums[i+1];
                    nums[i+1] = nums[j];
                    nums[j] = temp;
                }
            }
            i++;
            j++;
        }
        return i+1;
    }


    public int removeDuplicates2(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        int i=1;
        for(int j = 0; j < nums.length-1; j++) {
            if(nums[j] !=nums[j+1]) {
                 nums[i] = nums[j+1];
                 i = i+2;
                 j++;
            }
        }

        return i;
    }

    public int removeDuplicates3(int[] nums) {
        if(nums.length == 2) {
            return 2;
        }
        int i=1;
        for(int j = 2; j <= nums.length-1; j++) {
            if(nums[j] !=nums[i-1]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);

        int majorityMark = (nums.length/2)+1;
        int count = 1;
        int index;
        for( index = 1; index < majorityMark; index++) {
            if(nums[index] == nums[index-1]) {
                count++;
                if(count == majorityMark) {
                    return nums[index];
                }
            }else {
                count = 1;
            }
        }
        return nums[index];
    }


    public int majorityElement2(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int currentIndex = 0;
        int majorityMark = (nums.length/2)+1;

        while((currentIndex+ majorityMark -1) < nums.length ) {
            if(nums[currentIndex] == nums[currentIndex + majorityMark -1]) {
                return nums[currentIndex];
            }
            currentIndex++;
        }

        return nums[currentIndex];
    }



    public int majorityElement3(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);

        return nums[nums.length/2];
    }


    public void rotate(int[] nums, int k) {

        if(k == 0) {
            return;
        }
        if(k > nums.length)
            k = nums.length;

        int[] nums2 = new int[nums.length];
        if (nums.length - k >= 0) System.arraycopy(nums, 0, nums2, k, nums.length - k);

        int j = nums.length -k;
        for(int i = 0; i < k && j< nums2.length; i++) {
            nums2[i] = nums[j++];
        }
        System.arraycopy(nums2, 0, nums, 0, nums.length);
    }


    public void rotate2(int[] nums, int k) {
        k = k% nums.length;
        for(int i = 1; i <=k; i++) {
            rotateRightBy1(nums);
        }
    }

    private void rotateRightBy1(int[] nums) {
        int lastElement = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--) {
            nums[i+1] = nums[i];
        }
        nums[0] = lastElement;
    }


    public void rotate3(int[] nums, int k) {
        if(k == 0) {
            return;
        }
        k = k%nums.length;
        int newIndex;
        int[] nums2 = new int[nums.length];
        int maxIndex = nums2.length-1;
        for(int i = 0; i <= maxIndex; i++) {
            newIndex = (i + k <= maxIndex)? i + k: (i + k-maxIndex-1);
            nums2[newIndex] = nums[i];
        }
        System.arraycopy(nums2, 0, nums, 0, nums.length);
    }

    public int maxProfit(int[] prices) {
        if(prices.length <2) {
            return 0;
        }
        int purchasingDay =0, sellingDay = 1, maxProfit = 0;
        for(purchasingDay = 0; purchasingDay < prices.length; purchasingDay++) {
            int tempProfit = prices[sellingDay] -prices[purchasingDay];
            if(tempProfit > maxProfit) {
                maxProfit = tempProfit;
                 sellingDay = purchasingDay+1;
            } else if (tempProfit <= 0) {
                sellingDay = purchasingDay+1;
            }
        }

        return maxProfit;
    }


    public int maxProfit2(int[] prices) {
        if(prices.length <2) {
            return 0;
        }
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < buyingPrice) {
                buyingPrice = price;
            }
            maxProfit = Math.max(price - buyingPrice, maxProfit);
        }
        return maxProfit;
    }


    public int maxProfit3(int[] prices) {
        int buyingPrice = prices[0];
        int totalProfit = 0;
        for(int price: prices) {
            if(price > buyingPrice) {
                totalProfit += price - buyingPrice;
            }

            buyingPrice = price;
        }
        return totalProfit;
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            indexes.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int anotherNum = target-nums[i];
            int anotherIndex = indexes.getOrDefault(anotherNum, 0);
            if(anotherIndex > i) {
                return new int[]{i, anotherIndex};
            }
        }
        return null;
    }

    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> indexes = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int anotherNum = target-nums[i];
            int anotherIndex = indexes.getOrDefault(anotherNum, -1);
            if(anotherIndex != -1 && anotherIndex != i){
                return new int[]{i, indexes.get(anotherNum)};
            }
           indexes.put(nums[i], i);
        }
        return null;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j <= i+k && j < nums.length; j++) {
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateV2(int[] nums, int k) {
        Map<Integer, List<Integer>> indexMapping = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> temp = indexMapping.getOrDefault(nums[i], new ArrayList<>());

            temp.add(i);
            indexMapping.put(nums[i], temp);
        }

        for(List<Integer> indexes: indexMapping.values()) {
            if(indexes.size() > 1){
                for(int i : indexes) {
                    int t = indexes.stream().filter( j -> j <= k+i && j > i).findFirst().orElse(0);
                    if(t != 0)
                        return true;
                }
            }
            indexes.remove(0);
        }
        return false;
    }


    public boolean containsNearbyDuplicateV3(int[] nums, int k) {
        Map<Integer, Integer> indexMapping = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int firstIndex = indexMapping.getOrDefault(nums[i], -1);
            if(firstIndex == -1)
                indexMapping.put(nums[i], i);
            else
                if(i-firstIndex <=k)
                    return true;
                indexMapping.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicateV4(int[] nums, int k) {
        Map<Integer, Integer> indexMapping = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(indexMapping.containsKey(nums[i]) && (i -indexMapping.get(nums[i])) <=k )
                return true;
            indexMapping.put(nums[i], i);
        }
        return false;
    }


    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int seq = 1;
        int prev = nums[0];
        int res = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                if (nums[i] == prev + 1) {
                    seq++;
                } else{
                    res = Math.max(res, seq);
                    seq = 1;
                }
                prev = nums[i];
            }
        }
        res = Math.max(res, seq);
        return res;
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] result = new int[intervals.length][2];
        result[0] = intervals[0];
        int index = 0;
        for(int i = 1;  i < intervals.length; i++) {
            result[index][0] = Math.min(result[index][0], intervals[i][0]);
            if (result[index][1] >= intervals[i][0]) {
                result[index][1] = Math.max(intervals[i][1], result[index][1]) ;
            }
            else {
                index++;
                result[index] = intervals[i];
            }
        }
        return Arrays.asList(result)
                .subList(0, index + 1)
                .toArray(new int[0][0]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        int i = 0;
        int [][] res = new int[intervals.length+1][2];
        while( i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[i][0] = intervals[i][0] ;
            res[i][1] = intervals[i][1] ;
            i++;
        }
        int initalIndex = i;
        if(initalIndex == intervals.length) {
            res[initalIndex][0] = newInterval[0];
        } else {
            res[initalIndex][0] = Math.min(intervals[initalIndex][0], newInterval[0]);
        }


        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            i++;
        }
        int endIndex= i-1;
        if(i == 0) {
            res[initalIndex][1] = newInterval[1];
            endIndex = 0;
        } else if(i == intervals.length)  {
            res[initalIndex][1] =  newInterval[1];
            endIndex = intervals.length;
        } else {
            endIndex = i-1;
            res[initalIndex][1] = Math.max(intervals[endIndex][1], newInterval[1]);
            endIndex++;
        }
        while(endIndex < intervals.length ) {
            res[initalIndex+1][0] = intervals[endIndex][0];
            res[initalIndex+1][1] = intervals[endIndex][1];
            endIndex++;
            initalIndex++;
        }

        return Arrays.copyOfRange(res, 0, initalIndex+1);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        int[][] result = new int[intervals.length+1][2];
        for(int i = 0 ; i < intervals.length; i++) {
            result[i] = intervals[i];
        }
        result[intervals.length][0] = newInterval[0];
        result[intervals.length][1] = newInterval[1];

        Arrays.sort(result, (o1, o2) -> o2[0]-o1[0]);
        return merge2(result);
    }


    public List summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        int startingNumber = nums[0];
        int nextNumber = nums[0];
        for(int n : nums) {
            if(nextNumber != n) {
                addRange(startingNumber, (nextNumber - 1), result);
                startingNumber = n;
                nextNumber = n+1;
            }else{
                nextNumber++;
            }
        }
        addRange(startingNumber, (nextNumber-1), result );
        return result;
    }

    public List summaryRangesv2(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        int startingNumber = nums[0];
        for(int i = 0; i < nums.length; i++) {
            startingNumber = nums[i];
            while(i+1 < nums.length && nums[i+1] == nums[i]+1 ) {
                i++;
            }
            addRange(startingNumber, nums[i], result );
        }
        return result;
    }

    private static void addRange(int startingNumber, int nextNumber, List<String> result) {
        if (startingNumber == nextNumber) {
            result.add(String.valueOf(startingNumber));
        } else {
            result.add(startingNumber + "->" + nextNumber);
        }
    }

    public int hIndex(int[] citations) {
        int hIndex ;
        Arrays.sort(citations);

        hIndex = citations.length/2 +1;

        if(citations.length%2 == 0)
            hIndex = Math.min(hIndex, citations[citations.length/2 -1]);
        else
            hIndex = Math.min(hIndex, citations[citations.length/2 ]);
        return  hIndex;

    }


    public int hIndexv2(int[] citations) {
        int low=0 , high = citations.length;
        while(low < high){
            int mid = (low+high+1)/2;
            int cnt=0;
            for (int citation : citations)
                if (citation >= mid)
                    cnt++;
            if(cnt >= mid)
                low = mid;
            else
                high =mid-1;
        }
        return low;

    }

    public int[] productExceptSelf(int[] nums) {
        int leftSide = 1;
        int rightSide = 1;
        int prevNumber = 1;
        int [] result = new int[nums.length];
        int res = Arrays.stream(nums).filter(value -> value != 0).findFirst().orElse(1);

        for(int i = 0; i < nums.length ; i++) {
            if (res == 0  && nums[i] != 0) {
                result[i] = 0;
                continue;
            }
            leftSide = leftSide * prevNumber;
            if(i == 0 || nums[i] == 0) {
                rightSide = 1;
                for(int k = i+1; k < nums.length ; k++) {
                    rightSide = rightSide * nums[k];
                }
            }else {
                rightSide = rightSide/nums[i];
            }

            result[i] = leftSide * rightSide;
            prevNumber = nums[i];
        }
        return result;
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {

        int startingStation = 0;
        int i = 0;
        while (i < gas.length) {
            int t1= Math.abs(gas[startingStation]-cost[startingStation]) ;
            int t2= Math.abs(gas[i]-cost[i]);

           startingStation =  t2> t1? i: startingStation;
            i++;
        }
        int gasInTank = gas[startingStation];
        int currentStation = startingStation;
        int nextStation = returnNextStation(currentStation, gas.length);
        while (nextStation != startingStation && gasInTank > 0) {
            gasInTank = gasInTank - cost[currentStation] + gas[nextStation];
            currentStation = returnNextStation(currentStation, gas.length);
            nextStation = returnNextStation(nextStation, gas.length);
        }
        if(nextStation == startingStation && gasInTank >=cost[returnPrevStation( startingStation, gas.length)])
              return startingStation;
        return  -1;
    }

    private int returnNextStation(int currentDay, int totalDay) {
        return (currentDay == totalDay-1)? 0: currentDay+1;
    }

    private int returnPrevStation(int currentDay, int totalDay) {
        return (currentDay == 0)? totalDay-1: currentDay-1;
    }


    public int canCompleteCircuitV2(int[] gas, int[] cost) {

        int[] diff = new int[gas.length];
        List<Integer> indexes = new ArrayList<>();
        int i = 0;
        int totalSum = 0;
        while (i < gas.length) {
            int t2= gas[i]-cost[i];
            diff[i] = t2;
            totalSum+=t2;
            if(t2 >= 0) {
                indexes.add(i);
            }
            i++;
        }
        if(totalSum < 0) {
            return  -1;
        }

        for(int index: indexes) {
            int sum = 0;
            for(int j = index; j < gas.length; j++) {
                sum+= diff[j];
                if(sum < 0)
                    break;
            }
            for(int j = 0; j < index; j++) {
                sum+= diff[j];
                if(sum < 0)
                    break;
            }
            if(sum >=0)
                return index;
        }

        return  -1;
    }


    public int canCompleteCircuitV3(int[] gas, int[] cost) {

        int[] diff = new int[gas.length];
        List<Integer> indexes = new ArrayList<>();
        int i = 0;
        int totalSum = 0;
        while (i < gas.length) {
            int t2= gas[i]-cost[i];
            totalSum+=t2;
            diff[i] = totalSum;
            if(t2 >= 0) {
                indexes.add(i);
            }
            i++;
        }
        if(totalSum < 0) {
            return  -1;
        }

        int leftSum = 0, rightSum = 0;
        for(int index: indexes) {
            for(int j = index; j < gas.length; j++) {
                rightSum+= diff[j];
                if(rightSum < 0)
                    break;
            }
            for(int j = 0; j < index; j++) {
                leftSum+= diff[j];
                if(leftSum < 0)
                    break;
            }
            if(leftSum+ rightSum >=0)
                return index;
        }

        return  -1;
    }


    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for(int j = candies.length-2; j >=0; j--) {
            if(ratings[j] > ratings[j+1] && candies[j] <= candies[j+1]) {
                candies[j] = candies[j+1]+1;
            }
        }
        return Arrays.stream(candies).sum();

    }

    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int jump = 0;
        int i = 0;
        int boundary = 0;
        while(i< nums.length) {
            int temp = Math.max(boundary, i+ nums[i]);
            if(nums[i] != 0){
               jump++;
            }

            if(boundary >= nums.length-1) {
                return jump;
            }
            i++;
        }
        return nums.length;
    }


    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int lastIndex = arr.size()-1;

        Integer [] temp = new Integer[lastIndex+1];

        for(int i = 0 ; i <= lastIndex; i++) {
            int  t= findNewIndex(i, d, lastIndex);
            temp[t] = arr.get(i);
        }
        return Arrays.asList(temp);
    }


    private static int findNewIndex(int currentIndex, int d, int lastIndex) {
        if(currentIndex -d < 0) {
            return lastIndex -(d-currentIndex) +1;
        } else {
            return currentIndex -d;
        }
    }

    public static long largestRectangle(List<Integer> h)
    {
        Collections.sort(h);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<h.size();i++)
        {
            if(max<(h.get(i)*(h.size()-i)))
                max=(h.get(i)*(h.size()-i));
        }

        return max;
    }


    public boolean containsDuplicate(int[] nums) {
        /*
        nums = [1,2,3,1]

            1  2  2 3





            1,1,1,3,3,4,3,2,4,2]

            1 1 1 2 2 3 3 3 4 4 5


    5
         */

        Set<Integer> hset = new HashSet<>();
        for(int n : nums) {
            if (hset.contains(n))
                return true;
            hset.add(n);
        }
        return false;
    }

    public boolean isAnagram(String s, String t) {
/*
      s = "anagram", t = "nagaram"
      1. length is same
      2. chars count is same
                array
                HashMap

       int[] chars = new int[26];
       for(char ch: s.toCharArray()) {
            chars[ch-'a]++;
       }
       for(char ch: t.toCharArray()) {
            chars[ch-'a]--;
       }
       for(int n: chars) {
       if(n != 0)
        return false;
       }
       return true;


 */

        int[] chars = new int[26];
        for(char ch: s.toCharArray()) {
            chars[ch-'a']++;
        }
        for(char ch: t.toCharArray()) {
            chars[ch-'a']--;
        }
        for(int n: chars) {
            if(n != 0)
                return false;
        }
        return true;
    }

    public int[] topKFrequent(int[] nums, int k) {
    /*
    Map<Integer, Integer> count = new HashMap();
    for(int n: nums) {
        int count = count.getOrDefault(n, 0);
        count.put(n, count+1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>>countQ =  new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
    for(Entry entry : count) {
        countQ.add(entry);
    }
    int[] ans = new int[k];
    int t = 0;
    while(t< k) {
    ans[t]= countQ.poll().getKey();
        }
        return ans;
     */
        Map<Integer, Integer> count = new HashMap();
        for(int n: nums) {
            int t = count.getOrDefault(n, 0);
            count.put(n, t+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>>countQ =  new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        countQ.addAll(count.entrySet());
        int[] ans = new int[k];
        int t = 0;
        while(t< k) {
            ans[t]= countQ.poll().getKey();
            t++;
        }
        return ans;
    }


    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid = (start+ end)/2;
        while(mid >= 0 && mid < nums.length) {
            if(nums[mid] == target) {
                return mid;
            }
            if(target < nums[mid]){
                end = mid-1;
            }
            if(target > nums[mid]) {
                start = mid+1;
            }
            if(start== end && target != nums[start]) {
                return -1;
            }
         if(start == end && target == nums[start]) {
            return start;
    }

            mid = Math.floorDiv(end+start, 2);
        }
        return -1;
    }


    public int minEatingSpeed(int[] piles, int h) {
       /*
       [3,6,7,11] 8
       sum = 27
       k*8>= 27
       k = 27/8 4
30,11,23,4,20  6
5
       */


    Arrays.stream(piles).max().orElse(0);
        double sum =   Arrays.stream(piles).sum();
        int k = (int) ((sum%h)!=0? (sum/h)+1: (sum/h));

        int t = h+1;
        while(t > h) {
            t = 0;
            for(int n: piles ) {
                t +=(n%k)!=0?(n/k)+1: (n/k);
            }
            if(t > h) {
                k++;
            }
        }
        return k;
    }

}

