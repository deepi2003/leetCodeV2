package org.example;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class HashMapExcercise {

    public int romanToInt(String input) {
        int result = 0;
        Map<Character, Integer> romanToNumberMapping = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);

        for(int i = 0;  i< input.length(); i++) {
            char ch = input.charAt(i);
            int temp;
            if(i < input.length()-1) {
                char nextChar = input.charAt(i+1);
                if(ch == 'I' && (nextChar == 'V' || nextChar == 'X')) {
                    temp = romanToNumberMapping.get(nextChar) -1;
                    i++;
                }
                else if(ch == 'X' && (nextChar == 'L' || nextChar == 'C')) {
                    temp =romanToNumberMapping.get(nextChar) -10;
                    i++;
                }
                else if(ch == 'C' && (nextChar == 'D' || nextChar == 'M')) {
                    temp = romanToNumberMapping.get(nextChar) -100;
                    i++;
                }else {
                    temp = romanToNumberMapping.get(ch);
                }
            }else {
                temp = romanToNumberMapping.get(ch);
            }
            result = result+ temp;
        }
        return result;
    }

    public int romanToInt2(String input) {
        int result = 0;
        Map<Character, Integer> romanToNumberMapping = new HashMap<>(Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000));
        Map<String, Integer> rules = new HashMap<>(Map.of(
                "IV", 4,
                "IX", 9,
                "XL", 40,
                "XC", 90,
                "CD", 400,
                "CM", 900));

        for(int i = 0;  i< input.length(); i++) {
            char ch = input.charAt(i);
            int temp;
            if(i < input.length()-1) {
                char nextChar = input.charAt(i+1);
                temp = rules.computeIfAbsent((""+ ch + nextChar), s -> romanToNumberMapping.get(ch));
                if(temp != romanToNumberMapping.get(ch)) {
                    i++;
                }
            }else {
                temp = romanToNumberMapping.get(ch);
            }
            result = result+ temp;
        }
        return result;
    }


    public int romanToInt3(String input) {
        Map<Character, Integer> romanToNumberMapping = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);
        int ans = 0, num = 0;
        for (int i = input.length()-1; i >= 0; i--) {
            num = romanToNumberMapping.get(input.charAt(i));
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }


    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, List<Integer>> patternMap = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            int index = i;
            List<Integer> temp = patternMap.computeIfPresent(ch, (character, indexes) -> {
                 indexes.add(index);
                 return indexes;
            });
            if(temp == null){
                patternMap.put(ch, new ArrayList<>(List.of(index)));
            }
        }

        String[] words = s.trim().split(" ");
        long uniqueWords = Arrays.stream(words).distinct().count();
        if(uniqueWords!= patternMap.size())
            return false;
        for(Map.Entry<Character, List<Integer>> entry : patternMap.entrySet()) {
            List<Integer> indexes = entry.getValue();
            String word = words[indexes.get(0)];
            for(Integer index : indexes) {
                if(!words[index].equals(word))
                    return false;
            }
        }
        return pattern.length() == words.length;
    }


    public boolean wordPatternV2(String pattern, String s) {
        String[] words = s.trim().split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, List<Integer>> patternMap = new HashMap<>();
        HashMap<String, List<Integer>> inputMap = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            addPatternMapEntry(patternMap, ch, i);
            addInputMapEntry(words, inputMap, i);
        }

        long uniqueWords = Arrays.stream(words).distinct().count();
        if(uniqueWords!= patternMap.size())
            return false;
        for(Map.Entry<Character, List<Integer>> entry : patternMap.entrySet()) {
            List<Integer> patternIndexes = entry.getValue();
            List<Integer> inputIndexes = inputMap.get(words[patternIndexes.get(0)]);
            if(!patternIndexes.equals(inputIndexes))
                return false;

        }
        return true;
    }

    private static void addInputMapEntry(String[] words, HashMap<String, List<Integer>> inputMap, int index) {
        List<Integer> temp;
        String word = words[index];
        temp = inputMap.computeIfPresent(word, (str, indexes) -> {
            indexes.add(index);
            return indexes;
        });
        if(temp == null){
            inputMap.put(word, new ArrayList<>(List.of(index)));
        }
    }

    private static void addPatternMapEntry(HashMap<Character, List<Integer>> patternMap, Character ch, int index) {
        List<Integer> temp = patternMap.computeIfPresent(ch, (character, indexes) -> {
            indexes.add(index);
            return indexes;
        });

        if(temp == null){
            patternMap.put(ch, new ArrayList<>(List.of(index)));
        }
    }


    public boolean wordPatternV3(String pattern, String s) {
        String[] words = s.trim().split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> patternMap = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            String word = patternMap.get(ch);
            if(word != null && !word.equals(words[i])) return false;
            if(word == null && patternMap.containsValue(words[i])) return false;

            patternMap.put(ch, words[i]);
        }
        return true;
    }


    public String intToRoman(int num) {
        HashMap<Integer, String>  numberToRoman = new HashMap<>();
        numberToRoman.put(1, "I");
        numberToRoman.put(2, "II");
        numberToRoman.put(3, "III");
        numberToRoman.put(4, "IV");
        numberToRoman.put(5, "V");
        numberToRoman.put(6, "VI");
        numberToRoman.put(7, "VII");
        numberToRoman.put(8, "VIII");
        numberToRoman.put(9, "IX");
        numberToRoman.put(10, "X");
        numberToRoman.put(40, "XL");
        numberToRoman.put(50, "L");
        numberToRoman.put(90, "XC");
        numberToRoman.put(100, "C");
        numberToRoman.put(400, "CD");
        numberToRoman.put(500, "D");
        numberToRoman.put(900, "CM");
        numberToRoman.put(1000, "M");


        StringBuilder result = new StringBuilder();
        Stack<Character> numbers = new Stack<>();

        String temp = String.valueOf(num);
        for(int i = temp.length()-1 ; i >= 0; i--) {
            numbers.push(temp.charAt(i));
        }

        int multiplier = 10*(numbers.size()-1);
        while(numbers.size() > 1) {
            int t = Integer.parseInt(numbers.pop().toString());
           result.append(numberToRoman.get(multiplier).repeat(t));
            multiplier= multiplier/10;
        }
        result.append(numberToRoman.get(Integer.parseInt(numbers.pop().toString())));
        return result.toString();
    }

}
class LRUCache {

    class Node {
        int val;
        Node prev;
        Node next;
        int key;

        public Node(int key, int value) {
            this.key = key;
        }
    }
    HashMap<Integer, Node> cache;
    Queue<Integer> keys;
    int capacity;
    Node lru ;
    Node mru;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        keys = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
//            keys.remove(key);
//            keys.add(key);
            Node temp = cache.get(key);
            addNodeToTail(temp);
            return temp.val;
        }
        return -1;

    }

    private void addNodeToTail(Node temp) {
        temp.prev.next = temp.next;
        mru.next = temp;
        temp.next = null;
    }
}