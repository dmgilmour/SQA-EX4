import java.util.*;

public class RentAClass {

	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		

	}

	public int promptDesiredCat(ArrayList<Cat> cats) {
		int desiredCat = 0;
		while (desiredCat == 0) {
			System.out.print("Rent which cat? > ");
			try {
				desiredCat = Integer.parseInt(input.next());
				for (givenCat : cats) {
					if (desiredCat == givenCat.id) {
						if (!givenCat.id.rented) {
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

	public int promptDesiredCat(ArrayList<Cat> cats) {
		int desiredCat = 0;
		while (desiredCat == 0) {
			System.out.print("Rent which cat? > ");
			try {
				desiredCat = Integer.parseInt(input.next());
				for (givenCat : cats) {
					if (desiredCat == givenCat.id) {
						if (!givenCat.id.rented) {
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

	public void printAvailableCats(ArrayList<Cat> cats) {
		System.out.println("Cats for Rent");
		for (givenCat : cats) {
			System.out.println(givenCat.toString());
		}
	}

		
}
