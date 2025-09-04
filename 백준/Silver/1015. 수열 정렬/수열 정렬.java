import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Pair[] pairs = new Pair[N];

        for (int i = 0; i < N; i++) {
            pairs[i] = new Pair(sc.nextInt(), i);
        }

        Arrays.sort(pairs);

        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            p[pairs[i].index] = i;
        }

        for (int result : p) {
            System.out.print(result + " ");
        }
    }
    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }
}