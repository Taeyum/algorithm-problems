import java.util.Scanner;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] trees = new int[N];
			int max = 0;

			for (int i = 0; i < N; i++) {
				trees[i] = sc.nextInt();
				if (trees[i] > max) {
					max = trees[i];
				}
			}

			int one_day_count = 0; // 1씩 성장해야 하는 나무들의 수
			int two_day_count = 0; // 2씩 성장해야 하는 나무들의 수

			for (int treeHeight : trees) {
				int diff = max - treeHeight;
				one_day_count += diff % 2;
				two_day_count += diff / 2;
			}
			
			if(two_day_count > one_day_count) {
				while(Math.abs(two_day_count - one_day_count) > 1) {
					two_day_count--;
					one_day_count += 2;
				}
			}

			int answer = 0;
			if(one_day_count > two_day_count) {
				answer = one_day_count * 2 - 1;
			} else if(two_day_count > one_day_count) {
				answer = two_day_count * 2;
			} else {
				answer = one_day_count + two_day_count;
			}

			System.out.println("#" + test_case + " " + answer);
		}
	}
}