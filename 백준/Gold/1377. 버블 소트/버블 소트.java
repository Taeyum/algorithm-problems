import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 버블 정렬의 swap이 한 번도 일어나지 않은 루프가 언제인지 알아내는 것 -> 이미 모든 데이터가 정렬된 것을 의미
// 안쪽 루프에서 swap의 왼쪽으로 이동 가능한 최대 거리 1 -> 데이터의 정렬전 index와 정렬 후 index 를 비교해
// 왼쪽으로 가장 많이 이동한 값을 찾으면 됨 

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        mData[] arr = new mData[N];
        for(int i = 0; i < N; i++) {
            arr[i] = new mData(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr);

        int Max = 0;
        for(int i = 0; i < N; i++) {
            // 정렬 전 index - 정렬 후 index -> 최댓값 구하기
            if(Max < arr[i].index - i) {
                Max = arr[i].index - i;
            }
        }

        System.out.println(Max + 1);
    }

    static class mData implements Comparable<mData> {
        int value;
        int index;

        mData(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(mData o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
