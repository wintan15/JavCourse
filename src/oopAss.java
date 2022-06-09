import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

class Student{
	int mark;
	String name;
	public Student(int mark, String name){
		this.mark = mark;
		this.name = name;
	}
	public String gradeReport(){
		if (this.mark>70) {
			System.out.println(this.name + " achieved an A");
			return "A";
		} else if (this.mark>50) {
			System.out.println(this.name + " has Passed");
			return "Pass";			
		} else {
			System.out.println(this.name + " has failed");
			return "Fail";
		}
	}
}
/*
class Calculator{
	int value = 0;
	public void beginCalculate() {
		System.out.println("Supported operators: +,-,*,/ \n"
				+ "Initial Stored value is " + this.value +"\n"
				+ "Operator acts on stored value if line begins with it \n" 
				+ "Processes only first operation on each line \n"
				+ "Enter 'd' to quit.");
		Scanner inp = new Scanner(System.in);
		String y = inp.nextLine();
		Pattern mem = Pattern.compile("([+\\-/\\*]) *([0-9]+.?[0-9]+)");
	}
	int singleCalculate(String operator, float num2) {
		return num2;
	}
	
}*/

class PizzaApp{
	int[] order = new int[3];
	String[] menu = {"(1) Hawaiian", "(2) Supreme", "(3) Vegetarian"};
	int[] price = {12,15,10};
	String kr;
	public void start() {
		this.kr = "";
		Scanner inp = new Scanner(System.in);
		this.printMenu();
		while(!this.kr.equals("q")) {
			System.out.println("To add a Pizza, only enter its associated number");
			System.out.println("Press q to quit, c to checkout, r to reset, v to view current order");
			kr = inp.nextLine();
			switch(kr) {
			case "1":
				this.addOrder(1);
				break;
			case "2":
				this.addOrder(2);
				break;
			case "3":
				this.addOrder(3);
				break;
			case "q":
				break;
			case "c":
				this.checkout();
				break;
			case "r": 
				this.resetOrder();
				break;
			case "v":
				this.printOrder();
				break;
			default:
				System.out.println("Command not accepted. Please follow instructions.");
			}
		}
		System.out.println("Goodbye");
		
	}
	public void printMenu() {
		System.out.println("Current menu");
		for (int i = 0; i< this.order.length; i++) {
			System.out.println(menu[i] + " $" + price[i]);
		}
	}
	public void resetOrder() {
		for (int i = 0; i< this.order.length; i++) {
			this.order[i] = 0;
		}
	}
	public void printOrder() {

		System.out.println("Number of Pizzas");
		for (int i = 0; i< this.order.length; i++) {
			System.out.println(menu[i].substring(4) + ": " + order[i]);
		}
		System.out.println("Total Price: $"+ this.totalPrice());
	}
	public void addOrder(int index) {
		this.order[index-1]+=1;		
	}
	public int totalPrice() {
		int sum = 0;
		for (int i = 0; i< this.order.length; i++) {
			sum += price[i]*order[i];
		}
		return sum;
	}
	public void checkout(){
		System.out.println("Please pay: " + this.totalPrice());
		this.resetOrder();
		this.kr = "q";
	}
}

public class oopAss {
	public static void main(String[] args) {
		/*
		Scanner inp = new Scanner(System.in);
		System.out.println("How many students?");
		int num = inp.nextInt();
		inp.nextLine();
		Student[] classroom = new Student[num];
		int age;
		String name;
		for( int i = 0; i<num; i++) {
			System.out.println("Enter name followed by marks");
			name = inp.nextLine();
			age = inp.nextInt();
			classroom[i] = new Student(age, name);
			inp.nextLine(); //Flush to end
		}

		System.out.println("Printing Class Results");
		for(Student i: classroom) {
			i.gradeReport();
		}
		inp.close();
		*/
		PizzaApp pa = new PizzaApp();
		pa.start();
	}

}
