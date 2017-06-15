import java.util.*;

public class RentACat {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Cat> cats = new ArrayList<>();
		cats.add(new Cat(1, 150, "John"));
		cats.add(new Cat(2, 200, "Jane"));

		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Ira Glass", 111));
		customers.add(new Customer("Lackshmi Singh", 123));
		customers.add(new Customer("Ari Shapiro", 234));
	

		int chosenOption = 0;
		Cat chosenCat;
		Customer chosenCustomer;
		while (chosenOption != 4) {
			chosenOption = promptOption();
			switch (chosenOption) {
				case 1:
					printAvailableCats(cats);
					break;
				case 2:
					chosenCat = promptRentCat(cats);
					chosenCustomer = promptCustomer(customers);
					rentCats(chosenCat, chosenCustomer);
					break;
				case 3:
					chosenCat = promptReturnCat(cats);
					chosenCustomer = promptCustomer(customers);
					returnCats(chosenCat, chosenCustomer);
					break;
				case 4:
					System.out.println("Closing up shop for the day");
			}
		}
	}

	private static void returnCats(Cat chosenCat, Customer chosenCustomer) {

	}

	private static void rentCats(Cat chosenCat, Customer chosenCustomer) {

	}

	private static Customer promptCustomer(ArrayList<Customer> customers) {
		return null;
	}

	private static int promptOption() {
		return 0;
	}

	public static Cat promptRentCat(ArrayList<Cat> cats) {
		int desiredCat = 0;
		while (desiredCat == 0) {
			System.out.print("Rent which cat? > ");
			try {
				desiredCat = Integer.parseInt(input.next());
				for (Cat givenCat : cats) {
					if (desiredCat == givenCat.getId()) {
						if (!givenCat.isRented()) {
							return givenCat;
						} else {
							System.out.println("Sorry, " + givenCat.getName() + " is not here!");
						}
					}
				}
				System.out.println("Invalid Cat ID");
			} catch (NumberFormatException e) {
				System.out.println("Invalid Cat ID");
			}
		}
		return null;
	}

	public static Cat promptReturnCat(ArrayList<Cat> cats) {
		int desiredCat = 0;
		while (desiredCat == 0) {
			System.out.print("Return which cat? > ");
			try {
				desiredCat = Integer.parseInt(input.next());
				for (Cat givenCat : cats) {
					if (desiredCat == givenCat.getId()) {
						if (givenCat.isRented()) {
							return givenCat;
						} else {
							System.out.println(givenCat.getName() + " hasn't been rented!");
						}
					}
				}
				System.out.println("Invalid Cat ID");
			} catch (NumberFormatException e) {
				System.out.println("Invalid Cat ID");
			}
		}

		return null;

	}

	public static void printAvailableCats(ArrayList<Cat> cats) {
		System.out.println("Cats for Rent");
		for (Cat givenCat : cats) {
			if (!givenCat.isRented()) {
				System.out.println(givenCat.toString());
			}
		}
	}

	public Customer promptCustomer(ArrayList<Customer> customers) {
		int desiredCustomer = 0;
		while (customer == 0) {
			System.out.println("Customer ID > ");
			try {
				desiredCustomer = Integer.parseInt(input.next());
				for (givenCustomer : customers) {
					if (desiredCustomer == givenCustomer.getId()) {
						return givenCustomer;
					}
				}
				System.out.println("Invalid Customer ID");
			} catch (NumberFormatException e) {
				System.out.println("Invalid Customer ID");
			}
		}
	}
			

		
}
