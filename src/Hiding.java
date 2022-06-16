class Hidden{
	public void methodOne() {
		System.out.println("Parent 1");
	}
	public static void methodTwo() {
		System.out.println("Parent 2");
	}
	public static void methodThree() {
		System.out.println("Parent 3");
	}
	public void methodFour() {
		System.out.println("Parent 4");
	}
}

public class Hiding extends Hidden {
	public static void methodOne() {
		System.out.println("Child 1");
	}
	public void methodTwo() {

		System.out.println("Child 2");
	}
	public static void methodThree() {
		System.out.println("Child 3");
	}
	public void methodFour() {
		System.out.println("Child 4");
	}
	public static void main(String[] args) {
		Hidden parent = new Hiding();
		parent.methodFour();
		parent.methodThree();
		parent.methodTwo();
		parent.methodOne();
		
		Hiding child = new Hiding();
		child.methodFour();
		child.methodThree();
		//child.methodTwo(); //COmpile error
		//child.methodOne(); //compile error
	}
}
