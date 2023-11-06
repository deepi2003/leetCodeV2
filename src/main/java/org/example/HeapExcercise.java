package org.example;

import java.util.*;
import java.util.stream.Collector;

public class HeapExcercise {

    public static int cookies(int k, List<Integer> A) {
            // Write your code here
        PriorityQueue<Integer> cookies = new PriorityQueue<>();
        cookies.addAll(A);
        int iteration  = 0;
        while(cookies.peek() < k && cookies.size() >=2) {
            int cookie1 = cookies.remove();
            int cookie2 = cookies.remove();
            cookies.add(cookie1 + 2*cookie2);
            iteration++;
        }
        if(cookies.peek() < k) {
            return -1;
        }

        return  iteration;
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((o1, o2) -> (int)
                ((Math.pow(o1[0], 2) + Math.pow(o1[1], 2))
                        - (Math.pow(o2[0], 2) + Math.pow(o2[1], 2))));

        for(int[] point : points) pq1.offer(point);

        int[][] res = new int[k][2];
        for(int i =0; i <k; i++){
            res[i] = pq1.poll();
        }
        return res;
    }

    public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for(int n : stones) pq.add(n);
        while(pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            int s3 = Math.abs(s1-s2);
            if( s3!= 0) {
                pq.offer(s3);
            }
        }
        int res = pq.poll();
        return res;
    }

    static class KthLargest {

        int k;
        PriorityQueue<Integer> stream;
        int kItem =0;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            stream = new PriorityQueue<>();
            for(int n : nums) {
                this.add(n);
            }

        }

        public int add(int val) {
            stream.offer(val);
            if(stream.size() > k)
                stream.poll();
            return stream.peek();
        }
    }



}
