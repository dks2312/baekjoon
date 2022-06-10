import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;


class user{
    private int id;
    private String name;
    private ArrayList<String> report = new ArrayList<String>();
    private int mail;
    private int warn;
    
    user(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public void appendReport(String name){
        if(!report.contains(name)){
            this.report.add(name);
            this.warn++;
        }
    }
    
    public ArrayList<String> getReport(){
        return report;
    }
    
    public int getWarn(){
        return this.warn;
    }
    
    public int getId(){
        return this.id;
    }
    
    
    public void print(){
        System.out.print("~~~이름: "); 
        System.out.println(name);
        System.out.println(report);
        System.out.println(mail);
        System.out.println(warn);
    }
}


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, user> user_map = new HashMap<String, user>();
        int[] answer = new int[id_list.length];
        
        Arrays.fill(answer, 0);
        
        for(int i = 0; i < id_list.length; i++){
            user_map.put(id_list[i], new user(i, id_list[i]));
        }
        
        for(String str : report){
            String[] AB = str.split(" ");
            
            user_map.get(AB[1]).appendReport(AB[0]);
        }
        
        for(Map.Entry<String, user> entry : user_map.entrySet()){
            if(entry.getValue().getWarn() >= k){
                Iterator<String> it = entry.getValue().getReport().iterator();

                while(it.hasNext()){
                    String vaule = it.next();
                    answer[user_map.get(vaule).getId()]++;
                }
            }
        }
        
        return answer;
    }
}