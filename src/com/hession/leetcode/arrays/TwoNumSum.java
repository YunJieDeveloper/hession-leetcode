package com.hession.leetcode.arrays;

/**
 * @program: hession-leetcode
 * @description: 第1题 两数加和（Two Sum）
 * @author: Hession
 * @create: 2019-05-05 22:42
 **/

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 第1题 两数加和（Two Num Sum）
 * <p>
 * 问题描述：
 * 　　给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * */
public class TwoNumSum {


    /**
     * 方式一
     * @param arr    整数数组
     * @param target 目标值
     * @return 满足条件的数组下标组合
     * @author hession
     * @description 最大复杂度O(n):n*(n-1)/2
     */
    public static Pair<Integer, Integer> twoNumSum(int[] arr, int target) {
        int n = 0;
        Pair<Integer, Integer> pair =null;
        tag:
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                n++;
                if (arr[i] + arr[j] == target) {
                     pair = new Pair<>(i, j);
                    break tag;
                }
            }
        }
        System.out.println("复杂度O(n):" + n);
        return pair;
    }


    /**
     * 方式二
     * @param arr    整数数组
     * @param target 目标值
     * @return 满足条件的数组下标组合
     * @author hession
     * @description 最大复杂度O(n):n
     */
    public static Pair<Integer, Integer> twoBetterNumSum(int[] arr, int target) {
        int n = 0;
        Pair<Integer, Integer> pair =null;
        HashMap<Integer,Integer> map =new HashMap();
        for (int i = 0; i < arr.length; i++) {
           map.put(arr[i],i);
           if (map.containsKey(target-arr[i])){
               pair=new Pair<>(map.get(target-arr[i]),i);
               break;
           }
           n++;
        }
        System.out.println("复杂度O(n):" + n);
        return pair;
    }

    /**
     *
     * 延伸需求,方式一
     * @param arr    整数数组
     * @param target 目标值
     * @return  所有满足条件的数组下标组合的集合
     * @author hession
     * @description   复杂度O(n):n*(n-1)/2
     */
    public static List<Pair<Integer, Integer>> twoNumSums(int[] arr, int target) {
        List list = new ArrayList(arr.length);
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    list.add(pair);
                }
                n++;
            }
        }
        System.out.println("复杂度O(n):" + n);
        return list;
    }


    /**
     * 延伸需求, 方式二
     * @param arr    整数数组
     * @param target 目标值
     * @return 所有满足条件的数组下标组合的集合
     * @author hession
     * @description 最大复杂度O(n):n
     */
    public static List<Pair<Integer, Integer>> twoBetterNumSums(int[] arr, int target) {
        int n = 0;
        List list = new ArrayList(arr.length);
        HashMap<Integer,Integer> map =new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
            if (map.containsKey(target-arr[i])){
               Pair<Integer,Integer> pair=new Pair<>(map.get(target-arr[i]),i);
               list.add(pair);
            }
            n++;
        }
        System.out.println("复杂度O(n):" + n);
        return list;
    }




    public static void main(String[] args) {
        int[] nums = {2, 7, 11,7,5,4};
        int target = 9;
        List<Pair<Integer, Integer>> pairs = twoNumSums(nums, target);
        pairs.forEach(System.out::println);
        System.out.println("=================================");
        Pair<Integer, Integer> pair = twoNumSum(nums, target);
        System.out.println(pair);
        System.out.println("=================================");
        Pair<Integer, Integer> pair1 = twoBetterNumSum(nums, target);
        System.out.println(pair1);
        System.out.println("=================================");
        List<Pair<Integer, Integer>> pairs1 = twoBetterNumSums(nums, target);
        pairs1.forEach(System.out::println);

    }
}
