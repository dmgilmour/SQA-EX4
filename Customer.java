

public class Customer {

	private static String name;
	private static float money;
	private static Cat rentedCat;

	public Customer(String name, float money) {
		this.name = name;
		this.money = money;
		rentedCat = null;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Customer.name = name;
	}

	public static float getMoney() {
		return money;
	}

	public static void setMoney(float money) {
		Customer.money = money;
	}

	public static Cat getRentedCat() {
		return rentedCat;
	}

	public static void setRentedCat(Cat rentedCat) {
		Customer.rentedCat = rentedCat;
	}
}
