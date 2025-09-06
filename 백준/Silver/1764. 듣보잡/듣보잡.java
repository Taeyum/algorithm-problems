import java.util.*;

// 듣도, 보도 못한 사람의 수와 명단을 출력
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 듣도 못한 사람
        int M = sc.nextInt(); // 보도 못한 사람

        Map<String, Integer> hearPeople = new HashMap<>();
        Map<String, Integer> seePeople = new HashMap<>();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            hearPeople.put(sc.next(), i);
        }

        for (int i = 0; i < M; i++) {
            seePeople.put(sc.next(), i);
        }

        for (String s : hearPeople.keySet()) {
            if(seePeople.containsKey(s)) {
                list.add(s);
            }
        }

        System.out.println(list.size());

        Collections.sort(list);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
