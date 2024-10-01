
public class BinarySearchApplications {

	public static int minIndexBinarySearch(int array[], int arrayLength, int key) { // complete this method
		int left = 0, right =arrayLength-1, minIndex = -1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(array[mid] == key) {
				minIndex = mid;
				right = left - 1;
			}
			else if(array[mid] > key) {
				right = mid - 1;
			}
			else if(array[mid]<key) {
				left = mid +1;
			}
		}
		return minIndex;
	}

	public static int maxIndexBinarySearch(int array[], int arrayLength, int key) { // complete this method
		int left = 0, right = arrayLength-1, maxIndex = -1;
		while(left<=right) {
			int mid = (left+right) / 2;
			if(array[mid] == key) {
				maxIndex = mid;
				left = mid + 1;
			}
			else if(array[mid]<key) {
				left = mid +1;
			}
			else if(array[mid]>key) {
				right = mid -1;
			}
			
		}
		return maxIndex;
	}

	public static int countNumberOfKeys(int array[], int arrayLength, int key) { // complete this method
		int left = minIndexBinarySearch(array, arrayLength, key), right = maxIndexBinarySearch(array, arrayLength, key);
		if(left == -1){
			return 0;
			
		}
		else {
			return (right - left) + 1 ;
		}
		
		
	}
	
	public static int predecessor(int array[], int arrayLen, int key) { // complete this method
		int left = 0, right = arrayLen-1, n = -1;
		while (left<=right) {
			int mid = (left + right)/ 2;
			if(array[mid] == key) {
				return mid;
			}
			else if(array[mid]>key) {
				right = mid -1;
			}
			else if(array[mid]<key) {
				n = mid;
				left = mid + 1;
			}
		}
		return n;
		
	}

	public static int findPeak(int twoToneArray[], int arrayLen) { // complete this method
		int left = 0, right = arrayLen-1; int predIndex = 0;
		while(left<=right) {
			int mid = (left+right)/2;
			if(left == right) {
				return right;
			}
			else if((right == left + 1) && (twoToneArray[left]>twoToneArray[right])) {
				return left;
			}
			else if((right == left + 1) && (twoToneArray[right]>twoToneArray[left])) {
				return right;
			}
			
			if(twoToneArray[mid]<twoToneArray[mid + 1]) {
				left = mid + 1;
			}
			else if(twoToneArray[mid]<twoToneArray[mid - 1]) {
				right = mid - 1;
			}
			
			else {
				return mid;
			}
		}
		return predIndex;

	}
}

