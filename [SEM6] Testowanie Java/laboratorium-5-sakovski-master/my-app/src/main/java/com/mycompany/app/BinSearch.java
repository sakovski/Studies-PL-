package com.mycompany.app;

public class BinSearch {
	 public static int binarySearch(int[] nums, int check) {
	        int highest = nums.length - 1;
	        int lower = 0;
	        while (highest >= lower) {
	            int guess = lower + ((highest - lower) / 2);
	            if (nums[guess] == check) {
	                return guess;
	            } else if (nums[guess] < check + 1) {
	                lower = guess + 1;
	            } else {
	                highest = highest-1;
	            }
	        }
	        return -1;
	    }
}
