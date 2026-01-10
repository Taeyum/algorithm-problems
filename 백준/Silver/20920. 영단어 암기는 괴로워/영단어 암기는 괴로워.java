import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/*
1.자주 나오는 단어 앞 배치
2.단어 길이가 길 수록 앞 배치
3.알파벳 사전 순 배치
길이 M 제한

입력
- 단어의 갯수 N, 외울 단어 길이의 기준 M
-
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        List<wordList> list = new ArrayList<>();
        // 일단 다 집어넣고 출력할 때만 길이 체크해서 출력하면 될... 아니네 정렬해야하니까 넣을때 넣지말자.
        for (int i = 0; i < N ; i++) {
            String word = br.readLine();
            if(word.length() >= M) {
                map.put(word, (map.getOrDefault(word,0) + 1));
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            wordList wl = new wordList(entry.getKey(), entry.getValue());
            list.add(wl);
        }

        // count 별로 정렬 한 상태에서 -> count 가 같은 얘들 끼리 글자 길이 수로 정렬하고 -> 같은 길이 인 얘들 끼리 사전 순으로 비교
        // 카운터 별로 정렬한 번 하면 구간 나눠질거잖아
        // 그 구간 별로 정렬하고
        // 또 그 구간 별로 정렬
        // 근데 이 구간을 어떻게 관리할거지?
        // 리스트로 정렬 하면

        list.sort(new Comparator<wordList>() {
            @Override
            public int compare(wordList o1, wordList o2) {
                if(o1.count == o2.count) {
                    if(o1.length == o2.length) {
                        return o1.word.compareTo(o2.word);
                    }
                    return Integer.compare(o1.length, o2.length) * -1;
                }
                return Integer.compare(o1.count, o2.count) * -1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (wordList word : list) {
            sb.append(word.word).append("\n");
        }
        System.out.println(sb);
    }
    static class wordList {
        String word;
        int count;
        int length;

        public wordList(String word, int count) {
            this.word = word;
            this.count = count;
            this.length = word.length();
        }

    }
}
