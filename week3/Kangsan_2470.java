package week3;

import java.io.*;
import java.util.*;

//  두 용액 (https://www.acmicpc.net/problem/2470)
public class Kangsan_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(line[i]));
        }

        // solve
        Collections.sort(list);

        int left = 0;
        int right = N-1;
        int ans1 = 0;
        int ans2 = 0;
        int result = Integer.MAX_VALUE;
        while(left < right){
            int sum = list.get(left) + list.get(right);

            if(Math.abs(sum) < result){
                result = Math.abs(sum);
                ans1 = list.get(left);
                ans2 = list.get(right);
            }

            if(sum < 0){
                left++;
            } else{
                right--;
            }
        }

        // output
        bw.write(ans1+" "+ans2);
        bw.flush();
    }
}

