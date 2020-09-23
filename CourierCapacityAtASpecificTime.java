package com.two.anubha.java.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*You have an input like following with startTime and endTime for each person who can get the courier and the 
 * capacity that they can deliver in that time frame. The start and endTime can have numbers as big as MAX_INTEGER value. 
 * The input is something like following:
 * [{start:8, end:12, capacity: 3},
 * {start: 10, end:14, capacity: 1},
 * {start:13, end: 18, capacity: 5}]
 * 
 * The output should be something like following:
 * [{t:8, capacity:3},
 * {t:10, capacity:4},
 * {t:12, capacity:1},
 * {t:13, capacity:6},
 * {t:14, capacity:5},
 * {t:15, capacity:0}]*/

class TimeAndCapacityForEachUser{
	private int startTime;
	private int endTime;
	private int capacity;
	
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}

class OutputClass{
	private int t;
	private int capacity;
	
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}

public class CourierCapacityAtASpecificTime {
	
	private static List<HashMap<String, Integer>> getCapacityAtTime(List<TimeAndCapacityForEachUser> inputList){
		List<HashMap<String, Integer>> retList = new ArrayList<>();
		
		List<OutputClass> outputList = new ArrayList<>();
		
		HashMap<Integer, Integer> mapObj = new HashMap<>();
		
		for(int i=0; i<inputList.size(); i++){
			TimeAndCapacityForEachUser inputObj = inputList.get(i);
			
			if(mapObj.containsKey(inputObj.getStartTime())){
				mapObj.put(inputObj.getStartTime(), mapObj.get(inputObj.getStartTime()) + inputObj.getCapacity());
			}else{
				mapObj.put(inputObj.getStartTime(), inputObj.getCapacity());
			}
			
			if(mapObj.containsKey(inputObj.getEndTime())){
				mapObj.put(inputObj.getEndTime(), mapObj.get(inputObj.getEndTime()) - inputObj.getCapacity());
			}else{
				mapObj.put(inputObj.getEndTime(), - inputObj.getCapacity());
			}
			
		}
		
		TreeMap<Integer, Integer> sortedMap = new TreeMap<>(mapObj);
		//Put in OutputClass
		
		int previousValue = 0;
		for(Map.Entry<Integer, Integer> entryObj : sortedMap.entrySet()){
			OutputClass outObj = new OutputClass();
			
			outObj.setT(entryObj.getKey());
			
			previousValue += entryObj.getValue();
			outObj.setCapacity(previousValue);
			
			outputList.add(outObj);
		}
		
		//return in the desired format
		for(int i=0; i<outputList.size(); i++){
			HashMap<String, Integer> mapO = new HashMap<>();
			
			mapO.put("t", outputList.get(i).getT());
			mapO.put("capacity", outputList.get(i).getCapacity());
			
			retList.add(mapO);
		}
		
		/*inputList.stream()
		         .sorted(Comparator.comparing(TimeAndCapapcityForEachUser::getStartTime));*/
		
		return retList;
	}
	
	public static void main(String[] args){
		
		List<TimeAndCapacityForEachUser> inputList = new ArrayList<>();
		TimeAndCapacityForEachUser obj1 = new TimeAndCapacityForEachUser();
		obj1.setStartTime(8);
		obj1.setEndTime(12);
		obj1.setCapacity(3);
		inputList.add(obj1);

		TimeAndCapacityForEachUser obj3 = new TimeAndCapacityForEachUser();
		obj3.setStartTime(14);
		obj3.setEndTime(18);
		obj3.setCapacity(5);
		inputList.add(obj3);

		TimeAndCapacityForEachUser obj2 = new TimeAndCapacityForEachUser();
		obj2.setStartTime(10);
		obj2.setEndTime(15);
		obj2.setCapacity(1);
		inputList.add(obj2);
		
		List<HashMap<String, Integer>> retList = getCapacityAtTime(inputList);
		System.exit(0);
	}

}
