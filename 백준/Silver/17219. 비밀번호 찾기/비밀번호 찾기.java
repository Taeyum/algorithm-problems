import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 저장된 사이트 수
        int M = sc.nextInt(); // 사이트 주소 수

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.putIfAbsent(sc.next(), sc.next());
        }

        String[] str = new String[M];

        for (int i = 0; i < M; i++) {
            str[i] = sc.next();
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            if(map.containsKey(str[i])) {
                list.add(map.get(str[i]));
            }
        }

        for (String s : list) {
            System.out.println(s);
        }

    }
}
