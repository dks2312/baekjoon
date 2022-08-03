import java.util.Scanner;

public class Main {	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		
		StringBuilder star = new StringBuilder();
		StringBuilder air = new StringBuilder();
		
		int cut = scan.nextInt();
		
		for(int i = 1; i <= cut; i++) 
			air.append(' ');
		
		for(int i = 1; i <= cut; i++) {
			star.append('*');
			air.setLength(cut-i);
			
			System.out.print(air);
			System.out.println(star);
		}
		
		scan.close();
	}
}