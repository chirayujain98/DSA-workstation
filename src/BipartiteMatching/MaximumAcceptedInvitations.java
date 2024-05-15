package BipartiteMatching;

import java.util.ArrayList;
import java.util.List;

public class MaximumAcceptedInvitations {

    public static void main(String[] args) {
        int [][] grid = {{1,1,1},{1,0,1},{0,0,1}};
        int i = 0;
        List<Integer> boys = new ArrayList<>();
        List<Integer> girls = new ArrayList<>();

        for(; i<grid.length; i++){
            boys.add(i);
        }

        for(; i<grid.length+grid[0].length; i++){
            girls.add(i);
        }

        int total= boys.size() + girls.size() + 2;
        int s = total-2;
        int e = total-1;
        BipartiteMatch bipartite = new BipartiteMatch(total);

        for(int j = 0; j<boys.size(); j++){
            bipartite.addEdge(s,j,1);
        }

        for(int j = 0; j<girls.size(); j++){
            bipartite.addEdge(boys.size() + j,e,1);
        }
        for(int j = 0; j<grid.length; j++){
            for(int k = 0; k<grid[0].length; k++){
                if(grid[j][k] == 1){
                    bipartite.addEdge(j,boys.size() + k,1);
                }
            }
        }
        int ans = 0;
        bipartite.mark = 1;
        bipartite.end = e;
        int f = bipartite.dfs(s, Integer.MAX_VALUE/2);
        while(f!=0){
            ans += f;
            bipartite.mark++;
            f = bipartite.dfs(s, Integer.MAX_VALUE/2);
        }

        System.out.println(ans);

    }

}
