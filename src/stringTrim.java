import java.util.*;

class TrimMethod{
	public static void trim(List<String> args) {
			args.replaceAll(p -> p.trim());
	}
}
public class stringTrim {
	public static void main(String[] args) {
		String[] strings = {"    ssss", "sss    ", "f"};
		List<String> test = Arrays.asList(strings); 
		TrimMethod.trim(test);
		System.out.println(test);

	}
}
