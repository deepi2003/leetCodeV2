package org.example;

import java.util.*;

public class SetExcercise {
}


class RandomizedSet {

    Set<Integer> hSet;
    public RandomizedSet() {
        hSet = new HashSet<>();
    }

    public boolean insert(int val) {
        return hSet.add(val);
    }

    public boolean remove(int val) {
        return hSet.remove(val);
    }

    public int getRandom() {
        Random random = new Random();

        int x = (hSet.size() > 0)? random.nextInt(hSet.size() -1) : 0;
        return (Integer) hSet.toArray()[x];

    }
}