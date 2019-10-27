package com.test.au;

import java.util.HashMap;
import java.util.Map;

public class ArraytwosumIndex {


public static void main(String[] args) 
{ 
	int[] numArray = {1,8,7,2,3};
	int target = 5;
	System.out.println(twoSum(numArray,target));
}

	
	public static int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<Integer,Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

}
