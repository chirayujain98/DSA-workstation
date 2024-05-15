package BipartiteMatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteMatching {

    List<List<Edge>> adj = new ArrayList<>();

    int [] vis;
    int mark;
    int end;

    public void initGraph(int n){
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        vis = new int[n];
        mark = 1;
        end = n-1;
    }
    public void addEdge(int start, int end, int capacity){
        Edge e1 = new Edge(start,end,capacity);
        Edge e2 = new Edge(end,start,0);
        adj.get(start).add(e1);
        adj.get(end).add(e2);
        e1.residual = e2;
        e2.residual = e1;
    }
    public void createAdjGraph(Question[] questions, Volunteer[] volunteers, int n, int s, int t) {
        for(int i = 0; i<volunteers.length; i++){
            for(int j =0; j<volunteers[i].tags.length; j++){
                String tag = volunteers[i].tags[j];
                for(int k = 0; k<questions.length;k++){
                    for(int l = 0; l<questions[k].tags.length; l++){
                        if(tag.equals(questions[k].tags[l])){
                            addEdge(volunteers[i].id-1, questions[k].id-1,1);
                            addEdge(questions[k].id-1, volunteers[i].id-1,1);
                        }
                    }
                }
            }
        }

        for(int i = 0;i<4; i++){
            addEdge(s,volunteers[i].id-1,1);
        }
        for(int i = 0;i<4; i++){
            addEdge(questions[i].id-1, t,1);
        }
    }

    public int dfs(int start, int flow){
        //System.out.println(start+"s");
        if(start == end) {
            //System.out.println(flow + "f");
            return flow;
        }
        vis[start] = mark;

        for(Edge e: adj.get(start)){

            if(e.getCapacity() > 0 && vis[e.end] != mark){
                //System.out.println(Math.min(e.getCapacity(), flow));
                int bottleneck = dfs(e.end, Math.min(e.getCapacity(), flow));
                //System.out.println(bottleneck + "b");
                if(bottleneck > 0){
                    e.augment(bottleneck);
                    return bottleneck;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Question[] questions = new Question[4];
        questions[0] = new Question(1,new String[]{"MAC", "VSCODE"});
        questions[1] = new Question(2,new String[]{"PY", "AI"});
        questions[2] = new Question(3,new String[]{"JAVA", "OS"});
        questions[3] = new Question(4,new String[]{"PY", "NW"});

        Volunteer[] volunteers = new Volunteer[4];
        volunteers[0] = new Volunteer(5, new String[]{"PY","NW"});
        volunteers[1] = new Volunteer(6, new String[]{"AI"});
        volunteers[2] = new Volunteer(7, new String[]{"JAVA", "NW"});
        volunteers[3] = new Volunteer(8, new String[]{"JAVA", "NW"});
        BipartiteMatching bipartiteMatching = new BipartiteMatching();
        int n = 10;
        bipartiteMatching.initGraph(n);
        bipartiteMatching.createAdjGraph(questions, volunteers, n, n-2, n-1);


        int max = Integer.MAX_VALUE;
        int ans = 0;
        for(int f = bipartiteMatching.dfs(n-2, max/2); f!=0; f = bipartiteMatching.dfs(n-2, max/2)){
            bipartiteMatching.mark++;
            ans += f;
        }

        // Maximum flow
        System.out.println(ans);


    }

}
