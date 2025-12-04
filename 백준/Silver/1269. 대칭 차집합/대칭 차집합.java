import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int countA = 0;
        int countB = 0;

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        for (Integer i : setA) {
            if(!setB.contains(i)) countA++;

        }

        for (Integer i : setB) {
            if(!setA.contains(i)) countB++;
        }

        System.out.println(countA + countB);
    }
}
