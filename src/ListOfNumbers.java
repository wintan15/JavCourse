import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
public class ListOfNumbers {
	
	public static void main(String[] args){
		String fname = "test.txt";
		String line;
		ArrayList<Integer> collection = new ArrayList<Integer>();
		try {
		BufferedReader br = new BufferedReader(new FileReader(fname));
		while((line = br.readLine())!=null) {
			String[] arr = line.split(" ");
			for(String i: arr) {
				collection.add(Integer.parseInt(i));
			}
		}
		br.close();
		for (Integer i : collection) {
			System.out.println(i);
		}
		} catch (IOException e) {
			System.err.println("Exception Occured");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("Not only integers in file");
		}
	}

}
