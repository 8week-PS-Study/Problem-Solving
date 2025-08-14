package week1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2054
class Juhwan_2504 {

	public static void main(String[] args) {
		String[] arr = new Scanner(System.in).next().split("");
		System.out.print(solve(arr));

	}

	static int solve(String[] arr) {
		int len = arr.length;
		int result = 0;
		int prev = 1;
		Deque<String> stack = new ArrayDeque<>();
		for (int i = 0; i < len; i++) {
			String value =  arr[i];

			if ("(".equals(value)) {
				prev *= 2;
				stack.push(value);
			} else if ("[".equals(value)) {
				prev *= 3;
				stack.push(value);
			} else {
				if (stack.isEmpty()) return 0;

				String open = stack.pop();
				int pairValue = getPairValue(open, value);
				if (pairValue == -1) return 0;

				if (open.equals(arr[i-1])) {
					result += prev;
				}
				prev /= pairValue;
			}
		}

		if (!stack.isEmpty()) return 0;

		return result;
	}

	static int  getPairValue(String open, String close) {
		if ("(".equals(open) && ")".equals(close)) return 2;
		else if ("[".equals(open) && "]".equals(close)) return 3;
		else return -1;
	}
}
