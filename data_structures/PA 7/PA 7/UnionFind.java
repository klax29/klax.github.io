import java.util.ArrayList;

public class UnionFind {

	private ArrayList<ArrayList<Integer>> representatives;

	public UnionFind(int initialNumSets) { // complete this constructor
		representatives = new ArrayList<ArrayList<Integer>>(initialNumSets);
		for(int i = 0; i<initialNumSets; i++) {
			representatives.add(new ArrayList<Integer>());
			makeSet(i);
		}
	}

	public void makeSet(int x) { // complete this method
		ArrayList<Integer>da = new ArrayList<Integer>();
		da.add(x);
		da = representatives.get(x);
	}

	public ArrayList<Integer> find(int x) { // complete this method
		return representatives.get(x);
	}

	private void append(ArrayList<Integer> arg1, ArrayList<Integer> arg2) { // complete this method
		while(!(arg2.size()==0)) {
			Integer x = null;
			arg2.add(x);
			arg2.remove(arg2.size()-1);
			arg1 = representatives.get(x);
			arg1.add(x);
		}
	}

	public void doUnion(int x, int y) { // complete this method
		ArrayList<Integer>dax = new ArrayList<Integer>();
		ArrayList<Integer>day = new ArrayList<Integer>();
		dax = find(x);
		day = find(y);
		if(dax!=day) {
			if(dax.size()>=day.size()) {
				append(dax, day);
			}
			else {
				append(day, dax);
			}
		}
	}
}