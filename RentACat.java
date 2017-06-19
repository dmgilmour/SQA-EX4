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
						System.out.print(getAvailableCatsString(cats));
						break;
					case 2:
						chosenCustomer = promptCustomer(customers, input);
						chosenCat = promptRentCat(cats, input);
						rentCats(chosenCat, chosenCustomer);
						chosenCat.rentCat(chosenCustomer);
						break;
					case 3:
						chosenCat = promptReturnCat(cats, input);
						chosenCat.returnCat();
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

	public static Cat promptRentCat(ArrayList<Cat> cats, Scanner input) {

		return (Cat) promptObjectLoop(cats,
				option -> true,
				input,
				"Rent which cat? > ",
				"Invalid cat id",
				"Invalid cat id");

	}

	public static Cat promptReturnCat(ArrayList<Cat> cats, Scanner input) {

		return (Cat) promptObjectLoop(cats,
				option -> ((Cat) option).isRented(),
				input,
				"Return which cat? > ",
				"That cat hasn't been rented!",
				"Invalid cat id");

	}

	public static Customer promptCustomer(ArrayList<Customer> customers, Scanner input) {

		return (Customer) promptObjectLoop(customers,
				option -> true,
				input,
				"Customer ID > ",
				"Invalid Customer ID",
				"Invalid Customer ID");

	}

	public static String getAvailableCatsString(ArrayList<Cat> cats) {

		String output = "Cats for Rent\n";
		for (Cat givenCat : cats) {
			if (!givenCat.isRented()) {
				output = output + givenCat.toString() + "\n";
			}
		}
		return output;

	}

	public static Identifiable promptObjectLoop(Collection<? extends Identifiable> objects, ValidOptionDecider decider, Scanner input, String prompt, String invalid, String error) {

		if (objects == null) {
			throw new IllegalArgumentException("Objects must be a valid collection");
		}
		if (decider == null) {
			throw new IllegalArgumentException("Decider must not be null");
		}
		if (input == null) {
			throw new IllegalArgumentException("Input must not be null");
		}
		if (prompt == null) {
			prompt = "Enter a value";
		}
		if (invalid == null) {
			invalid = "Invalid value";
		}
		if (error == null) {
			error = "Invalid value";
		}
		int desired = -1;
		while (desired == -1) {
			System.out.println(prompt);
			try {
				desired = Integer.parseInt(input.next());
				for (Identifiable item : objects) {
					if (desired == item.getId()) {
						if (decider.isValidOption(item)) {
							return item;
						} else {
							System.out.println(invalid);
						}
					}
				}
				System.out.println(error);
			} catch (NumberFormatException e) {
				System.out.println(error);
			}
		}

		throw new IllegalStateException("Should never get outside the prompt loop!");

	}

	public interface ValidOptionDecider {

		boolean isValidOption(Identifiable option);

	}

}
