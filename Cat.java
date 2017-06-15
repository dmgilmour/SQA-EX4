import java.util.*;

public class Cat {

	private int id;
	private float cost;
	private String name;
	private boolean rented;
	private Customer rentingCustomer;

	public Cat(int id, float cost, String name) {
	
		this.id = id;
		this.cost = cost;
		this.name = name;
		rented = false;
		rentingCustomer = null;

	}

	public String toString() {

		return "ID " + id + ". " + name + ": $" + String.format("%.2f", cost) + " / day";

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		if (cost < 0) {
			throw new IllegalArgumentException("Cost must be positive");
		}
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public void setRentingCustomer(Customer rentingCustomer) {
		this.rentingCustomer = rentingCustomer;
	}

	public Customer getRentingCustomer() {
		return rentingCustomer;
	}
}
