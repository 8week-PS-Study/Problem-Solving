package week2;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1182
public class Yujin_1182 {
    static int n, s; //수열 갯수, 부분수열의 합으로 만들어지는 수
    static int[] a; //수열


    static int go(int i, int sum) {
        return i == n ? (sum == s ? 1 : 0)
                : go(i + 1, sum + a[i]) + go(i + 1, sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        int total = go(0, 0) - (s == 0 ? 1 : 0);
        System.out.print(total);
    }
}
