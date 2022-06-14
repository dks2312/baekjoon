import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        ArrayList<Queue<Integer>> QList = new ArrayList<Queue<Integer>>(board.length);
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < board[0].length; i++) {
        	Queue<Integer> QTmp = new LinkedList<Integer>();
        	
        	for(int j = 0; j < board.length; j++) {
        		if(board[j][i] != 0)
        			QTmp.offer(board[j][i]);
        	}
        	
        	QList.add(QTmp);
        }
        
        for(int move : moves) {
        	if(QList.get(move-1).isEmpty()) 
        		continue;
        	
        	int e = QList.get(move-1).poll();
        	
    		if(!stack.isEmpty() && stack.peek() == e) {
    			stack.pop();
    			answer += 2;
    		}
    		else stack.push(e);
        }
        
        return answer;
    }
}