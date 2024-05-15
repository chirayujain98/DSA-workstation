package Trie;

import java.util.*;

public class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }
    public void put(List<String> directory){
        Node node = root;
        for(String s : directory){
            if(!node.containsString(s)){
                node.put(s, new Node());
            }


            node = node.get(s);
            node.count = node.count + 1;
            //System.out.println("H " + s + " " + node.count);
        }
        node.setEnd();
    }
    public void remove(List<String> directory){
        Node node = root;
        for(String s : directory){
            if(node.containsString(s)){


                node = node.get(s);
                node.count--;
                //System.out.println("R " + s + " " + node.count);
            }
        }
    }

    public Set<String> checkAndReturnDirectory(List<String> directory){
        Node node = root;
        Set<String> result = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        for(String s : directory){
            if(s.isEmpty()) {
                node = node.get(s);
                continue;
            }
            if(node.containsString(s)){
                //System.out.println("L " + s);
                String newPath = "/"+s;
                ans.append(newPath);
                node = node.get(s);

                if(node.count == 0){
                    result.add(ans.toString());
                    break;
                }
            }
        }
        return result;
    }
}
