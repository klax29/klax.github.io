import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueApplications {

	public static ArrayList<Student> topK(ArrayList<Student> students, int k) { // complete this method
		if(k>students.size()) {
			k = students.size();
		}
			PriorityQueue<Student>s = new PriorityQueue<>(new StudentComparator());
			for(int i = 0; i<k; i++) {
				s.add(students.get(i));
			}
			StudentComparator sc = new StudentComparator();
			for(int i=k; i<students.size(); i++) {
				Student min = s.peek();
				Student current = students.get(i);
				if(sc.compare(min, current)<0) {
					s.remove();
					s.add(current);
				}

			}
			ArrayList<Student>n = new ArrayList<Student>();
			for(int i = 0; i<k; i++) {
				s.remove(i);
				n.get(i);
				
			}
			return n;
		}
		

	

	public static ArrayList<Integer> kWayMerge(ArrayList<ArrayList<Integer>> lists) { // complete this method
			PriorityQueue<PriorityQueuePair>pq = new PriorityQueue<>(new PriorityQueuePairComparator());
			ArrayList<PriorityQueuePair>q = new ArrayList<PriorityQueuePair>();
			pq.add(q.get(0));
			int []indexes = new int [lists.size()];
			for(int i = 0; i<lists.size(); i++) { 
				indexes[1] = indexes[i];
			}
			while(!pq.isEmpty()) {
				pq.remove();
				q.add(pq.peek());
				int minItem = indexes[1];
				if(indexes[minItem]<lists.size()) {
					pq.add(q.get(indexes[minItem]));
					indexes[minItem]++;
				}
				
			}
			return q;
		}
	}