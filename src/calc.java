import java.util.Scanner;
import java.util.regex.Pattern;
import java.lang.Math;

import java.util.regex.Matcher;

class Calculator{
	float value = 0;
	public void beginCalculate() {
		System.out.println("Supported operators: +,-,*,/ \n"
				+ "Initial Stored value is " + this.value +"\n"
				+ "Operator acts on stored value if line begins with it \n" 
				+ "Processes only first operation on each line \n"
				+ "Enter 'd' to quit.");
		Scanner inp = new Scanner(System.in);
		String y = inp.nextLine();
		Pattern mem = Pattern.compile("^ *([+\\*/-]) *([0-9]+.?[0-9]*)");
		Pattern raw = Pattern.compile("^ *([0-9]+.?[0-9]*) *([+\\*/-]) *([0-9]+.?[0-9]*)");
		while (!y.equals("d")) {
			calcinput(mem, raw, y);
			y = inp.nextLine();
		}
		inp.close();
	}
	public void calcinput(Pattern mem, Pattern raw, String y) {
		Matcher memtest, rawtest;
		memtest = mem.matcher(y);
		rawtest = raw.matcher(y);
		if (memtest.find()) {
			System.out.println("Result: " + singleCalculate(memtest.group(1),Float.parseFloat(memtest.group(2))));
		} else if (rawtest.find()) {
			this.value = Float.parseFloat(rawtest.group(1));
			System.out.println("Result: " + singleCalculate(rawtest.group(2),Float.parseFloat(rawtest.group(3))));
			}
		else {
			System.out.println("Command not recognized");
		}
		
	}
	public float singleCalculate(String operator, float num2) {
		switch(operator) {
		case "+" :
			this.value = this.value + num2;
			break;
		case "-":
			this.value = this.value - num2;
			break;
		case "*":
			this.value = this.value * num2;
			break;
		case "/":
			this.value = this.value / num2;
			break;
		}
		return this.value;
	}
	
}
class ScientificCalculator extends Calculator{
	public void beginCalculate() {
		System.out.println("Supported operators: +,-,*,/,^ \n"
				+ "Initial Stored value is " + this.value +"\n"
				+ "Operator acts on stored value if line begins with it \n" 
				+ "Processes only first operation on each line \n"
				+ "Enter 'd' to quit.");
		Scanner inp = new Scanner(System.in);
		String y = inp.nextLine();
		Pattern mem = Pattern.compile("^ *([+^\\*/-]) *([0-9]+.?[0-9]*)");
		Pattern raw = Pattern.compile("^ *([0-9]+.?[0-9]*) *([+^\\*/-]) *([0-9]+.?[0-9]*)");
		while (!y.equals("d")) {
			super.calcinput(mem, raw, y);
			y = inp.nextLine();
		}
		inp.close();
	}
	public float singleCalculate(String operator, float num2) {
		switch(operator) {
		case "^":
			return (float)Math.pow(this.value, num2);
		default:
			return super.singleCalculate(operator, num2);			
		}
		
	}
}
public class calc {

	public static void main(String[] args) {
		ScientificCalculator calc = new ScientificCalculator();
		calc.beginCalculate();
	}

}
