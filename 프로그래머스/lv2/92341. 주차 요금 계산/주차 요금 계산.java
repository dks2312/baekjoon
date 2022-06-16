import java.util.*;

class Solution {
	public int[] solution(int[] fees, String[] records) {
		int[] answer = new int[1000];
		
		TreeMap<String, Car> car_park = new TreeMap<String, Car>();

		for (String s : records) {
			String[] time_id_inOut = s.split(" ");
			String timeStr = time_id_inOut[0];
			String id = time_id_inOut[1];
			String[] tmp = timeStr.split(":");
			int time = Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
			
			if (time_id_inOut[2].equals("IN")) {
				if(car_park.containsKey(id))
					car_park.get(id).startParkTime(time);
				else 
					car_park.put(id, new Car(time));
			}
			else {
				car_park.get(id).endParkTime(time);
			}
		}
		
		
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		for( Map.Entry<String, Car> elem : car_park.entrySet() ){ 
			// 아직 주차돼 있는 차량이라면 23:59로 출차 
			if(elem.getValue().isPark()) 
				elem.getValue().endParkTime(1439);
			
			// 주차 요금 계산
			int car_time = elem.getValue().getSumTime();
			
			if(car_time <= fees[0]) tmp.add(fees[1]);	
			else tmp.add(fees[1] + (int)Math.ceil((double)(car_time - fees[0])/fees[2]) * fees[3]);
			
		}
		
		List<Integer> list = new ArrayList<Integer>(tmp);
		int[] answerTmp = new int[list.size()];
		int i = 0;
		for(Integer li : list) {
			answerTmp[i++] = li;
		}
		answer = answerTmp;
		
		return answer;
	}
}

class Car {
	private boolean isPark;
	private int startTime;
	private int sumTime = 0;

	Car(int startTime) {
		startParkTime(startTime);
	}
	
	public void startParkTime(int startTime) {
		isPark = true;
		this.startTime = startTime;
	}

	public void endParkTime(int endTime) {
		isPark = false;
		sumTime += endTime - startTime;
	}

	public int getSumTime() {
		return sumTime;
	}
	public boolean isPark() {
		return isPark;
	}
}