package week1;

import java.util.*;
import java.io.*;

public class Kyounglin_10819 {
    static int n;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,new int[n],new boolean[n]);
        System.out.println(max);
    }
    static void dfs(int cnt, int[] perm, boolean[]visited){
        if(cnt==n){
            int sum = 0;
            for(int i = 0; i<n-1; i++){
                sum+= Math.abs(perm[i]-perm[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }
        for(int i = 0; i<n; i++){
            
            if(visited[i]) continue;
            visited[i] = true;
            perm[cnt] = arr[i];
            dfs(cnt+1, perm, visited);
            visited[i] = false;
            
        }

    }
    
}

