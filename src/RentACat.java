package src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class RentACat {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1, 150, "John"));
        cats.add(new Cat(2, 200, "Jane"));

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Ira Glass", 1));
        customers.add(new Customer("Lackshmi Singh", 2));
        customers.add(new Customer("Ari Shapiro", 3));

        int      chosenOption = 0;
        Cat      chosenCat;
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
                                      input,
                                      option -> !((Cat) option).isRented(),
                                      "Rent which cat? > ",
                                      "That cat has already been rented",
                                      "Invalid cat id");

    }

    public static Cat promptReturnCat(ArrayList<Cat> cats, Scanner input) {

        return (Cat) promptObjectLoop(cats,
                                      input,
                                      option -> ((Cat) option).isRented(),
                                      "Return which cat? > ",
                                      "That cat hasn't been rented!",
                                      "Invalid cat id");

    }

    public static Customer promptCustomer(ArrayList<Customer> customers, Scanner input) {

        return (Customer) promptObjectLoop(customers,
                                           input,
                                           option -> true,
                                           "Enter customer ID > ",
                                           "Invalid customer ID",
                                           "Invalid customer ID");

    }

    public static String getAvailableCatsString(ArrayList<Cat> cats) {

        String output = "Cats for Rent:\n";
        for (Cat givenCat : cats) {
            if (!givenCat.isRented()) {
                output = output + givenCat.toString() + "\n";
            }
        }
        return output;

    }

    public static Identifiable promptObjectLoop(Collection<? extends Identifiable> objects, Scanner input, ValidOptionDecider decider, String prompt, String invalid, String error) {

        if (objects == null) {
            throw new IllegalArgumentException("Objects must be a valid collection");
        }
        if (objects.size() < 1) {
            throw new IllegalArgumentException("Objects must not be empty");
        }
        if (decider == null) {
            throw new IllegalArgumentException("Decider must not be null");
        }
        if (input == null) {
            throw new IllegalArgumentException("Scanner must not be null");
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
        int desired;
        while (true) {

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

    }

    public interface ValidOptionDecider {

        boolean isValidOption(Identifiable option);

    }

}
