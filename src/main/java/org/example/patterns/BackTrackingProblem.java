package org.example.patterns;

import java.util.*;
import java.util.function.BinaryOperator;

public class BackTrackingProblem {

    List<List<Integer>> findSubsets(int [] nums) {
        /*
        [1,2,3]

  1
  2, 12,
  3, 13, 23, 123
  4 14 24 124 34 134 234 1234

  1st approach
  List<List<Integer>>  result = new ArrayList();
  for(int num: nums) {
    int currentSize = result.size();
    result.add(num);
    for(int i = 0; i < currentSize; i++) {
        List<> t =  new ArrayList();
        t.addAll(result.get(i));
        t.add(num);
        result.add(t);
    }
  }
  return result;
}

2nd approach

 n = result(n-1)+n , result(n-2)+n ....... result(1)+n




         */

        List<List<Integer>>  result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int num: nums) {
            int currentSize = result.size();
            List<Integer> currentNumber = new ArrayList<>();
            currentNumber.add(num);
            result.add(currentNumber);
            for(int i = 1; i < currentSize; i++) {
                List<Integer> t = new ArrayList<>(result.get(i));
                t.add(num);
                result.add(t);
            }
        }
        return result;
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
        candidates = [2,3,6,7], target = 7


        2  2 22 222 2222  ..
        3  23 223 2223 ...
        6 26 226 2226 22226.....   236 2236 222236.......
        7


2  2 22 222 23 223 26

3




     List<List<Integer>> result = new ArrayList();


     helper(List<List<Integer>> result, target, List<Integer> currentCombination, int[] candidates) {
        if(target  < 0)
            return;
        if(target ==0) {
             List<Integer> temp = new ArrayList(currentCombination);
            result.add(temp);
            return;
        }
        for(int n : candidates) {
            currentCombination.add(n);
            helper(result, target-n, temp, candidate);
            currentCombination.remove(n);
        }
     }

