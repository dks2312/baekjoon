class Solution {
    public int[] solution(int[] prices) {
        int price_len = prices.length;
        int[] answer = new int[price_len];
        
        for(int i = 0; i < price_len; i++){
            int count = 0;
            for(int j = i+1; j < price_len; j++){
                count++;
                if(prices[i] > prices[j]) 
                    break;
            }
            
            answer[i] = count;
        }
        
        return answer;
    }
}