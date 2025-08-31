import java.util.Scanner;

public class Main {

    static int[][] spaces;
    static int green, white;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        spaces = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                spaces[i][j] = sc.nextInt();
            }
        }
        green = white = 0;
        makeSpace(0, 0, N);
        System.out.println(white);
        System.out.println(green);
    }


    static void makeSpace(int r, int c, int size) {
        //step1. 주어진 영역이 모두 같은 색상으로 이루어졌는지 체크
        int sum = 0;
        for (int i = r, rEnd = r + size; i < rEnd; i++) {
            for (int j = c, cEnd = c + size; j < cEnd ; j++) {
                sum += spaces[i][j];
            }
        }

        //step2. 같은 색으로 이루어져 있다면 해당색의 카운트 증가후 리턴
        if (sum == size * size) { // 모두 초록색
            green++;
        } else if (sum == 0) { // 모두 하얀색
            white++;
        } else { // 섞여 있음
            //step3. 같은 색으로 이루어져 있지 않다면 4분할 후 각 공간에 대해 동일한 처리
            int newSize = size / 2;
            makeSpace(r, c, newSize); // 영역 1
            makeSpace(r, c + newSize, newSize); // 영역 2
            makeSpace(r + newSize, c, newSize); // 영역 3
            makeSpace(r + newSize, c + newSize, newSize); // 영역 4
        }
    }
}
