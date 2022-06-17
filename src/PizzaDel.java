import java.util.Scanner;
import java.util.*; 
class PizzaOrder{
	String pizzaType;
	int number;
	double price;
	double totalPrice;
	PizzaOrder(String name, int number, double price){
		this.pizzaType = name;
		this.number = number;
		this.price = price;
		this.totalPrice = number*price;
	}
	public String getName() {
		return this.pizzaType;
	}
	public int getNumber() {
		return this.number;
	}
	public void add(int adds) {
		this.number += adds;
		this.totalPrice += adds*this.price;
	}
	public double totalPrice() {
		return this.totalPrice;
	}
	public double singlePrice() {
		return this.price;
	}
}

class PizzaApp{
	HashMap<String, ArrayList<PizzaOrder>> pizzaApp = new HashMap<String, ArrayList<PizzaOrder>>();
	String[] menu = {"Hawaiian", "Supreme", "Vegetarian"};
	double[] price = {12.5,15.2,10.1};
	String kr;
	String user;
	public void start() {
		System.out.println("Who is the first user?");
		this.kr = "";
		String name;
		Scanner inp = new Scanner(System.in);
		name = inp.nextLine();
		pizzaApp.put(name,new ArrayList<PizzaOrder>());
		
		while(!this.kr.equals("q")) {
			System.out.println("Current User: " + name);
			this.printMenu();
			System.out.println("To add a Pizza, enter its associated number");
			System.out.println("Press q to quit, c to checkout, r to reset current user, n to change user,"
					+ " v to view current order");
			kr = inp.nextLine();
			switch(kr) {
				case "1":
					this.addOrder(0, name, inp);
					break;
				case "2":
					this.addOrder(1, name, inp);
					break;
				case "3":
					this.addOrder(2, name, inp);
					break;
				case "n":
					System.out.println("Who is the next user?");
					name = inp.nextLine();
					if (this.pizzaApp.keySet().contains(name)){
						System.out.println("Reverting to user: " + name);
						break;
					}
					pizzaApp.put(name,new ArrayList<PizzaOrder>());
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
		System.out.println("Menu: ");
		for (int i = 0; i< this.menu.length; i++) {
			System.out.println((i+1) + ": " + menu[i] + " $" + price[i]);
		}
	}
	public void addOrder(int id, String name, Scanner addOrder) {
		System.out.println("How many would you like to add to the order?");
		boolean repeat = true;
		int num = 0;
		do {
			try {
				num = Integer.parseInt(addOrder.nextLine());
				repeat = false;
			} catch (Exception e) {
				System.out.println("Input not recognized, please enter an integer");
				repeat = true;
			} finally {};
		}while(repeat);
		if (num == 0) {
			return;
		}
		for (PizzaOrder i: pizzaApp.get(name)) {
			if (i.getName() == this.menu[id]) {
				i.add(num);
				return;
			}
		}
		pizzaApp.get(name).add(new PizzaOrder(this.menu[id], num, this.price[id]));
	}
	public void resetOrder() {
			this.pizzaApp.get(name).clear();
	}
	public void printOrder() {
		double sum = 0;
		for (String j: pizzaApp.keySet()) {
			System.out.println("\n" + j + " ordered:" );
			if (this.pizzaApp.get(j).size() == 0) {
				System.out.println("Nothing");
			}
			for (int i = 0; i< this.pizzaApp.get(j).size(); i++) {
					System.out.println(this.pizzaApp.get(j).get(i).getNumber()
							+ " " + this.pizzaApp.get(j).get(i).getName() + ": $" 
							+ this.pizzaApp.get(j).get(i).singlePrice() + "*" 
							+ this.pizzaApp.get(j).get(i).getNumber()+ " = $" 
							+ this.pizzaApp.get(j).get(i).totalPrice());
					sum += this.pizzaApp.get(j).get(i).totalPrice();
			}
		}
		System.out.println("Total Price: $"+ sum+"\n");
	}
	public void checkout(){
		this.printOrder();
		System.out.println("Thank you for shopping");
		this.kr = "q";
	}
}

public class PizzaDel {
	public static void main(String[] args) {
		PizzaApp pa = new PizzaApp();
		pa.start();
	}

}
