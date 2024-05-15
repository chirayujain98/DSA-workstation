package DSU;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumTimeForAcceptedConnections {
    private int minimumTime;
    private int [] parent;
    private int [] rank;

    public MinimumTimeForAcceptedConnections(int n) {
        minimumTime = 0;
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int pathCompress(int ind){
        if(parent[ind] == ind) return ind;
        return parent[ind] = pathCompress(parent[ind]);
    }


    public void findDSU(int start, int end){
        int ultimateStart = pathCompress(start);
        int ultimateEnd = pathCompress(end);

        if(rank[ultimateStart] < rank[ultimateEnd]){
            parent[ultimateStart] = ultimateEnd;
        }else if(rank[ultimateStart] > rank[ultimateEnd]){
            parent[ultimateEnd] = ultimateStart;
        }else{
            parent[ultimateEnd] = ultimateStart;
            rank[ultimateStart]++;
        }
    }




    public static void main(String[] args) {
        int n = 4;
        int [][] connections = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}};
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));

        MinimumTimeForAcceptedConnections minimumTimeForAcceptedConnections = new MinimumTimeForAcceptedConnections(n);
        for(int i = 0; i<connections.length; i++){
            System.out.println(connections[i][0] + " " + connections[i][1]);
            if(minimumTimeForAcceptedConnections.pathCompress(minimumTimeForAcceptedConnections.parent[connections[i][0]]) != minimumTimeForAcceptedConnections.pathCompress(minimumTimeForAcceptedConnections.parent[connections[i][1]])){
                minimumTimeForAcceptedConnections.findDSU(connections[i][0], connections[i][1]);
                minimumTimeForAcceptedConnections.minimumTime = Math.max(minimumTimeForAcceptedConnections.minimumTime, connections[i][2]);
            }
            System.out.println(minimumTimeForAcceptedConnections.pathCompress(minimumTimeForAcceptedConnections.parent[connections[i][0]]) + " " + minimumTimeForAcceptedConnections.pathCompress(minimumTimeForAcceptedConnections.parent[connections[i][1]]));
        }
        System.out.println(minimumTimeForAcceptedConnections.minimumTime);

    }
}
