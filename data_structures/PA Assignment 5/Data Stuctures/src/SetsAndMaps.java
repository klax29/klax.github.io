import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetsAndMaps {

	public static ArrayList<Character> sortedAlphabet(char[] arr, int len) { // complete this method
		TreeSet<Character> mySet = new TreeSet<>();
		ArrayList<Character>alpha = new ArrayList<>();
		for(char i = 0; i<len; i++) {
			mySet.add(arr[i]);
		}
		Iterator<Character>it = mySet.iterator();
		while(it.hasNext()) {
			alpha.add(it.next());
		}

		return alpha;
	}

	public static void bstSort(char[] arr, int len) { // complete this method
		TreeMap <Character, Integer> myMap = new TreeMap<>();
		Iterator<Character>it = myMap.keySet().iterator();
		for(int i = 0; i<len; i++) {
			
			if(!myMap.containsKey(arr[i])) {
				myMap.put(arr[i],1);
			}
			else {
				int value = myMap.get(arr[i]);
				value ++;
				myMap.put(arr[i], value);
			}
		
		}
		Iterator<Character>it2 = myMap.keySet().iterator();
		int j = 0;
		while(it2.hasNext()) {
			Character c = it2.next();
			Integer v = myMap.get(c); 
			for(int i = 0; i<v; i++) {
			arr[j] = c;
			j++;
			}
			
		}

	}

	public static boolean zeroSumSubArray(int[] arr, int len) { // complete this method
		HashSet<Integer>mySet = new HashSet<>();
		int prefixSum = 0;
		Iterator<Integer> it = mySet.iterator();
		while(it.hasNext()) {
			mySet.add(prefixSum +1);
			if(prefixSum == 0) {
				return true;
			}
			if(mySet.contains(prefixSum)) {
				return true;
			}
			else {
				mySet.add(prefixSum);
			}
		}
		return false;
	}

	public static ArrayList<Integer> kHeavyHitters(int[] arr, int len, int k) { // complete this method 
		HashMap<Integer,Integer>myMap = new HashMap<>();
		Iterator<Integer>it = myMap.keySet().iterator();
		ArrayList<Integer>kh = new ArrayList<>();
		for(int i = 0; i<len; i++) {
			
			if(!myMap.containsKey(arr[i])) {
				myMap.put(arr[i],1);
			}
			else {
				int value = myMap.get(arr[i]);
				value ++;
				myMap.put(arr[i], value);
			}
			
		}
		Iterator<Integer>it2 = myMap.keySet().iterator();
		while(it2.hasNext()) {
			Integer key = it2.next();
			Integer value = myMap.get(key);
			if(value > (len/k)) {
				kh.add(key);
				myMap.put(key, 0);
				
			}
			
		}
		
		return kh;
	
	}

}



