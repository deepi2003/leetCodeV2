package org.example.patterns;

import java.util.*;

public class SlidingWindow {
    List<int[]> housing(int[] nums, int target) {
        /*{

        1,3,2,1,4,1,3,2,1,1

         */
        List<int[]> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        int smallestWindow = Integer.MAX_VALUE;
        int[] temp = new int[2];
        while(right < nums.length && right >= left) {
            sum += nums[right];
            while(sum > target && right > left) {
                sum -=nums[left];
                left++;
            }
            if(sum == target) {
                result.add(new int[]{left, right});
                int oldSmallestWindow = smallestWindow;
                smallestWindow = Math.min(smallestWindow,right-left);
                if(oldSmallestWindow != smallestWindow) {
                    temp[0] = left;
                    temp[1] = right;
                }
                sum -=nums[left];
                left++;
            }
            right++;
        }
        System.out.println(String.format("Smallest window: %d- %d ",temp[0], temp[1]));
        return result;
    }

    List<int[]> housingWithNegative(int[] nums, int target) {
        /*{
        0 1 2 3  4 5 6 7  8 9 10 11
        1,3,2,1,-4,4,1,3,-2,2,1,-1

        left 0 1 2
        right 0 1 2 3 4 5 6 7 8
        sum 1 4 6 7 3 7    10   9  6 4
0, 6
2-10

         */
        List<int[]> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        int smallestWindow = Integer.MAX_VALUE;
        int[] temp = new int[2];
        while(right < nums.length && right >= left) {
            sum += nums[right];
            while(sum > target && right > left) {
                if(nums[left] < 0) {
                    sum += nums[left];
                }else {
                    sum -=nums[left];
                }
                left++;
            }
            if(sum == target) {
                result.add(new int[]{left, right});
                int oldSmallestWindow = smallestWindow;
                smallestWindow = Math.min(smallestWindow,right-left);
                if(oldSmallestWindow != smallestWindow) {
                    temp[0] = left;
                    temp[1] = right;
                }
                sum -=nums[left];
                left++;
            }
            right++;
        }
        System.out.println(String.format("Smallest window: %d- %d ",temp[0], temp[1]));
        return result;
    }


    String largestSubStringWithoutRepeatingChars(String input) {
        /*
         0 1 2 3 4 5 6 7 8 9 10 11 12
         p r a t e e k b h a i  y  a

left  5
right 0 1 2 3 4 6 7 8
result ekba
len - 5
int [] pos :
         p - 0
         r - 1
         a - 2
         t - 3
         e - 5
         k - 6
         b - 7
         */

        String result = "";
        int left = 0;
        int right = 0;
        int[] charPos = new int[26];
        while(right < input.length() && right >= left) {
            char ch = input.charAt(right);
            if(charPos[ch -'a'] >= left) {
                if((right-left) > result.length()) {
                    result = input.substring(left, right);
                }
                left = charPos[ch -'a'] +1;
            }
            charPos[ch- 'a'] = right;
            right++;
        }
        return result;
    }


    String stringWindow(String hayStack, String needle) {

        /*
         0 1 2 3 4 5 6 7 8 9 10
         h e l l o _ w o r l d
         lole

         left 0 1 2
         right 0 4

         needed:
         l 2
         o 1
         e 1

         boolfound :
         l found
         o found
         l found
         e found

         charPos
         e 1
         l 3
         o 4

         */

        Map<Character, Integer> pattern = new HashMap<>();
        Map<Character, Integer> input = new HashMap<>();
        for(char ch : needle.toCharArray()) {
            int count = pattern.getOrDefault(ch, 0);
            pattern.put(ch, count+1);
        }
        int left = 0, right = 0;
        String result = hayStack;
        while(right < hayStack.length()) {
            char ch = hayStack.charAt(right);
            int count = input.getOrDefault(ch, 0);
            input.put(ch, count+1);
            while(match(input, pattern)) {
                if((right-left) < result.length()) {
                    result = hayStack.substring(left, right+1);
                }
                int t = input.get(hayStack.charAt(left));
                input.put(hayStack.charAt(left), t-1);
                left++;
            }
            right++;
        }
        return result;
    }

    boolean match(Map<Character, Integer> input, Map<Character, Integer> pattern) {
        for(Map.Entry<Character, Integer> entry: pattern.entrySet()) {
            Integer count = input.get(entry.getKey());
            if(count == null || count < entry.getValue())
                return false;
        }
        return true;
    }

    String smallestWindow(String str){

        /*
        0 1 2 3 4 5 6 7 8 9 10 11 12 13
        a a b c b c d b c a a  a  d  z
left  7
right 13
index 13
charpos
a 11
b 7
c 8
d 12
z 13

window = left - right


         */

        int left = 0, right = 0, index = 0;
        HashMap<Character, Integer> charPos = new HashMap<>();
        while(index < str.length()) {
            char ch = str.charAt(right);
            if(charPos.get(ch) != null) {
                charPos.put(ch, index);
                int oldLeft = left;
                left = charPos.values().stream().min(Comparator.comparingInt(o -> o)).orElse(0) +1;
                if(oldLeft != left) {
                    right = index;
                    left =oldLeft;
                }
            } else {
                right = index;
            }
            charPos.put(ch, index);
            index++;
        }
        return str.substring(left, right+1);

    }

    String smallestWindowV2(String str){

        /*
        0 1 2 3 4 5 6 7 8 9 10 11 12
        a a b c b c d b c a a  a  d

        left 6
        right 0 1 2 3 4 5 6 7 8 9
        minPos 0
        charpos
        a
        b 7
c 8
d 6

result = left-right
         */

        int left = 0, right = 0;
        HashMap<Character, Integer> charPos = new HashMap<>();
        while(right < str.length()) {
            char ch = str.charAt(right);
            charPos.put(ch, right);
            right++;
        }
        int startPos = charPos.values().stream().min(Comparator.comparingInt(o -> o)).orElse(0);
        int endPos = charPos.values().stream().max(Comparator.comparingInt(o -> o)).orElse(str.length()-1) +1;
        return str.substring(startPos, endPos);

    }


    public List<String> findRepeatedDnaSequences(String s) {
        /*

        AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT


       temp : AAAAACCCCC
       left 1
       right 10

       result

         */
        int left = 0, right = 0;

        return Collections.EMPTY_LIST;
    }
}
