import java.util.*;
import java.util.stream.Stream;
public class streamAss {
	public static void main(String[] args) {
		for(String i: args) {
			System.out.println(i);
		}
		Stream<String> stream = Arrays.stream(args);
		stream.forEach(p -> System.out.println(p));
		
	}

}
