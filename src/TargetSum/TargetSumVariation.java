package TargetSum;

public class TargetSumVariation {

    public boolean checkSum(int [] values, int maxValue, int i){
        if(maxValue == 0) return true;
        if(i == values.length-1) return false;
        if(maxValue < 0) return false;
        boolean include = checkSum(values, maxValue, i+1);
        boolean notInclude = checkSum(values, maxValue - values[i], i+1);
        return include || notInclude;
    }

    public static void main(String[] args) {
        int [] values = {1,4,4,5,12};
        int maxValue = 0;
        for(int v : values){
            if(v > maxValue){
                maxValue = v;
            }
        }
        for(int i  = 0; i<values.length; i++){
            if(values[i] == maxValue){
                values[i] = -1;
            }
        }

        TargetSumVariation targetSumVariation =  new TargetSumVariation();
        System.out.println(targetSumVariation.checkSum(values, maxValue, 0));

        // Iterative version

        int [][] dp = new int[values.length+1][maxValue+1];

        for(int i = 0; i<values.length; i++){
            for(int j = 0; j<=maxValue; j++){

            }
        }

    }
}
