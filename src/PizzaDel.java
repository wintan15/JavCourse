import java.util.Scanner;
class Pizza{
	public void st
}

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
		inp.close();
		
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
			if (order[i] >0) {
				System.out.println(order[i] + " " + menu[i].substring(4));
			}
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
		System.out.println("Please pay: $" + this.totalPrice());
		this.resetOrder();
		this.kr = "q";
	}
}

public class PizzaDel {
	public static void main(String[] args) {
		PizzaApp pa = new PizzaApp();
		pa.start();
	}

}
