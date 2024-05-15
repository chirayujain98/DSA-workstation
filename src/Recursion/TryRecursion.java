package Recursion;

import java.util.ArrayList;
import java.util.List;

public class TryRecursion {

    public void recur(List<Integer> nums, int i) {
        if(i == nums.size()) return;
        nums.set(i, nums.get(i)+1);
        recur(nums, i+1);
        nums.set(i, nums.get(i)-1);
        System.out.println(nums.get(i) + " " + i);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        TryRecursion tryRecursion = new TryRecursion();
        tryRecursion.recur(list, 0);
    }
}
