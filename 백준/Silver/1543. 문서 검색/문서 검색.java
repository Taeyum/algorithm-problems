import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int totalCount = 0;
		char[] text = br.readLine().toCharArray();
		char[] search = br.readLine().toCharArray();
		
		for(int i = 0 ; i < text.length ; i++) {
			int count = 0;
			for(int j = 0 ; j < search.length ; j++) {
				if(j+i >= text.length || text[j+i] != search[j]) {
					break;
				} else {
					count++;
				}

				if(count == search.length) {
					totalCount++;
					i += search.length - 1;
				}
			}
		}
		System.out.println(totalCount);
		
		
	}
}
