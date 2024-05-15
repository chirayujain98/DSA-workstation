package Greedy;

public class MaximumScoreStone {

    public static void main(String[] args) {
        int [][] testCase = {{1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
        {2, 4, 6, 8, 10},
                {3, 5, 2, 8, 1},
        {1, 1, 1, 1, 1},
                { 5, 3, 5, 3, 5}};


        for( int [] value : testCase ) {
            int ans = 0;
            int maxValue = Integer.MIN_VALUE;
            for(int i =value.length-1; i>=1; i--) {
                if(maxValue < value[i]) {
                    maxValue = value[i];
                }
                ans += maxValue;
            }
            System.out.println(ans);
        }
    }
}
