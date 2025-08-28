package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Juhwan_15903 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Queue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}

		while (m-- > 0) {
			long a = pq.poll();
			long b = pq.poll();
			pq.offer(a + b);
			pq.offer(a + b);
		}

		long answer = 0;
		while (!pq.isEmpty()) {
			answer += pq.poll();
		}

		System.out.print(answer);
	}
}