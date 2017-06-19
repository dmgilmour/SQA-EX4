package src;

public class Customer
        implements Identifiable {

    private final int    id;
    private       String name;
    private       Cat    rentedCat;

    public Customer(String name, int id) {

        this.id = id;
        this.name = name;
        rentedCat = null;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

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

}
