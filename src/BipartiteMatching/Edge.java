package BipartiteMatching;

public class Edge {
    int start;
    int end;
    Edge residual;
    int flow;
    int capacity;

    public Edge(int start, int end, int capacity){
        this.start = start;
        this.end = end;
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity - flow;
    }

    public void augment(int bottleneck){
        flow += bottleneck;
        residual.flow -= bottleneck;
    }




}
