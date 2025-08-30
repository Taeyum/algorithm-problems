import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;


// N극 0
// S극 1
// 시계 방향 1
// 반시계 방향 -1

// 입력 값으로는 톱니바퀴 1, 2, 3, 4 지만 내부에서는 0, 1, 2, 3 으로 관리할것임

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = 0;
        Cogwheel[] cogwheels = new Cogwheel[4];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            char[] array = st.nextToken().toCharArray();
            Deque<Integer> deque = new ArrayDeque<>();
            for (char c : array) {
                deque.offer(c - '0');
            }
            cogwheels[i] = new Cogwheel(deque);
        }

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int spinCogNum = Integer.parseInt(st.nextToken());
            int spinDir = Integer.parseInt(st.nextToken());

            int[] checkSpinDir = new int[4];
            checkSpinDir[spinCogNum - 1] = spinDir;

            // 오른쪽 톱니바퀴 확인
            for (int j = spinCogNum - 1; j < 3; j++) {
                // 해당 톱니와 오른쪽 톱니의 극이 다르면 반대로 회전
                if (cogwheels[j].getCog3() != cogwheels[j+1].getCog7()) {
                    checkSpinDir[j+1] = checkSpinDir[j] * -1;
                } else {
                    break;
                }
            }

            // 왼쪽 톱니바퀴 확인
            for (int j = spinCogNum - 1 ; j > 0 ; j--) {
                // 해당 톱니와 왼쪽 톱니의 극이 다르면 반대로 회전
                if (cogwheels[j].getCog7() != cogwheels[j - 1].getCog3()) {
                    checkSpinDir[j-1] = checkSpinDir[j] * -1;
                } else {
                    break;
                }
            }

            // 모두 회전
            for (int j = 0; j < 4; j++) {
                // 시계 방향 1 , 반시계 방향 -1
                if (checkSpinDir[j] == 1) {
                    cogwheels[j].spin();
                } else if (checkSpinDir[j] == -1) {
                    cogwheels[j].reverseSpin();
                }
            }
        }

        // 최종 점수
        int result = 0;
        if(cogwheels[0].getPoint() == 1) result += 1;
        if(cogwheels[1].getPoint() == 1) result += 2;
        if(cogwheels[2].getPoint() == 1) result += 4;
        if(cogwheels[3].getPoint() == 1) result += 8;

        System.out.println(result);
    }


    static class Cogwheel {
        Deque<Integer> wheel;

        public Cogwheel(Deque<Integer> wheel) {
            this.wheel = wheel;
        }

        public int getCog3() {
            Iterator<Integer> iterator = this.wheel.iterator();
            int count = 0;
            while(iterator.hasNext()) {
                int cogValue = iterator.next();
                if(count == 2) {
                    return cogValue;
                }
                count++;
            }
            return -1;
        }
        public int getCog7() {
            Iterator<Integer> iterator = this.wheel.iterator();
            int count = 0;
            while(iterator.hasNext()) {
                int cogValue = iterator.next();
                if(count == 6) {
                    return cogValue;
                }
                count++;
            }
            return -1;
        }

        // 반시계 방향 -1
        // 앞에 있는 값 빼서 맨 뒤로 보내면 반시계 방향 회전임
        public void reverseSpin() {
            if(!wheel.isEmpty()) {
                int first = wheel.pollFirst();
                wheel.offerLast(first);
            } else {
                System.out.println("wheel 초기화 안되어있어!!!");
            }
        }

        // 시계 방향 1
        // 뒤에 있는 값 빼서 앞에 넣으면 시계 방향 회전
        public void spin() {
            if(!wheel.isEmpty()) {
                int last = wheel.pollLast();
                wheel.offerFirst(last);
            }
        }

        public int getPoint() {
            return wheel.pollFirst();
        }
    }
}
