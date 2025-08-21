package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Juhwan_1138 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] tallerCounts = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tallerCounts[i] = Integer.parseInt(st.nextToken());
		}

		int[] line = new int[N];
		for (int height = 0; height < N; height++) {
			int tallerCount = tallerCounts[height];
			for (int j = 0; j < N; j++) {
				if (line[j] == 0) {
					if (tallerCount == 0) {
						line[j] = height + 1;
						break;
					}
					tallerCount--;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(line[i] + " ");
		}
		System.out.print(sb);
	}
}