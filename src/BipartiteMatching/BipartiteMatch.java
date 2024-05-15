package BipartiteMatching;

import java.util.ArrayList;
import java.util.List;

public class BipartiteMatch {
    /*Ford Fulkerson algorithm */

    private List<List<Edge>> adj = new ArrayList<>();
    int [] vis;
    int mark;
    int end;

    public BipartiteMatch(int n){
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        vis = new int[n];
    }

    public int dfs(int start, int flow){
        if(start == end) return flow;
        vis[start]=mark;

        for(Edge edge : adj.get(start)){
            if(edge.getCapacity() > 0 && vis[edge.end]!=mark){
                int bottleNeck = dfs(edge.end, Math.min(flow,edge.getCapacity()));

                if(bottleNeck > 0){
                    edge.augment(bottleNeck);
                    return bottleNeck;
                }
            }
        }
        return 0;
    }



    public void addEdge(int start, int end, int capacity){
        Edge e1 = new Edge(start, end, capacity);
        adj.get(start).add(e1);
        Edge e2 = new Edge(end, start, 0);
        adj.get(end).add(e2);
        e1.residual = e2;
        e2.residual = e1;
    }

}
