import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Main {
	// N -> 리스트에 있는 현재 점수 갯수
	// P -> 리스트의 총 크기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long taesu = Long.parseLong(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int rank = 1;
		
		ArrayList<Long> list = new ArrayList<>();
		if(N > 0) {
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			list.add(Long.parseLong(st.nextToken()));
		}

        if(list.get(N-1) >= taesu && list.size() == P) {
			System.out.println("-1");
			return;
		}
          
		if(list.size() < P) {
			list.add(taesu);
			list.sort((o1,o2) -> Long.compare(o1, o2)*-1);
		}
		
		if(list.get(N-1) >= taesu && list.size() > P) {
			System.out.println("-1");
			return;
		}
		
		
		Iterator<Long> iterator = list.iterator();
		while(iterator.hasNext()) {
			long num = iterator.next();
			
			if(num > taesu) {
				rank++;
			} else if(num == taesu) {
				continue;
			} else {
				break;
			}
		}
		
		System.out.println(rank);
		} else {
			System.out.println(1);
		}
		
	}
}
