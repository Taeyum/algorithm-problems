import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Num[][] board;
	static boolean[][] check;
	static Queue<Integer> game;
	static int[] dx = {-1, 0 , 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int time;
	static int bingoCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new Num[5][5];
		check = new boolean[5][5];
		game = new ArrayDeque();
		
		for(int i = 0 ; i < 5 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5 ; j++)
				board[i][j] = new Num(i, j, Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0 ; i < 5 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5 ; j++)
				game.offer(Integer.parseInt(st.nextToken()));
		}
		
		while(!game.isEmpty() && bingoCount < 3) {  
			bingoCount = 0;  
			
			int number = game.poll();
			for(int i = 0 ; i < 5 ; i++)
				for(int j = 0 ; j < 5 ; j++)
					if(board[i][j].num == number) { 
						int x = board[i][j].x;
						int y = board[i][j].y;
						check[x][y] = true;
						time++;
					}
			
			crossCheck();
			reverseCrossCheck();
			rowCheck();
			colCheck();
		}
		
		System.out.println(time);
		
	}
	
	static void rowCheck() {
		for(int i = 0 ; i < 5 ; i++) {
			int rowCount = 0;
			for(int j = 0 ; j < 5 ; j++)
				if(check[i][j])		rowCount++;
			if(rowCount == 5)	bingoCount++;
		}
	}
	
	static void colCheck() {
		for(int i = 0; i < 5 ; i++) {
			int colCount = 0;
			for(int j = 0 ; j < 5 ; j++)
				if(check[j][i])		colCount++;
			if(colCount == 5)	bingoCount++;
		}
	}
	
	static void crossCheck() {
		for(int i = 0 ; i < 5; i++)
			if(!check[i][i])
				return;
		
		bingoCount++;
	}
	
	static void reverseCrossCheck() {
		int n = 0;
		for(int i = 4 ; i >= 0 ; i--)
			if(!check[i][n++])
				return;
		
		bingoCount++;
	}
	
	
	static class Num {
		int x,y,num;

		public Num(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
	}
}
