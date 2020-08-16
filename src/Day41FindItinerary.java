/*
 * Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, 
 * and a starting airport, compute the person's itinerary. If no such itinerary exists, return null. 
 * If there are multiple possible itineraries, return the lexicographically smallest one. 
 * All flights must be used in the itinerary.
 * 
 * For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] 
 * and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
 * 
 * Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.
 * Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', 
 * you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. 
 * However, the first one is lexicographically smaller.
 */

import java.util.*;

public class Day41FindItinerary {

	public static void main(String[] args) {
		
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("SFO", "HKO");
		hmap.put("YYZ", "SFO");
		hmap.put("YUL", "YYZ");
		hmap.put("HKO", "ORD");
		
		String starting = "YUL";
		
		System.out.println("The itinerary is: " + printItin(hmap, starting));
	}
	
	private static List<String> printItin(Map<String, String> hmap, String starting) {
		
		List<String> list = new ArrayList<String>();
		list.add(starting);
		
		Map<String, String> rev = new HashMap<String, String>();
		for(Map.Entry<String, String> entry: hmap.entrySet()) {
			rev.put(entry.getValue(), entry.getKey());
		}
		
		
		for(Map.Entry<String, String> entry : hmap.entrySet()) {
			
			if(!rev.containsKey(entry.getKey())) {
				list.add(entry.getKey());;
			} else {
				return null;
			}
		}
		return list;
	}

}
