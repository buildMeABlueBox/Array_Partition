package com.company;

import java.util.Arrays;
/*
Given an array of 2n integers, your task is to group these
 integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn)
  which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 */

public class Main {
    public static void main(String[] args){
        int[] maxMinSum = new int[]{4,1,2,3};
        System.out.println(arrayPairSum(maxMinSum));
    }


    //This solution uses quicksort which would make the algorithm O(n^2) worst case but I'm pretty sure in practice this behavior is rare..
    //quicksort is known to average around O(n log n) but still, worst case is O(n^2).
    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        //sort array because the goal is to get the largest sum from the minimum of the pair of integers.
        //If the array is sorted then you will have the largest near the largest and smallest near smallest.
        //This allows a larger number not to be disregarded in case it is grouped with a smaller number.
        //take for example the array [1,4,3,2] : A possible pairing is (1,4) (3,2). However since the 4 is
        //paired with the 1, it will be disregarded because 1 is the minimum. Sorting takes that away and
        //guarantees a larger number will always be used.
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            sum = i%2 == 0? sum + nums[i] : sum;
        }
        return sum;
    }
}

