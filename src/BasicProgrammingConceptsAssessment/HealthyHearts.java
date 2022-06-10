import java.util.Scanner;
import java.lang.Math;

public class HealthyHearts {

	public static void main(String[] args) {
		System.out.print("What is your age? ");
		Scanner inp = new Scanner(System.in);
		int age = inp.nextInt();
		//Maximum heart rate to avoid calculation repeats
		int maximum = 220-age;
		System.out.println("Your maximum heart rate should be " + maximum +
				" beats per minute");
		System.out.println("Your target HR Zone is " + Math.round(0.5*maximum) + " - " + 
				Math.round(0.85*maximum)+ " beats per minute");
		inp.close();
	}

}
