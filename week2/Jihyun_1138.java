import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
 
public class Main {
	static int[] arr;
  static int count, a, b;
    
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());        
        arr = new int[a];
        st = new StringTokenizer(br.readLine()," ");
        for(int i =0;i<a;i++){            
            
            arr[i]=Integer.parseInt(st.nextToken());           
        }
        dfs(0,0);//0,0에서부터 더해나가기
        if(b==0){
            count-=1; //합이 0이면 시작부터 +1이므로 -1해주기
        }
        System.out.print(count);
        
    }
    public static void dfs(int depth, int sum){
        if(depth==a){
            if(sum==b){
                count++;
            }
            return;
        }
        dfs(depth+1, sum+arr[depth]); //선택 O 
        dfs(depth+1, sum);//선택 X
        
    }
}

