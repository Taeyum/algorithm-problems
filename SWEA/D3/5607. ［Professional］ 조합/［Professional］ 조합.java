import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,R;
	static long[] factorial;
	static int fermat = 1234567891;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			factorial = new long[N+1];
			factorial[0] = 1;
			for(int i = 1 ; i <= N ; i++) {
				factorial[i] = (factorial[i - 1] * i) % fermat;
			}
			
			long Nfact = factorial[N];
			
			long RNRfact = (factorial[R] * factorial[N - R]) % fermat;
			
			long inverse = power(RNRfact, fermat - 2);
			
			long result = (Nfact * inverse) % fermat;
			
			System.out.println("#" + test_case + " " + result);			
		}
	}
	
	static long power(long base, long exp) {
		if(exp == 0) {
			return 1;
		}
		long half = power(base, exp/2);
		long res = (half * half) % fermat;
		
		if(exp % 2 == 1) {
			res = (res * base) % fermat;
		}
		return res;
	}

}
