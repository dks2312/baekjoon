import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = new String[numbers.length] ;
        for(int i = 0; i < arr.length; i++) {
        	arr[i] = numbers[i] +"";
        }
        
        
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String o1, String o2){
                return ((o2+o1).compareTo(o1+o2));
            }
        });
        
        for(String num : arr){
            answer += num;
        }
        
        answer = answer.replaceAll("^0+", "0");
        
        return answer;
    }
}