package org.example;

import java.util.*;

public class GraphExcercise {

    public Node cloneGraph(Node node) {
        if(node ==  null)
            return  null;
        return cloneNode(node, new HashMap<>());
    }

    private Node cloneNode(Node node, HashMap<Node, Node>visited) {
        if(visited.containsKey(node)) {
            return visited.get(node);
        }
        Node newNode = new Node(node.val);
        visited.put(node,newNode);
        for(Node nd : node.neighbors) {
             newNode.neighbors.add(cloneNode(nd, visited));
        }
        return newNode;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length ==1 ) {
            return true;
        }
        HashMap<Integer, List<Integer>> courses = new HashMap<>(numCourses);
        for(int[] course: prerequisites) {
            List<Integer> preq = courses.getOrDefault(course[1], new ArrayList<>());
            preq.add(course[0]);
            courses.put(course[1], preq);
        }

        boolean[] courseInProgress = new boolean[numCourses];
        boolean[] coursesFinished = new  boolean[numCourses];

        for( int course: courses.keySet()) {
            if(!canFinishHelper(course, courseInProgress, coursesFinished,courses))
                return false;
        }
        return true;
    }

    private boolean canFinishHelper(int course, boolean[] courseInProgress,
                                    boolean[] coursesFinished, HashMap<Integer, List<Integer>> courses) {
        if(coursesFinished[course]) {
            return true;
        }
        if(courses.get(course) == null) {
            coursesFinished[course] = true;
            courseInProgress[course] = false;
            return true;
        }
        courseInProgress[course] = true;
        for(int preq: courses.get(course)) {
            if(courseInProgress[preq])
                return false;
            if(!canFinishHelper(preq, courseInProgress, coursesFinished, courses)){
                return false;
            }
        }
        courseInProgress[course] = false;
        coursesFinished[course] = true;
        return true;
    }


    int connectedComponents(int n, int[][] edges){
        List<Integer>[] adj = new List[n];
        int[] nodes = new int[n];

        for(int i = 0; i < edges.length; i++){
            if(adj[edges[i][1]] == null)
                adj[edges[i][1]] = new ArrayList<>();
            adj[edges[i][1]].add(edges[i][0]);
            if(adj[edges[i][0]] == null)
                adj[edges[i][0]] = new ArrayList<>();
            adj[edges[i][0]].add(edges[i][1]);
        }
        for(int i = 0; i < nodes.length; i++){
         if(nodes[i] == 0)
             helper(adj, nodes, i);
        }
        return count;
    }
    int count = 0;
    void helper(List<Integer>[] adj,int[] nodes, int current ){
        if(nodes[current] == 1){
            return;
        }
        nodes[current] = 1;
        List<Integer> neighbors = adj[current];
        for(int n: neighbors){
            if(nodes[n] == 0) {
                helper(adj, nodes, n);
            }
        }
        count++;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }


}