         */
        List<List<Integer>> result = new ArrayList<>();
        helper(result, target, new ArrayList<>(), candidates, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, int target, List<Integer> currentCombination, int[] candidates, int start) {
        if(target  < 0)
            return;
        if(target ==0) {
            List<Integer> temp = new ArrayList<>(currentCombination);
            result.add(temp);
            return;
        }
        for(int i = start; i< candidates.length; i++ ) {
            if(candidates[i] + candidates[start] > target)
                continue;
            currentCombination.add(candidates[i]);
            helper(result, target-candidates[i], currentCombination, candidates, i);
            currentCombination.remove(currentCombination.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        /*
        nums = [1,2,3]
      1 23 32
      2 13 31
      3 12 21

      1 2 3
        1 2



      helper(List<List<Integer>> result, List<Integer> currentCombinatons,  int nums) {
      if(currentCombinatons.size() == nums.length) {
        result.add(new ArrayList<>(currentCombinatons)
        return;

      }
        for(int i = start; i < nums.length; i++){
            if(
            currentCombinatons.add(nums[i]);
            helper(result, currentCombinatons, i+1, nums);

          }
      }
         */
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(result, new ArrayList<>(), nums);
        return result;
    }

    void permuteHelper(List<List<Integer>> result, List<Integer> currentCombinatons, int[] nums) {
        if(currentCombinatons.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(currentCombinatons);
            result.add(temp);
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (currentCombinatons.contains(nums[i]))
                return;
            currentCombinatons.add(nums[i]);
            permuteHelper(result, currentCombinatons, nums);
            currentCombinatons.remove(currentCombinatons.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        nums = [1,2,2 4, 4, 4]

          1 1 []   2

          2   2 12
          2  122   22   6   c 4 p 2
          4 4 14 24 124 1224 224 12
          4 44 244 144 1244 2244
          4                     p 12 c 17



[[],[1],[1,2],[1,2,2],[2],[2,2]]
            Arrays.sort(nums);
            int[] visited = new int[9];
            List<List<Integer>> result = new ArrayList<>();
            int prevIndex = 0;
            for(int i = 0; i < nums.length; i++) {
               int currentSize = result.size();
               if(visited[nums[i]== true) {
                    for(int j = prevIndex; j < currentSize; j++) {
                    result.add(new ArrayList<>(result.get(j).add(nums[i);
                }else {
                    for(int j = 0; j < currentSize; j++) {
                    result.add(new ArrayList<>(result.get(j).add(nums[i);
                }

                prevIndex = currentSize;
                visited[i] = true;
               }


            }

        }

         */

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> visited = new HashSet<>(19);
        int prevIndex = 0;
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int lastIndex = result.size()-1;
            if(visited.contains(nums[i])) {
                for(int j = prevIndex+1; j < lastIndex; j++) {
                    List<Integer> temp = new ArrayList<>(result.get(j));
                    temp.add(nums[i]);
                    result.add(temp);
                }
            }else {
                    for(int j = 0; j <= lastIndex; j++) {
                        List<Integer> temp = new ArrayList<>(result.get(j));
                        temp.add(nums[i]);
                        result.add(temp);
                    }
                }
            prevIndex = lastIndex;
            visited.add(nums[i]);
        }
        return result;
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /*
        candidates = [10,1,2,7,6,1,5], target = 8

        1 1 2 5 6 7 10

            start = 0 i = 0 1: 11 12 15 16 17,
            start = 1 i =1  11, i = 2 112
            start = 2 i = 2  112, i = 3 1125 break
            start 3   i = 3 112:



combinationSum2Helper(int[] candidates, List<List<Integer>> result, List<Integer> currentCombinations, int target, int start) {
    if(target < 0)
        return;
    if(target == 0) {
        if(resul
        result.add(new ArrayList<>(currentCombinations);
        return;
    }
    for(int i = start; i < candidates.length; i++) {
        if(getSumOfCurrentCombinations(currentCombinations) > target) {
            break;
        }
        currentCombinations.add(candidates[i]);
        helper(candidates, result, currentCombinations, target- candidates[i], i+1);
        currentCombinations.remove(currentCombinations.size() -1);
    }
}

int getSumOfCurrentCombinations(List<Integer> currentCombinations) {
  return currentCombinations.stream().reduce(i -> +i);
}
         */


        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, result, new ArrayList<>(), target, 0);
        return result;
    }

    void combinationSum2Helper(int[] candidates, List<List<Integer>> result, List<Integer> currentCombinations, int target, int start) {
        if(target < 0)
            return;
        if(target == 0) {
            result.add(new ArrayList<>(currentCombinations));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] > target)
                break;
            if(i > start && candidates[i] == candidates[i-1])
                continue;
            currentCombinations.add(candidates[i]);
            combinationSum2Helper(candidates, result, currentCombinations, target- candidates[i], i+1);
            currentCombinations.remove(currentCombinations.size() -1);
        }
    }

    public boolean exist(char[][] board, String word) {
        /*
        board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"

        A B C E
        S F C S
        A D E E

        A : AB AS
        B: BC BF BA
        C : CE CB CC
        S : SF SA AA
        F :


         */



        return false;
    }


    public List<List<String>> partition(String s) {
/*
 s = "aab"

 a : a   aa aab
 a  : a aa ab
 b : b
 */

        return Collections.EMPTY_LIST;
    }

    public List<String> letterCombinations(String digits){

        // Replace this placeholder return statement with your code
        Map<Character, String[]> digitsMapping = new HashMap<>();
        digitsMapping.put('1', new String[]{""});
        digitsMapping.put('2', new String[]{"a", "b", "c"});
        digitsMapping.put('3', new String[]{"d", "e", "f"});
        digitsMapping.put('4', new String[]{"g", "h", "i"});
        digitsMapping.put('5', new String[]{"j", "k", "l"});
        digitsMapping.put('6', new String[]{"m", "n", "o"});
        digitsMapping.put('7', new String[]{"p", "q", "r", "s"});
        digitsMapping.put('8', new String[]{"t", "u", "v"});
        digitsMapping.put('9', new String[]{"w", "x", "y", "z"});

        List<String> result = new ArrayList();
        helper(digitsMapping, result, digits, new StringBuilder(), 0);

        return result;
    }

    void helper(Map<Character, String[]> digitsMapping, List<String> result, String digits, StringBuilder current, int index){
        if(current.length() == digits.length() || index >= digits.length()){
            result.add(current.toString());
            return;
        }

        String[] chars = digitsMapping.get(digits.charAt(index));
        for(String s: chars ){
            current.append(s);
            helper(digitsMapping, result, digits, current, index+1);
            current.deleteCharAt(current.length()-1);
        }

    }

    public ArrayList<String> validParanethesis(int n) {

        // Replace this placeholder return statement with your code

        ArrayList<String> result = new ArrayList<String>();
        backTrack(result, n, new StringBuilder(), 0, 0);

        return result;
    }
    void backTrack(ArrayList<String> result, int n, StringBuilder current, int open, int close)
    {
        if(open == n && close == n){
            result.add(current.toString());
            return;
        }
        if(open < n){
            current.append("(");
            backTrack(result, n, current, open+1, close);
            current.deleteCharAt(current.length()-1);
        }
        if(close > open){
            current.append(")");
            backTrack(result, n, current, open, close+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}
