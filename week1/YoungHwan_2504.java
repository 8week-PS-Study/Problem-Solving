package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class YoungHwan_2504 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = calculateResult(s, stack);

        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(result);
    }

    private static int calculateResult(String s, Stack<Character> stack) {
        int result = 0;
        int value = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                value *= 2;
            } else if (c == '[') {
                stack.push(c);
                value *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return 0;
                }

                if (s.charAt(i - 1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return 0;
                }

                if (s.charAt(i - 1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }

        }
        return result;
    }
}
