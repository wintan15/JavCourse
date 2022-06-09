import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

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
	public static void validity() {

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
        Pattern opening,closing;
        Matcher match,end;
		while(testCases>0){
			String line = in.nextLine();
			opening = Pattern.compile("(<[^>]+>)");
            closing = Pattern.compile("(<[/]?[^>]+>)");
            match = opening.matcher(line);
            end = closing.matcher(line);
            int pos = 0;
            boolean found = false;
            while(match.find(pos)) {
                if(end.find(match.end()) && 
                end.group(1).substring(2).equals(match.group(1).substring(1))) {
                    if(match.end() == end.start()){
                        pos = end.end();
                        continue;
                    }
                    System.out.println(line.substring(match.end(), end.start()));
                    pos = end.end();
                    found = true;
                    continue;
                }
                pos = match.end();
            }
            if(!found){
                System.out.println("None");
            }			
			testCases--;
		}
        in.close();
	}
	public static void main(String[] args) {
		String word = "why";
		String para = "why why whynotword e why";
		String word2 = "e";
		String para2 = "e e whynotword e e";
		System.out.println(numword(word,para));
		System.out.println(numword(word2,para2));
		System.out.println(numvowels(para));
		validity();

	}

}
