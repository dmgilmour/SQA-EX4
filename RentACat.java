import java.util.*;

public class RentAClass {

	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
	

	int chosenOption = 0;
	Cat chosenCat;
	while (chosenOption != 4) {
		chosenOption = promptOption();
		switch (chosenOption) {
			case 1:
				printAvailableCats();
				break;
			case 2:
				chosenCat = promptDesiredCat(cats);
				chosenCustomer = promptCustomer(customers);
				rentCats(chosenCat, chosenCustomer);
				break;
			case 3:
		

	}

	public int promptRentCat(ArrayList<Cat> cats) {
		int desiredCat = 0;
		while (desiredCat == 0) {
			System.out.print("Rent which cat? > ");
			try {
				desiredCat = Integer.parseInt(input.next());
				for (givenCat : cats) {
					if (desiredCat == givenCat.id) {
						if (!givenCat.rented) {
							return desiredCat;
						} else {
							System.out.println("Sorry, " + givenCat.name + " is not here!");
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
					if (desiredCat == givenCat.id) {
						if (givenCat.rented) {
							return desiredCat;
						} else {
							System.out.println(givenCat.name + " hasn't been rented!");
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

		
}
