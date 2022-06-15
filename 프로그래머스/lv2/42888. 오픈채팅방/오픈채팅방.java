import java.util.HashMap;
import java.util.LinkedList;

class Solution {
	public String[] solution(String[] record) {
        String[] answer = {};
        LinkedList<String> sb = new LinkedList<String>();
        HashMap<String, String> id_name_list = new HashMap<String, String> ();
        
        for(String reco : record){
            String[] reco_line = reco.split(" ");
            
            if(reco_line.length != 2)
                id_name_list.put(reco_line[1], reco_line[2]);
        }
        
        for(String reco : record){
            String[] reco_line = reco.split(" ");
            
            if(reco_line[0].equals("Enter"))
            	sb.add(id_name_list.get(reco_line[1]) +"님이 들어왔습니다.");
            else if(reco_line[0].equals("Leave"))
            	sb.add(id_name_list.get(reco_line[1]) +"님이 나갔습니다.");
        }
        
        answer = sb.toArray(new String[sb.size()]);
        
        return answer;
    }
}