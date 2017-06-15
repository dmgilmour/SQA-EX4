public class Customer implements Identifiable {

	private int id;
	private String name;
	private float money;
	private Cat rentedCat;

	public Customer(String name, float money) {
		this.name = name;
		this.money = money;
		rentedCat = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Cat getRentedCat() {
		return rentedCat;
	}

	public void setRentedCat(Cat rentedCat) {
		this.rentedCat = rentedCat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
