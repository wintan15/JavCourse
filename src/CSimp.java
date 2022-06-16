import java.lang.CharSequence;
public class CSimp implements CharSequence {
	public String[] sarr;
	public int length() {
		int sum = 0;
		for (String i: sarr) {
			sum+=i.length();
		}
		return sum;
	}
	public char charAt(int index) {
		int saind = 0;
		for (String i: this.sarr) {
			index -= i.length();
			if (index<0){
				break;
			}
			saind += 1;
		}
		index += this.sarr[saind].length();
		return this.sarr[saind].charAt(index);
	}
	public CharSequence subSequence(int start,
            int end) {
		return this.toString().subSequence(start, end);
		
	}
	public String toString() {
		String i = "";
		for (String j : this.sarr) {
			i+=j;			
		}
		return i;
	}
	protected void reverse() {
		String[] newArr = new String[this.sarr.length];
		for (int i = 0; i<this.sarr.length; i++) {
			newArr[i] = "";
			for (int j = 0; j<this.sarr[this.sarr.length-i-1].length(); j++) {
				newArr[i] += this.sarr[this.sarr.length-i-1].
						charAt(this.sarr[this.sarr.length-i-1].length()-j-1);
			}
		}
		this.sarr = newArr;
	}
	public static void main(String[] args) {
		CSimp test= new CSimp();
		test.sarr = new String[2];
		test.sarr[0] = "this";
		test.sarr[1] = "test";
		System.out.println(test.toString());
		test.reverse();
		System.out.println(test.toString());
		// TODO Auto-generated method stub

	}

}
