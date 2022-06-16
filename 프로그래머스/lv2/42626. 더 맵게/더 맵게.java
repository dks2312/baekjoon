import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int num : scoville){
            pq.offer(num);
        }
        
        while(pq.peek() < K && pq.size() >= 2){
            pq.offer(pq.poll() + pq.poll()*2);
            answer++;
        }
        
        if(pq.peek() >= K) return answer;
        
        return -1;
    }
}