package FordFulkerSon;

public class Edge {
    int start;
    int end;
    long capacity;
    Edge residual;
    long flow;
    public Edge(int start, int end, long capacity) {
        this.start = start;
        this.end = end;
        this.capacity = capacity;
    }

    public long remainingCapacity() {
        return capacity - flow;
    }

    public void augment(long bottleNeck){
        flow += bottleNeck;
        residual.flow -= bottleNeck;
    }
}
