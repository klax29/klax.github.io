
import java.util.Comparator;

public class StudentComparator implements Comparator<Student> { // complete this class
	public int compare(Student arg1, Student arg2) {
		if(!arg1.equals(arg2)) {
			return arg1.grade - arg2.grade;
		}
		else {
			return arg1.name.compareTo(arg2.name);
		}
	}
}