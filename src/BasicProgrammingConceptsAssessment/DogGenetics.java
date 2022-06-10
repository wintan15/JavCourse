import java.lang.Math;
import java.util.Scanner;

public class DogGenetics {
	
	public static void main(String[] args) {
		System.out.print("What is your dog's name? ");
		Scanner inp = new Scanner(System.in);
		String name = inp.nextLine();
		System.out.println("Well then, I have this highly reliable report on " + 
				name + "'s prestigious background right here.");
		System.out.println("\n\n"+ name + " is:\n\n");
		//Breed names
		String[] breeds = {
				"St. Bernard", "Chihuahua", 
				"Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"
		};
		//Two arrays first to allow for true randomness from math.random (unrestrained)
		double[] percentages = new double[5];
		long[] finalperc = new long[5];
		double current_sum = 0;
		long final_sum = 0;
		for (int i = 0; i<5; i++) {
			percentages[i] = Math.random();
			current_sum += percentages[i];
		}
		//Normalize the percentages (except the last due to rounding errors)
		for (int i = 0; i<4; i++) {
			finalperc[i] = Math.round(percentages[i]/current_sum*100);
			final_sum += finalperc[i];
		}
		finalperc[4] = 100-final_sum;
		for (int i = 0; i<5; i++) {
			System.out.println(finalperc[i]+"% "+ breeds[i]);
		}		
		System.out.println("\n\nWow, that's QUITE the dog!");
		inp.close();
	}

}
