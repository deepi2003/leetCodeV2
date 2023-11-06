package org.example.atlassianExcercise;

import java.util.*;

public class AtlassianExcercise {

    public String votingSystem(String[] candidates ) {
        /*
        A 3
        C 2
        E 1
        B 4
        D 1
         */
        String maxVotesCandidate = "";
        int maxVotes = 0;
        int[] votes = new int[26];
        for (String str : candidates) {
            votes[str.charAt(0) - 'A']++;
            if (votes[str.charAt(0) - 'A'] > maxVotes) {
                maxVotes = votes[str.charAt(0) - 'A'];
                maxVotesCandidate = str;
            }
        }
        return maxVotesCandidate;
    }

    public Trie getTrie(){
        return new Trie();
    }

}

class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode("/");

    }
    public void insert(String path, String result){
        String[] subPaths = path.split("/");
        TrieNode node = root;
        for(String p: subPaths){
            boolean found = false;
            for(TrieNode c: node.children){
                if(c.value.equals(p)) {
                    node = c;
                    found = true;
                    break;
                }
            }
            if(!found) {
                TrieNode temp = new TrieNode(p);
                node.children.add(temp);
                node = temp;
            }
        }
        node.result = result;
    }

    public String search(String path) {

        String[] subPaths = path.split("/");
        TrieNode node = root;
        for(int i = 0; i< subPaths.length; i++) {
            boolean found = false;
            if (subPaths[i].equals("*")) {
                if (i < subPaths.length - 1) {
                    for (TrieNode c : node.children) {
                        TrieNode t = helper(subPaths[i + 1], c);
                        if (t != null) {
                            node = t;
                            break;
                        }
                    }
                    i = i + 1;
                }else {
                    TrieNode t = helper("", node);
                    if (t != null) {
                        node = t;
                        break;
                    }
                }
                continue;
        }
            for(TrieNode c: node.children){
                if(c.value.equals(subPaths[i])) {
                    node = c;
                    found = true;
                    break;
                }
            }
            if(!found){
                return "";
            }
        }
        return node.result;
    }
    public TrieNode helper(String s, TrieNode node){
        if(node == null){
            return null;
        }
        for(TrieNode t : node.children){
            if(s.contains(t.value)){
                return t;
            }
        }
        return null;
    }
}

class TrieNode{
    List<TrieNode> children;
    String value;
    String result;
    public TrieNode(String value) {
        this.value = value;
        children  = new ArrayList<>();
    }

    public TrieNode() {
        children  = new ArrayList<>();
    }
}


