import java.util.*;
import java.lang.System;

class Card implements Comparable<Card>{
	private String name;
	private int id;
	Card(String name, int id){
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public int getID() {
		return this.id;
	}
	public int compareTo(Card comparison) {
		return this.name.compareTo(comparison.getName());
		
	}
}

class BankApp{
	List<Card> customerList;
	BankApp(List<Card> cardInit){
		this.customerList = cardInit;		
	}
	public void addCard(Card newUser) {
		customerList.add(newUser);
	}
	public void addCard(String newUser, int newID) {
		this.addCard(new Card(newUser,newID));		
	}
	public Card atIndex(int index) {
		return this.customerList.get(index);
	}
	public void deleteCards(String name) {
		for(Card i: this.customerList) {
			if (name.equals(i.getName())){
				this.customerList.remove(i);
			}
		}
	}
	public void deleteACard(int id) {		
		for(Card i: this.customerList) {
			if (id == i.getID()){
				this.customerList.remove(i);
				return;
			}
		}
	}
}
class TestMethods{
	protected static void TestInit(BankApp test) {
		String testName = "";
		for (int i = 0; i < 10000; i++) {
			test.addCard(testName, i);
			testName += "a";
		}
	}
	protected static void TestInsertDelete(BankApp test) {
		long tc = System.nanoTime();
		String testName = "";
		for (int i = 0; i < 10000; i++) {
			test.addCard(testName, i);
			testName += "a";
		}
		System.out.println("\tInsert Test: " + (System.nanoTime()-tc) + " ns");
		tc = System.nanoTime();
		for(int i = 0; i<10000;i++) {
			test.deleteACard(i); //From front
		}
		System.out.println("\tDelete Test: " + (System.nanoTime()-tc) + " ns");
	}
	protected static void TestSearch(BankApp test) {
		long tc = System.nanoTime();
		for (int i = 0; i<10000; i++) {
			test.atIndex(i);
		}
		System.out.println("\tSearch Test: " + (System.nanoTime()-tc) + " ns");
	}
	public static void CompTest(BankApp test) {
		TestMethods.TestInit(test);
		TestMethods.TestInsertDelete(test);
		TestMethods.TestSearch(test);
	}
}

public class collectionAss {
	public static void main(String[] args) {
		BankApp testApp = new BankApp(new ArrayList<Card>());
		System.out.println("Test ArrayList ");
		TestMethods.CompTest(testApp);

		BankApp testApp2 = new BankApp(new LinkedList<Card>());
		System.out.println("Test LinkedList ");
		TestMethods.CompTest(testApp2);
		
		BankApp testApp3 = new BankApp(new Stack<Card>());
		System.out.println("Test Stack");
		TestMethods.CompTest(testApp3);
		
		BankApp testApp4 = new BankApp(new Vector<Card>());
		System.out.println("Test Vector");
		TestMethods.CompTest(testApp4);
	}
}
