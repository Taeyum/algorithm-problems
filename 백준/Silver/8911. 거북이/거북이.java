import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 총 가로 세로 길이 구해서 하면 될거 같은데...?
public class Main {
	static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dy = {0, 1, 0 , -1};
	static int upY, downY, rightX, leftX;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			String[] str = br.readLine().split("");
			
			int x = 0, y = 0;
			downY = 0;
			upY = 0;
			leftX = 0;
			rightX = 0;
			int state = 0;
			
			for(int i = 0 ; i < str.length ; i++) {
				String s = str[i];
				switch(s) {
				// 전진
				case "F" :
					x += dx[state];
					y += dy[state];
					break;
				// 후진
				case "B" :
					x -= dx[state];
					y -= dy[state];
					break;
				// 좌 회전 
				case "L" :
					state = (state + 3) % 4;
					break;
				// 우 회전 
				case "R" :
					state = (state + 1) % 4;
					break;
				}
				
				if(!s.equals("L") && !s.equals("R")) {
					leftX = Math.min(x, leftX);
					rightX = Math.max(x, rightX);
					downY = Math.min(y, downY);
					upY = Math.max(y, upY);					
				}
			}
			
			int width = rightX - leftX;
			int height = upY - downY;
			System.out.println(width * height);
		}
	}
}
