package Trie;

import java.util.HashMap;
import java.util.Map;

public class Node {
    Map<String,Node> map;
    boolean isEnd;
    int count;
    Node(){
        map = new HashMap<>();
        isEnd = false;
        count = 0;
    }

    public boolean containsString(String s){
        return map.containsKey(s);
    }

    public void put(String s, Node node){
        map.put(s,node);
    }

    public Node get(String s){
        return map.get(s);
    }
    public boolean isEnd() {
        return isEnd;
    }
    public void setEnd(){
        isEnd = true;
    }

}
