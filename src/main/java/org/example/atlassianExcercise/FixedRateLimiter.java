package org.example.atlassianExcercise;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


/*
rolling window

1 1
1 2

Queue[3]: APIs

 */
class RollingWindowRateLimiter{
    private final int limit;
    private final int interval;
    HashMap<Integer, userDataRolling> apiData = new HashMap<>();
    public  RollingWindowRateLimiter(int limit, int interval) {
        this.limit = limit;
        this.interval = interval;
    }

    public boolean process(int user, int time) {
        userDataRolling userData = apiData.getOrDefault(user, new userDataRolling(limit, interval));
        apiData.put(user, userData);
        return userData.process(time);
    }
}

class userDataRolling {
    Queue<Integer> apis;
    int limit;
    int timePeriod;
    public userDataRolling(int limit, int interval){
        apis = new LinkedList<>();
        this.limit = limit;
        this.timePeriod = interval;
    }

    public boolean process(int time) {
        if(apis.size() >=limit){
            if(time -apis.peek() >= timePeriod) {
                apis.poll();
            }else {
                return false;
            }
        }
        apis.offer(time);
        return true;
    }
}

public class FixedRateLimiter {
    private final int interval;
    private final int limit;
    HashMap<Integer, UserData> apiData = new HashMap<>();

    public FixedRateLimiter(int interval, int limit) {
        this.interval = interval;
        this.limit = limit;
    }

    public boolean process(int userId, int time) {
        UserData userData = apiData.getOrDefault(userId, new UserData(time));
        if (time - userData.timePeriod >= interval) {
            userData.reset(time);
        }
        if (userData.apiCount >= limit) {
            return false;
        }
        userData.process();
        apiData.put(userId, userData);
        return true;
    }
}

class UserData {
    int timePeriod;
    int apiCount;

    public UserData(int startTime) {
        this.timePeriod = startTime;
    }
    public void process(){
        apiCount++;
    }
    void reset(int time) {
        apiCount =0;
        timePeriod = time;
    }

}


