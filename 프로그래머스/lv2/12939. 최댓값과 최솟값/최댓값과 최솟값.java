class Solution {
    public String solution(String s) {
        String answer = "";
        
        // s = "1000 123 12345";
        
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, num = 0;
        
        boolean negative = false;
        
        for(int i = 0; i < s.length(); i++){
            //부호체크
            if(s.charAt(i) == '-') negative = true;
            //숫자일경우 
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                num *= 10;
                num += (int)(s.charAt(i)-48);
            }
            //마지막 문자거나 다음 문자가 공백일 경우
            if(i == s.length()-1 || s.charAt(i+1) == ' '){
                //부호가 - 였을경우 음수로 바꾼다.
                if(negative == true) num = -num;
                negative = false;
                //숫자 최대 최소 비교를 한다.
                if(num > max) max = num;
                if(num < min) min = num;
                num = 0;
                i++;
            }
        }
        
        answer = min+" "+max;
        
        // System.out.println(answer);
        
        return answer;
    }
}