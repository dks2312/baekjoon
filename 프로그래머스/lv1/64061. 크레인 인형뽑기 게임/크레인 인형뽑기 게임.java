import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        ArrayList<Stack<Integer>> board_stack = new ArrayList<Stack<Integer>>();
        Stack<Integer> basket = new Stack<Integer>();

        for(int j = 0; j < board[0].length; j++){
            board_stack.add(new Stack<Integer>());

            for(int i = board.length-1; i >= 0; i--){
                if(board[i][j] != 0)
                    board_stack.get(j).push(board[i][j]);
            }
        }

        for(int move : moves){
            if(board_stack.get(move-1).isEmpty()) 
                continue;

            int tmp = board_stack.get(move-1).pop();

            if(!basket.empty() && basket.peek() == tmp){
                basket.pop();
                answer += 2;
            }
            else {
                basket.push(tmp);
            }
        }

        return answer;
    }
}