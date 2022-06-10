
public class SummativeSums {
	public static int arrSum(int[] arr) {
		int sum = 0;
		//Get array sums
		for(int i: arr) {
			sum += i;
		}
		return sum;
	}
	public static void main(String[] args) {
		int[][] inputs = {{ 1, 90, -33, -55, 67, -16, 28, -55, 15 },
		{ 999, -60, -77, 14, 160, 301 },
		{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
		140, 150, 160, 170, 180, 190, 200, -99 }};
		for (int i = 0; i<inputs.length; i++) {
			System.out.println("#"+(i+1)+" Array Sum: "+arrSum(inputs[i]));
		}
	}

}
