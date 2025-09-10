import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] numbers;
	static boolean[] visited;
	static int N;
	static int count;
	static int[] input;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		count = sc.nextInt();
		
		numbers = new int[count];
		visited = new boolean[N + 1];
		input = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input);
		
		Combination(0, 0);
	}
	
	static void Combination(int cnt, int start) {
		if(cnt == count) {
			for(int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start ; i < N ; i++) {
			
			numbers[cnt] = input[i];
			Combination(cnt + 1, i + 1);
		}
		
	}
}
