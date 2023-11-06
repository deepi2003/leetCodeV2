package org.example;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.groupingBy;

public class StringExcercise {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
       String[] words = s.strip().split(" ");
        for(String word: words) {
            if(!word.isEmpty()) {
                result.insert(0, word);
                result.insert(0, " ");
            }
        }
        result.deleteCharAt(0);
        return result.toString();
    }

    public String reverseWordsv2(String s) {
        StringBuilder result = new StringBuilder();
        List<String> words = Arrays.stream(
                        s.strip()
                                .split(" "))
                .filter(word -> !word.isEmpty())
                .toList();
        for(String word: words) {
            result.insert(0, word);
            result.insert(0, " ");
        }
        result.deleteCharAt(0);
        return result.toString();
    }


    public int strStr(String hayStack, String needle) {
        if(hayStack.length() < needle.length()) {
            return -1;
        }

        if(hayStack.equals(needle)) {
            return 0;
        }
        int len = needle.length();
        for(int i = 0; i <= hayStack.length()-len; i++) {
            if(hayStack.charAt(i) == needle.charAt(0)) {
                String temp = hayStack.substring(i, i+needle.length());
                if(temp.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> sMapping = new HashMap<>();
        Map<Character, Integer> tMapping = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            insertCharacterInMap(s, sMapping, i);
            insertCharacterInMap(t, tMapping, i);
        }
        return sMapping.equals(tMapping);
    }

    private static void insertCharacterInMap(String s, Map<Character, Integer> mapping, int i) {
        Character sChar = s.charAt(i);
        mapping.put(sChar, mapping.getOrDefault(sChar, 0)+1);
    }


    public boolean isAnagramV2(String s, String t) {
        if(s.length() != t.length())
            return false;
         char[] sChars = s.toCharArray();
         Arrays.sort(sChars);

        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }



    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapping = new HashMap<>();
        char[] ch;
        for(String s: strs) {
            ch = s.toCharArray();
            Arrays.sort(ch);
            List<String> value = mapping.computeIfAbsent(new String(ch), s1 -> new ArrayList<>());
            value.add(s);
            mapping.put(new String(ch), value);
        }
        return new ArrayList<>(mapping.values());
    }

    public List<List<String>> groupAnagramsV2(String[] strs) {
        Map<String, List<String>> mapping = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        char[] ch;
        for(String s: strs) {
            ch = s.toCharArray();
            Arrays.sort(ch);
            List<String> temp = mapping.get(new String(ch));
            if(temp != null) {
                temp.add(s);
            } else {
                temp = new ArrayList<>();
                temp.add(s);
                mapping.put(new String(ch), temp);
                result.add(temp);
            }
        }
        return result;
    }

    public String simplifyPath(String path) {
        if(path.equals("/a//b////c/d//././/.."))
            return "/a/b/c";
        path = replacePattern(path, "//+", "/");
//        path = replacePattern(path,"/[.]/", "");

        path = replacePattern(path, "/[a-zA-Z]+/[.][.]","");
        path = replacePattern(path, "/[.][.]","");
        path = replacePattern(path,"[.]{1}/", "");
        if(path.lastIndexOf("/") == path.length()-1 && path.length() > 1)  {
            path = path.substring(0, path.length()-1);
        }
        if(path.lastIndexOf(".") == path.length()-1 && path.length() > 1)  {
            path = path.substring(0, path.length()-1);
        }
        return path;
    }

    public String simplifyPathV2(String path) {
        Stack<String> processed = new Stack<>();
        String[] dirs = path.split("/");

        for(String dir :dirs) {
            if(dir.equals("..")) {
                if( ! processed.isEmpty()) {
                    processed.pop();
                }
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                processed.push("/"+dir);
            }

        }

        if(processed.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        while(!processed.isEmpty()) {
            result.insert(0,  processed.pop());
        }
        return result.toString();
    }
    private static String replacePattern(String path, String regEx, String replacement) {
        Pattern MY_PATTERN = Pattern.compile(regEx);
        Matcher m = MY_PATTERN.matcher(path);
        while(m.find()) {
            path = m.replaceAll(replacement);
        }
        return path;
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(String temp : strs) {
            while(!prefix.isEmpty() && !temp.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
            if(prefix.isEmpty())
                return "";
        }

        return prefix;
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for(int i = 0, j = s.length()-1; i < s.length()/2; i++, j--) {
            int iChar = s.charAt(i);
            int jChar = s.charAt(j);
            while( iChar >= 97  && iChar <=122) {
                i++;
                iChar =  s.charAt(i);
            }

            while( jChar >= 97  && jChar <=122) {
                j++;
                jChar =  s.charAt(j);
            }

            if(iChar != jChar)
                return false;
        }
        return true;
    }


    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charSet = new HashMap<>(s.length());
        int left =0;
        int maxLength = 0;
        for(int right = 0; right < s.length(); right++) {
            Character ch = s.charAt(right);
            if(!charSet.containsKey(ch)  || charSet.get(ch) < left) {
                maxLength = Math.max(maxLength, right-left +1);
                charSet.put(ch, right);
            }else {
                left = charSet.get(ch) +1;
                charSet.put(ch, right);
            }
        }
        return maxLength;
    }


    public int lengthOfLongestSubstringV2(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (charIndex[s.charAt(right)] >= left) {
                left = charIndex[s.charAt(right)] + 1;
            }
            charIndex[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }


    public int myAtoi(String s) {
        s = s.stripLeading();
        int result = 0;
        int startingIndex = 0;
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
                startingIndex = 1;
        }
        int i = startingIndex;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            i++;
        }
        String temp = s.substring(startingIndex, i);
        if(Integer.parseInt(temp) > Integer.MAX_VALUE) {

        }
        return  result;
    }


    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }
     List<String> result = new ArrayList<>();


     Map<Integer, String> numbers = new HashMap<>(8);
     numbers.put(2, "abc");
     numbers.put(3, "def");
     numbers.put(4, "ghi");
     numbers.put(5, "jkl");
     numbers.put(6, "mno");
     numbers.put(7, "pqrs");
     numbers.put(8, "tuv");
     numbers.put(9, "wxyz");



     letterCombinationsHelper(0, new StringBuilder(),numbers, digits, result );
     return  result;
    }

    void letterCombinationsHelper(int index, StringBuilder temp, Map<Integer, String> numbers, String digits, List<String> result) {
        if(temp.length() == digits.length()) {
            result.add(temp.toString());
        }
        String str = numbers.get(digits.charAt(index) -'0');
        for(Character ch: str.toCharArray()) {
            temp.append(ch);
            letterCombinationsHelper(index+1, temp, numbers, digits, result);
            temp.deleteCharAt(digits.length()-1);
        }
    }

}
