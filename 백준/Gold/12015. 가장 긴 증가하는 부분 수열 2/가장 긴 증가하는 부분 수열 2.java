import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] LIS;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N];
		LIS = new int[N];
		int len = 0;
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int num : arr) {
			if(len == 0 || num > LIS[len - 1]) {
				LIS[len++] = num;
			} else {
				// LIS 탐색할 배열 , 0 탐색을 시작할 인덱스 , len 끝낼 인덱스 , 찾고자하는 값
				int idx = Arrays.binarySearch(LIS, 0, len, num);
				if(idx < 0) {
					idx = -idx -1;
				}
				LIS[idx] = num;
			}
		}
		
		System.out.println(len);
	} 
}
