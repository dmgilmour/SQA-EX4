import java.util.*;

public class Cat {

	private static int id;
	private static float cost;
	private static String name;
	private static boolean rented;

	public Cat(int id, float cost, String name) {
	
		this.id = id;
		this.cost = cost;
		this.name = name;
		rented = false;

	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Cat.id = id;
	}

	public static float getCost() {
		return cost;
	}

	public static void setCost(float cost) {
		Cat.cost = cost;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Cat.name = name;
	}

	public static boolean isRented() {
		return rented;
	}

	public static void setRented(boolean rented) {
		Cat.rented = rented;
	}
}
