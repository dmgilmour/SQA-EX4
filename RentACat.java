import java.util.*;

public class RentAClass {

	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Cat> cats = new ArrayList<Cat>();
		cats.add(new Cat(1, 150, "John"));
		cats.add(new Cat(2, 200, "Jane"));

		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(111, "Ira Glass"));
		customers.add(new Customer(123, "Lackshmi Singh"));
		customers.add(new Customer(234, "Ari Shapiro"));
	

		int chosenOption = 0;
		Cat chosenCat;
		Customer chosenCustomer;
		while (chosenOption != 4) {
			chosenOption = promptOption();
			switch (chosenOption) {
				case 1:
					printAvailableCats();
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
				case 4;
					System.out.println("Closing up shop for the day");
			}
		}
	}

	public static int promptRentCat(ArrayList<Cat> cats) {
		int desiredCat = 0;
		while (desiredCat == 0) {
			System.out.print("Rent which cat? > ");
			try {
				desiredCat = Integer.parseInt(input.next());
				for (givenCat : cats) {
					if (desiredCat == givenCat.getId()) {
						if (!givenCat.getRented()) {
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
	}

	public int promptReturnCat(ArrayList<Cat> cats) {
		int desiredCat = 0;
		while (desiredCat == 0) {
			System.out.print("Return which cat? > ");
			try {
				desiredCat = Integer.parseInt(input.next());
				for (givenCat : cats) {
					if (desiredCat == givenCat.getId()) {
						if (givenCat.rented) {
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
	}

	public void printAvailableCats(ArrayList<Cat> cats) {
		System.out.println("Cats for Rent");
		for (givenCat : cats) {
			if (!givenCat.getRented()) {
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
