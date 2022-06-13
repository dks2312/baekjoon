import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1. 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
//2. 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다.

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int max = 0, min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (max < map[i][j]) max = map[i][j];
				else if (min > map[i][j]) min = map[i][j];
			}
		}
		
		int answerSeconds = Integer.MAX_VALUE;
		int answerHeight = -1; 
	    
		for (int heigh = min; heigh <= max; heigh++) {
			int second = 0;
			int inventory = B;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int diff = map[i][j] - heigh;
					
					if(diff > 0) {
						second += diff*2;
						inventory += diff;
					}else if(diff < 0){
						second += Math.abs(diff);
						inventory -= Math.abs(diff);
					}
				}
			}
			
			if(inventory >= 0 && second <= answerSeconds) {
				answerSeconds = second;
				answerHeight = heigh;
			}
		}
		
		System.out.println(answerSeconds +" "+ answerHeight);
	}
}