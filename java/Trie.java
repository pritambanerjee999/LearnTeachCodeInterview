package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() { root = new TrieNode(); }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        if(word.length() == 0) {return;}
        
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(!current.map.keySet().contains(c)) {
                TrieNode node = new TrieNode();
                current.map.put(c, node);
                
            }
            current = current.map.get(c);
        }
        current.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            
            if(current.map.keySet().contains(ch)) {
                current = current.map.get(ch);
            } 
            else {
                return false;
            }
        }
        
        return current.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null) { return false;}
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            
            TrieNode node = current.map.get(ch);
            
            if(node == null) {
                return false;
            }
            
            current = node;
        }
        
        return true;
    }
}

class TrieNode {

    Map<Character, TrieNode> map;
    boolean endOfWord;
    
    TrieNode() {
        map = new HashMap<>();
        endOfWord = false;
    }
}
