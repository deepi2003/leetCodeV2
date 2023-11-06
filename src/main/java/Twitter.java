import java.util.*;


public class Twitter {

    Map<Integer, PriorityQueue<Tweet>> userTWeets = new HashMap();
    Map<Integer, Set<Integer>> followeeIDs = new HashMap();
    static int timeStamp = 0;
    class Tweet implements Comparable<Tweet>{
        int tweetID;
        int timeStamp;
        Tweet(int tweetID, int timeStamp) {
            this.tweetID = tweetID;
            this.timeStamp =  timeStamp;
        }
        @Override
        public int compareTo(Tweet o) {
            return o.timeStamp;
        }
    }
    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        PriorityQueue<Tweet> ts = userTWeets.getOrDefault(userId,new PriorityQueue());
        ts.add(new Tweet(tweetId, timeStamp++));
        if(ts.size() > 10) ts.poll();
        userTWeets.put(userId, ts);
    }

    void addTWeetInTimeline(int userID, PriorityQueue<Tweet> pq ){
        PriorityQueue ts = userTWeets.get(userID);
        if(ts != null){
            Iterator<Tweet> it = ts.iterator();
            while(it.hasNext()) {
                pq.add(it.next());
                if(pq.size() > 10) pq.poll();
            }
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue pq = userTWeets.getOrDefault(userId, new PriorityQueue());
        PriorityQueue<Tweet> temp = new PriorityQueue<>(Comparator.comparingInt(a -> a.timeStamp));
        temp.addAll(pq);
        Set flrs = followeeIDs.get(userId);
        if(flrs != null) {
            Iterator<Integer> it = flrs.iterator();
            while(it.hasNext()) {
                addTWeetInTimeline(it.next(), temp);
            }
        }
        int[] res = new int[temp.size()];
        for(int i = temp.size()-1; i >=0; i--)
            res[i] = temp.poll().tweetID;
        return Arrays.stream(res).boxed().toList();
    }

    public void follow(int followerId, int followeeId) {
        Set flrs = followeeIDs.getOrDefault(followerId, new HashSet<Integer>());
        flrs.add(followeeId);
        followeeIDs.put(followerId, flrs);
    }

    public void unfollow(int followerId, int followeeId) {
        Set flrs = followeeIDs.get(followerId);
        if(flrs != null) {
            flrs.remove(followeeId);
        }

    }
}