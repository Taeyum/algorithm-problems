import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


// 기타줄은 6개씩 들어있음
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 끊어진 기타줄 갯수
		int M = Integer.parseInt(st.nextToken()); // 기타줄 브랜드 갯수
		int money = 0;
		
		int[] packs = new int[M];
		int[] each = new int[M];
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			packs[i] = Integer.parseInt(st.nextToken());
			each[i] = Integer.parseInt(st.nextToken());
		}
			
		Arrays.sort(packs);
		Arrays.sort(each);
		
		if(packs[0] < each[0] * 6) {
			while(N > 6) {
				money += packs[0];
				N -= 6;
			}
		} else {
			while(N > 6) {
				money += each[0] * 6;
				N -= 6;
			}
		}
		
		if(packs[0] < each[0] * N) {
			money += packs[0];
		} else {
			money += each[0] * N;
		}
		
		System.out.println(money);
	}
	
	
}
