import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1부터 연속적인 스위치 , 1 ON, 0 OFF
// 남학생 : 해당 수의 배수 -> 스위치 상태 바꿈
// 여학생 : 해당 수의 좌우 판별 -> 스위치 상태가 좌우가 같으면 좌 + 1 , 우 + 1 으로 늘려가며 비교하고 끝에 도달하면 상태를 모두 바꾸고
// 만약 양 옆의 상태가 다르면 그 전꺼만 바
public class Main {
    static int switchNum;
    static int studentNum;
    static int[] switchArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switchNum = Integer.parseInt(br.readLine());
        switchArr = new int[switchNum];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < switchNum; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        studentNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int studentSwitch = Integer.parseInt(st.nextToken());
            int max = studentSwitch;
            int min = studentSwitch - 2;
            // 남학생
            if(student == 1) {
                for (int j = studentSwitch - 1; j < switchNum; j += studentSwitch) {
                    switchArr[j] = switchArr[j] == 0 ? 1 : 0;
                }
            }
            // 여학생
            else {
                while (true) {
                    // 입력값으로 2가 들어옴 하지만 배열은 1을 기준으로 비교해야함
                    if(min < 0 || max >= switchNum) {
                        switchArr[studentSwitch - 1] = switchArr[studentSwitch - 1] == 0 ? 1 : 0;
                        break;
                    }
                    if(switchArr[min] == switchArr[max]) {
                        switchArr[min] = switchArr[min] == 0 ? 1 : 0;
                        switchArr[max] = switchArr[max] == 0 ? 1 : 0;
                        max++;
                        min--;
                    } else {
                        switchArr[studentSwitch - 1] = switchArr[studentSwitch - 1] == 0 ? 1 : 0;
                        break;
                    }
                }
            }
        }
        int count = 0;
        for (int N : switchArr) {
            System.out.print(N + " ");
            count++;
            if(count % 20 == 0) {
                System.out.println();
            }
        }
    }
}
