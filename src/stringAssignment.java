import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class stringAssignment {
	public static int numword(String word, String para) {
		//Ignore any other variations on the word
		Pattern pattern = Pattern.compile("(^|[^a-zA-Z0-9])"+word+"([^a-zA-Z0-9]|$)");

		//Pattern pattern = Pattern.compile("(^|[^a-zA-Z0-9])"+word+"([^a-zA-Z0-9]|$)");
		Matcher match = pattern.matcher(para);
		int count = 0,pos = 0;
		while(match.find(pos)) {
			if (match.group(2).length()==1){
				pos = match.end()-1;
			}
			else {
				
				pos = match.end();
			}
			count++;
		}
		return count;
	}
	public static int numvowels(String string) {
		Pattern pattern = Pattern.compile("[a|A|e|E|i|I|o|O|u|U]");
		Matcher match = pattern.matcher(string);
		int count = 0;
		while(match.find()) {
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		String word = "why";
		String para = "why why whynotword e why";
		String word2 = "e";
		String para2 = "e e whynotword e e";
		System.out.println(numword(word,para));
		System.out.println(numword(word2,para2));
		System.out.println(numvowels(para));

	}

}
