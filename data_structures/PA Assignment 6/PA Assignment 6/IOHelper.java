import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class IOHelper {

	public static ArrayList<Student> readStudents(String filePath) throws FileNotFoundException { // complete this method
		ArrayList<Student> n = new ArrayList<Student>();
		Scanner fileReader = new Scanner(new FileReader(filePath));
		while(fileReader.hasNext()) {
			String s = fileReader.next();
			int g = fileReader.nextInt();
			Student p = new Student(s, g);
			n.add(p);
			
		}
		return n;
		
	}

	public static Graph readWeightedGraph(String filePath) throws FileNotFoundException { // complete this method
	}

}