import java.util.Scanner;

public class Main {		
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		
		int[] numbers = new int[9];
		
		for(int i = 0; i < 9; i++) {
			numbers[i] = scan.nextInt();
		}
		
		int[] tmp = wow(numbers);
		
		for(int i = 0; i < 7; i++) {
			System.out.println(numbers[tmp[i]]);
		}
		
		scan.close();
	}
	
	private static int[] wow(int[] numbers) {
		for(int n1 = 0; n1 < 9; n1++) {
			for(int n2 = n1+1; n2 < 9; n2++) {
				for(int n3 = n2+1; n3 < 9; n3++) {
					for(int n4 = n3+1; n4 < 9; n4++) {
						for(int n5 = n4+1; n5 < 9; n5++) {
							for(int n6 = n5+1; n6 < 9; n6++) {
								for(int n7 = n6+1; n7 < 9; n7++) {
									if(numbers[n1]+numbers[n2]+numbers[n3]+numbers[n4]+numbers[n5]+numbers[n6]+numbers[n7] == 100) {
										int[] ret = new int[] {n1, n2, n3, n4, n5, n6, n7};
										return ret;
									}
								}
							}
						}
					}
				}
			}
		}
		// 어처피 갈 일 없음
		return null;
	}
}