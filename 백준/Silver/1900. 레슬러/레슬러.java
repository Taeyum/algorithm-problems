import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
레슬링 선수 -> 자신의 힘 + 마술 링(상대 선수의 힘에 비례하는 힘을 추가로 얻음, 상대가 강하면 많이 얻나?)
             힘, 마술 링의 힘은 모두 양의 정수
             선수 A가 선수 B와 경기할 때 A의 경기력은 'A의 힘' + 'B의 힘' * 'A가 착용하고 있는 마술링의 힘'
ex) A의 힘 10 마술링 3 , B의 힘 18 마술링 4 이 경기를 가지면 A가 이긴다
    A는 10 + 3 * 18 = 64, B는 18 + 4 * 10 = 58 (A승 B패배)
    C는 힘 15 마술링 5
    A는 10 + 3 * 15 = 55, C는 15 + 5 * 10 = 65 (C승 A패배)

매년 레슬링 축제 개최 / 각 레슬링 선수는 다른 선수들과 모두 한 번씩 경기를 가짐
마지막에 모두 초대하여 축하하고 [금화 수여]
왕을 만나는 줄(순서)는 희현이 정함
동호가 수여하는 금화의 수는 그가 이긴 경기수와 그가 선수들의 줄 어느 위치에 서 있느냐고 결정한다고 선언함
한 선수가 받는 금화의 수는 [그가 이긴 경기의 수 + 자기보다 앞에 있는데 자기가 이긴 선수의 수]

예를 들어 세 선수 A, B, C 에게 A, B, C 순서로 동호를 만나면 A는 금화 1개 , B는 0개 , C는 4개를 받게됨
C, A, B 순서라면 C는 2개 A는 1개 B는 0개를 받게 됨
금화를 가장 적게 받게 순서를 정하자.
**/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Player[] players = new Player[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            players[i] = new Player(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(players);

        for (Player player : players) {
            System.out.println(player.id);
        }

    }

    static class Player implements Comparable<Player>{
        int id, power, ring;

        public Player(int id, int power, int ring) {
            this.id = id;
            this.power = power;
            this.ring = ring;
        }

        @Override
        public int compareTo(Player o) {
            int A = this.power + this.ring * o.power;
            int B = o.power + o.ring * this.power;

            return Integer.compare(A,B) * -1;
        }
    }
}

