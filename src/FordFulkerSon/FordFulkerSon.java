package FordFulkerSon;

import java.util.ArrayList;
import java.util.List;

public class FordFulkerSon {

    List<List<Edge>> adj = new ArrayList<>();
    int e;
    int [] vis;
    int visItr = 1;

    public FordFulkerSon(int n){
        vis = new int[n];
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
    }

    public long performDfs(int start, long flow){
        if(start == e) return flow;
        vis[start] = visItr;
        for(Edge edge : adj.get(start)){
            if(edge.remainingCapacity() > 0 && vis[edge.end] != visItr){

                long bottleNeck = performDfs(edge.end, Math.min(flow, edge.remainingCapacity()));
                if(bottleNeck > 0){
                    edge.augment(bottleNeck);
                    return bottleNeck;
                }
            }
        }
        return 0;
    }

    public void addEdge(int start, int end, long capacity){
        Edge e1 = new Edge(start, end, capacity);
        Edge e2 = new Edge(end, start, 0);
        adj.get(start).add(e1);
        adj.get(end).add(e2);
        e1.residual = e2;
        e2.residual = e1;
    }

    public static void main(String [] args){
        int n = 6;
        int s = n-2;
        int t = n-1;
        FordFulkerSon fordFulkerSon = new FordFulkerSon(n);
        fordFulkerSon.e = t;
        fordFulkerSon.addEdge(s, 0, 10);
        fordFulkerSon.addEdge(s, 1, 10);

        // Sink edges
        fordFulkerSon.addEdge(2, t, 10);
        fordFulkerSon.addEdge(3, t, 10);

        // Middle edges
        //fordFulkerSon.addEdge(0, 1, 2);
        fordFulkerSon.addEdge(0, 2, 25);
        fordFulkerSon.addEdge(3, 0, 6);
        fordFulkerSon.addEdge(1, 3, 15);
        //fordFulkerSon.addEdge(3, 2, 6);
        long f = fordFulkerSon.performDfs(s,Long.MAX_VALUE/2L);
        long ans = 0;
        while(f!=0){
            ans += f;
            fordFulkerSon.visItr++;
            f = fordFulkerSon.performDfs(s,Long.MAX_VALUE/2L);
        }
        System.out.println(ans);


    }
}
