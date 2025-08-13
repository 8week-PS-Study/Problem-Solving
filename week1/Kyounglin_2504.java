package week1;

import java.util.*;
import java.io.*;

public class Kyounglin_2504 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int num = 1;
        int newNum = 0;
        int answer = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(c);
                num*=2;
            }else if(c=='['){
                stack.push(c);
                num*=3;
            }else if(c==')'){
                if(stack.isEmpty()|| stack.peek()!='('){
                    System.out.println(0);
                    return;
                }
                if(i>0 && s.charAt(i-1)=='(') answer+=num;
                stack.pop();
                num/=2;
                
            }else if(c==']'){
                if(stack.isEmpty()|| stack.peek()!='['){
                    System.out.println(0);
                    return;
                }
                if(i>0 && s.charAt(i-1)=='[') answer+=num;
                stack.pop();
                num/=3;
            }
        }
        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(answer);
        
    }
}
