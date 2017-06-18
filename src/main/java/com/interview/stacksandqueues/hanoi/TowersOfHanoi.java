package com.interview.stacksandqueues.hanoi;

public class TowersOfHanoi {

	   public void solve(int n, String start, String middle, String end) {
	       if (n == 1) {
	           System.out.println(start + " -> " + end);
	       } else {
	           solve(n - 1, start, end, middle);
	           System.out.println(start + " -> " + end);
	           solve(n - 1, middle, start, end);
	       }
	   }

	   public static void main(String[] args) {
	       TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
	       int discs = 2;
	       towersOfHanoi.solve(discs, "A", "B", "C");
	   }
	}

