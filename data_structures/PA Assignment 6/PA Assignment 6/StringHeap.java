import java.util.ArrayList;

public class StringHeap {

	private ArrayList<String> heapArray;

	public StringHeap() {
		heapArray = new ArrayList<>();
	}

	public String top() {
		return heapArray.get(0);
	}

	private void swap(int index1, int index2) { // complete this method
		String tmp = heapArray.get(index1);
		heapArray.set(index1, heapArray.get(index2));
		heapArray.set(index2, tmp);
		}

	public void insert(String value) { // complete this method
		int currentIndex = size();
		int parentIndex = currentIndex/2;
		heapArray.add(value);
		while((currentIndex>0) && (heapArray.get(parentIndex).compareTo(heapArray.get(currentIndex))>0)){
			swap(parentIndex, currentIndex);
			currentIndex = parentIndex;
			parentIndex = currentIndex/2;  
		}
	}

	public void extract() { // complete this method
		swap(0, size()-1);
		heapArray.remove(size()-1);
		int  currentIndex = 0, leftIndex = 1, rightIndex = 2;
		while(leftIndex<size()) {
			int minIndex = leftIndex;
			String minKey = heapArray.get(minIndex);
			if(rightIndex<size()) {
				String rightKey = heapArray.get(rightIndex);
				if(rightKey.compareTo(minKey) < 0) {
					minIndex = rightIndex;
					minKey = rightKey;
				}
			}
			if(minKey.compareTo(heapArray.get(currentIndex))<0) {
				swap(minIndex, currentIndex);
				currentIndex = minIndex;
			}
			else {
				break;
			}
			leftIndex = currentIndex+1;
			rightIndex = leftIndex+1;
		}
	}

	public static void heapSort(String array[], int arrayLen) throws Exception { // complete this method
		StringHeap n = new StringHeap();
		for(int i = 0; i<arrayLen; i++) {
			n.insert(array[i]);
		}
		for(int i = 0; i<arrayLen; i++) {
			array[i] = n.top();
			n.extract();
		}
		
	}

	public int size() {
		return heapArray.size();
	}

	public String toString() {
		return heapArray.toString();
	}
}