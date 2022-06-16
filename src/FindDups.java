import java.util.*;
import java.util.stream.*;

class StringComparator implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		return o1.compareToIgnoreCase(o2);
	}
	
}
public class FindDups {
    public static void main(String[] args) {
        SortedSet<String> distinctWords = new TreeSet<String>(new StringComparator());
        Arrays.asList(args).stream().forEach(p -> distinctWords.add(p)); 
        System.out.println(distinctWords.size()+ 
                           " distinct words: " + 
                           distinctWords);
        
    }
}