import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	private int x;
	private int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

public class Main {	
	// 1. 개방된 공간 : 벽과 연결된 공간
	// 2. 밀폐된 공간 : 치즈에 둘러쌓인 공간
	// 3. 치즈 모서리 : 개방된 공간과 맞닿은 면이 2개 이상인 치즈
	// *9 = 개방된 공간
	// *0 = 밀폐된 공간
	// *1 = 치즈
	
	static int N, M;
	static int[][] map = new int[100][100];
	static boolean[][] visi = new boolean[100][100];
	
	static Queue<Pair> queueCheeseDFS = new LinkedList<Pair>();
	
	static int[] xTGWS = new int[] {1, 0, -1, 0};
	static int[] yTGWS = new int[] {0, 1, 0, -1};
	
	static int tetetetetetetete;
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		M = scan.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		
		int day = dayCount();
		
		System.out.println(day);
		System.out.println(tetetetetetetete);

		scan.close();
	}

	private static int dayCount() {
		int day = 0;
		
		while(true) {
			fillVisid();
			ariTen(0, 0);
			fillVisid();
			cheeseDFS(0, 0);
			
			if(queueCheeseDFS.isEmpty()) 
				break;
			
			day++;
			tetetetetetetete = 0;
			while(!queueCheeseDFS.isEmpty()) {
				tetetetetetetete++;
				Pair tmp = queueCheeseDFS.poll();
				map[tmp.getX()][tmp.getY()] = 0;
			}
			
//			print();
		}
		
		return day;
	}

	private static void fillVisid() {
		for(int i = 0; i < N; i++) 
			Arrays.fill(visi[i], false);
	} 
	
	// 벽과 연결된 모든 공간을 공기로 채워줌
	private static void ariTen(int x, int y) {
		visi[x][y] = true;

		if(map[x][y] == 0) {
			for(int k = 0; k < 4; k++) {
				int xTmp = x + xTGWS[k];
				int yTmp = y + yTGWS[k];
				
				if((xTmp < 0 || xTmp >= N) || (yTmp < 0 || yTmp >= M) || map[xTmp][yTmp] == 9) {
					map[x][y] = 9;
					break;
				}
			}
		}
		
		for(int k = 0; k < 4; k++) {
			int xTmp = x + xTGWS[k];
			int yTmp = y + yTGWS[k];
			
			if((xTmp < 0 || xTmp >= N) || (yTmp < 0 || yTmp >= M))
				continue;
			
			if(!visi[xTmp][yTmp] && map[xTmp][yTmp] != 1) {
				ariTen(xTmp, yTmp);
			}
		}
	}

	// 녹는 치즈를 탐색
	private static void cheeseDFS(int x, int y) {
		visi[x][y] = true;
		
		// 치즈인 경우 4면중 2면 이상이 공기과 접촉해있는지 검사
		// 공기와 2면 이상이 접촉된 치즈는 q에 저장
		if(map[x][y] == 1) {
			int count = 0;		
			
			for(int k = 0; k < 4; k++) {
				int xTmp = x + xTGWS[k];
				int yTmp = y + yTGWS[k];
				
				if((xTmp < 0 || xTmp >= N) || (yTmp < 0 || yTmp >= M)) {
					count+=2;
					break;
				}
				
				if(map[xTmp][yTmp] == 9) 
					count++;
			}
			
			if(count >= 1) 
				queueCheeseDFS.offer(new Pair(x, y));
		}
		
		// 다음 행선지로 이동
		for(int k = 0; k < 4; k++) {
			int xTmp = x + xTGWS[k];
			int yTmp = y + yTGWS[k];
			
			if((xTmp < 0 || xTmp >= N) || (yTmp < 0 || yTmp >= M))
				continue;
			
			if(!visi[xTmp][yTmp]) {
				cheeseDFS(xTmp, yTmp);
			}
		}
	}


	private static void print() {
		System.out.println();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}