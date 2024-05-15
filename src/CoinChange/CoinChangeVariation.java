package CoinChange;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeVariation {

    public List<Integer> findCoins(int [] dp, int n){
        List<Integer> coins = new ArrayList<>();
        for(int i = 1; i < dp.length; i++){
            if(dp[i] == 1){
                coins.add(i);
                for(int j= n; j>= i; j--){
                    dp[j] = dp[j]-  dp[j-i];
                }
            }
        }
        return coins;
    }
    public static void main(String[] args) {
        int [] dp = {1, 0, 1, 0, 1, 1, 2, 1, 2, 1, 3};
        CoinChangeVariation coinChangeVariation = new CoinChangeVariation();
        List<Integer> coins = coinChangeVariation.findCoins(dp, 10);
        for(Integer coin : coins){
            System.out.println(coin);
        }
    }
}
