package Trie;

import java.util.*;

public class ProblemDriver {

    public static void main(String[] args) {

        List<String> paths = new ArrayList<>();
        /*
         * "a/b/c/d.txt",
         * "a/b/c/e.txt",
         * "a/b/b.txt",
         * "a/b/e.txt",
         * "b/c/d.txt"
         */
        paths.add("a/b/c/d.txt");
        paths.add("a/b/c/e.txt");
        paths.add("a/b/b.txt");
        paths.add("a/b/e.txt");
        paths.add("b/c/d.txt");

        /*
         * "a/b/c/d.txt",
         * "a/b/c/e.txt",
         * "a/b/b.txt",
         * "b/c/d.txt"
         */

        List<String> selected = new ArrayList<>();
        selected.add("a/b/c/d.txt");
        selected.add("a/b/c/e.txt");
        selected.add("a/b/b.txt");
        selected.add("b/c/d.txt");
        Trie trie = new Trie();

        for(int i = 0; i<paths.size(); i++){
            String [] dir = paths.get(i).split("/");
            trie.put(Arrays.asList(dir));
        }

        for(int i = 0; i<selected.size(); i++){
            String [] dir = selected.get(i).split("/");
            trie.remove(Arrays.asList(dir));
        }
        Set<String> ans = new HashSet<>();
        for(int i = 0; i<paths.size(); i++){
            String [] dir = paths.get(i).split("/");
            ans.addAll(trie.checkAndReturnDirectory(Arrays.asList(dir)));
        }

        for(String s : ans){
            System.out.println(s);
        }



    }
}
