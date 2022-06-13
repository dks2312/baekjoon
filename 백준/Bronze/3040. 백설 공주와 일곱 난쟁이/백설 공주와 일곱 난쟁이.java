import java.util.Scanner;

public class Main {		
	private static int ret[] = new int[7];
	private static int numbers[] = new int[9];
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
				
		for(int i = 0; i < 9; i++) {
			numbers[i] = scan.nextInt();
		}
		
		wow(0, 0);
		
		scan.close();
	}
	
	
	private static void wow(int cnt, int start) {
		if(cnt == 7) {
			int total = 0;
			for(int i = 0 ; i < ret.length; i++)
				total += ret[i];
			
			if(total == 100) {
				for(int i = 0 ; i < ret.length; i++)	
					System.out.println(ret[i]);	
			}
			
			return;
		}
		
		for(int i = start; i < numbers.length; i++) {
			ret[cnt] = numbers[i];
			wow(cnt+1, i+1);
		}
	}
}