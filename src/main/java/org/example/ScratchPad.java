package org.example;

import java.util.*;

public class ScratchPad {
    class Tweet implements  Comparable<Tweet>{
        public int tweetID;
        public int timeStamp;
        public Tweet(int tweetID, int timeStamp) {
            this.tweetID = tweetID;
            this.timeStamp =  timeStamp;
        }


        @Override
        public int compareTo(Tweet o) {
            return o.timeStamp;
        }
    }

    void sample() {
    }

    int sampleMath(){

        List<String> t = new ArrayList<>();
        Set<Character> temp = new HashSet<>();

        temp.stream().toList();
        t.toArray();
        String str = "";
        StringBuilder sb = new StringBuilder();


        return (int) Math.round(Math.random()*6+1);

        int[] temp = new int[10];
        /* calculate sum of all elements of array. */
        Arrays.stream(temp).sum();

        str.


    }


    }
    /*
    ,
                5,'E', 6,'F', 7,'G', 8,'H', 9,'I', 10,'J', 11,'K', 12,'L', 13,'M',
                14,'N', 15,'O', 16 ,'P', 17,'Q', 18,'R', 19, 'S',20,'T', 21,'U', 22, 'V',
                23, 'W',24,'X', 25,'Y', 26,'Z'
     */
