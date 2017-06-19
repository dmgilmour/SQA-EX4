package src;

public class Cat
        implements Identifiable {

    private int      id;
    private float    cost;
    private String   name;
    private boolean  rented;
    private Customer rentingCustomer;

    public Cat(int id, float cost, String name) {

        this.id = id;
        this.cost = cost;
        this.name = name;
        rented = false;
        rentingCustomer = null;

    }

    public void rentCat(Customer rentingCustomer) {

        setRentingCustomer(rentingCustomer);
        setRented(true);
        rentingCustomer.setRentedCat(this);
        System.out.println(getName() + " has been rented to " + rentingCustomer.getName());

    }

    public void returnCat() {

        if (!rented || rentingCustomer == null) {
            throw new IllegalStateException("Cannot return a cat that is not rented.");
        }
        String output = String.format("%s returned %s and paid $%.2f\nWelcome back, %s!", getRentingCustomer().getName(), getName(), getCost(), getName());
        rentingCustomer.setRentedCat(null);
        setRentingCustomer(null);
        setRented(false);
        System.out.println(output);

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

    public Customer getRentingCustomer() {

        return rentingCustomer;

    }

    public void setRentingCustomer(Customer rentingCustomer) {

        this.rentingCustomer = rentingCustomer;

    }

}
