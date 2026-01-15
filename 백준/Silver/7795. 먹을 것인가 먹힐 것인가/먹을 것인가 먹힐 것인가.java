import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// A, B 존재, A 는 B 를 먹음 (A > B 일때만 가능)
// A 의 크기가 {8,1,7,3,1} 일 때 B의 크기가 {3,6,1} 일때 A가 B를 먹을 수 있는 쌍의 개수는 8-3, 8-6, 8-1, 7-3, 7-6, 7-1, 3-1
public class Main {
    static int count;
    static int[] A,B;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            init(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            System.out.println(result());
        }
    }

    static void init(int aIdx, int bIdx) throws IOException{
        A = new int[aIdx];
        B = new int[bIdx];
        count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aIdx; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bIdx; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);
    }
    // 1 1 3 7 8
    // 1 3 6
    static int result() {
        for (int i = 0; i < A.length; i++) {
            count += binarySearch(B, A[i]);
        }

        return count;
    }

    // 1 1 3 7 8
    // 1 3 6
    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

