import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 

        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String nickName = st.nextToken();
            Player player = new Player(l, nickName);

            boolean join = false;

            for (Room room : rooms) {
                if (room.checkJoin(l)) {
                    room.players.add(player);
                    join = true;
                    break; 
                }
            }

            if (!join) {
                Room newRoom = new Room(m, l);
                newRoom.players.add(player);
                rooms.add(newRoom);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Room room : rooms) {
            if (room.players.size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            Collections.sort(room.players);
            
            for (Player player : room.players) {
                sb.append(player.l).append(" ").append(player.nickName).append("\n");
            }
        }
        System.out.print(sb);
    }

    static class Player implements Comparable<Player> {
        int l;
        String nickName;

        public Player(int l, String nickName) {
            this.l = l;
            this.nickName = nickName;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickName.compareTo(o.nickName);
        }
    }

    static class Room {
        ArrayList<Player> players = new ArrayList<>();
        int m; 
        int l; 

        public Room(int m, int l) {
            this.m = m;
            this.l = l;
        }

        public boolean checkJoin(int level) {
            if (players.size() >= m) {
                return false;
            } else {
                return level >= l - 10 && level <= l + 10;
            }
        }
    }
}
