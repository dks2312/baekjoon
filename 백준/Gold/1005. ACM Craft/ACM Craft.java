import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {	
	private static final boolean Integer = false;

	static Scanner scan = new Scanner(System.in);
	
	static int towerNum, K,target;
	static int[] towerCost;
	static ArrayList<Integer>[] towerLine;
	
	static int[] towerLineCut;
	static int[] result;
	
	private static void input() {
		towerNum = scan.nextInt();
		K = scan.nextInt();
		
		towerCost = new int[towerNum + 1];
		towerLine = new ArrayList[towerNum + 1];
		towerLineCut = new int[towerNum + 1];
		result = new int[towerNum + 1];
		
		
		for(int i = 1; i <= towerNum; i++) 
			towerCost[i] = scan.nextInt();
		
		for(int i = 1; i <= towerNum; i++) 
			towerLine[i] = new ArrayList<Integer>();
		
		
		for(int i = 1; i <= K; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			towerLine[a].add(b);
			towerLineCut[b]++;
		}
		
		target = scan.nextInt();
	}	
	
	private static int topologicalSort(){
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i < towerLineCut.length; i++) {
			result[i] = towerCost[i];
			
			if(towerLineCut[i] == 0)  
				q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
						
			Iterator<Integer> iTL = towerLine[node].iterator();
			while(iTL.hasNext()) {
				int temp = iTL.next();
				
				result[temp] = Math.max(result[temp], result[node] + towerCost[temp]);
				
				towerLineCut[temp]--;
				
				if(towerLineCut[temp] == 0) {
					q.offer(temp);
				}
			}
		}
		
		return result[target];
	}
	
	public static void main(String[] args) {
		int testCase;
		
		testCase = scan.nextInt();
		
		while(testCase-- > 0) {
			input();
			System.out.println(topologicalSort());
		}
	}
}
