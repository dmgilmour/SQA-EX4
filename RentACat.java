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
			try {
				chosenOption = Integer.parseInt(input.next());
				switch (chosenOption) {
					case 1:
						printAvailableCats(cats);
						break;
					case 2:
						chosenCustomer = promptCustomer(customers);
						chosenCat = promptRentCat(cats);
						rentCats(chosenCat, chosenCustomer);
						break;
					case 3:
						chosenCat = promptReturnCat(cats);
						returnCats(chosenCat);
						break;
					case 4:
						System.out.println("Closing up shop for the day");
						break;
					default:
						System.out.println("Invalid option");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid option");

			}
		}
	}

	private static void returnCats(Cat chosenCat) {
		Customer chosenCustomer = chosenCat.getRentingCustomer();
		System.out.println(chosenCustomer.getName() + " paid $" + chosenCat.getCost());
		chosenCat.setRentingCustomer(null);
		chosenCat.setRented(false);
		chosenCustomer.setRentedCat(null);
		System.out.println("Welcome back, " + chosenCat.getName() + "!");
	}

	private static void rentCats(Cat chosenCat, Customer chosenCustomer) {
		chosenCat.setRented(true);
		chosenCustomer.setRentedCat(chosenCat);
		chosenCat.setRentingCustomer(chosenCustomer);
		System.out.println(chosenCat.getName() + " has been rented to Customer " + chosenCustomer.getName());
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

		throw new IllegalStateException("Should not get outside prompt loop");

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

		throw new IllegalStateException("Should not get outside prompt loop");

	}

	public static void printAvailableCats(ArrayList<Cat> cats) {
		System.out.println("Cats for Rent");
		for (Cat givenCat : cats) {
			if (!givenCat.isRented()) {
				System.out.println(givenCat.toString());
			}
		}
	}

	public static Customer promptCustomer(ArrayList<Customer> customers) {

		int desiredCustomer = 0;
		while (desiredCustomer == 0) {
			System.out.println("Customer ID > ");
			try {
				desiredCustomer = Integer.parseInt(input.next());
				for (Customer givenCustomer : customers) {
					if (desiredCustomer == givenCustomer.getId()) {
						return givenCustomer;
					}
				}
				System.out.println("Invalid Customer ID");
			} catch (NumberFormatException e) {
				System.out.println("Invalid Customer ID");
			}
		}

		throw new IllegalStateException("Should not get outside prompt loop");

	}

}
