import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken()); //세로
        int M = Integer.parseInt(st.nextToken()); //가로
        int B = Integer.parseInt(st.nextToken()); //인벤토리 블록 겟수

        int[][] world = new int[N][M];

        int max_world = 0;
        int min_world = 256;

        for(int i = 0; i < N; i++){
        	st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                world[i][j] = Integer.parseInt(st.nextToken());
                
                if(world[i][j] > max_world) max_world = world[i][j];
                if(world[i][j] < min_world) min_world = world[i][j];
            }
        }

        // System.out.println("max = " + max_world);
        // System.out.println("min = " + min_world);

        //제일 낮은곳을 채우면서 해야하는 시간량과
        //제일 높은곳을 깍으면서 해야하는 시간량을 계산한다.
        //낮은곳부터 채우다가 인벤토리블럭이 없으면 탈출한다.
        int time = 125000000, lev = -1;
        all: for(int w = max_world; w >= min_world; w--){
            int inputblock = 0; //채우는 블럭
            int breakblock = 0; //부수는 블럭
            int blockstock = B;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    //기준보다 높을시 블럭을 깍는다.
                    if(world[i][j] > w){
                        //깍아야 하는 블럭갯수
                        breakblock += world[i][j] - w;
                        //인밴토리에 추가되는 블럭 갯수
                        blockstock += world[i][j] - w;
                    }
                    //기준보다 작을시 블럭을 채운다.
                    if(world[i][j] < w){
                        //채워야하는 블럭갯수
                        inputblock += w - world[i][j];
                        //인벤토리에 감소되는 블럭갯수
                        blockstock -= w - world[i][j];
                    }
                }
            }
            //사용해야하는 블럭이 모자라면 다음 케이스
            if(blockstock < 0) continue all;
            //블럭이 최대한 딱맞아 떯어지면 그게 최적값이다.
            if(inputblock + (breakblock * 2) >= time) break all;
            
            time = inputblock + (breakblock * 2);
            lev = w;
        }
        System.out.println(time + " " + lev);
    }
}