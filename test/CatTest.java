package test;

import org.junit.Test;
import src.Cat;
import src.Customer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class CatTest {

    @Test
    public void stringTest() {

        Cat testCat = new Cat(12, 200.00f, "test name");
        assertEquals("ID 12. test name: $200.00 / day", testCat.toString());

    }

    @Test
    public void setCustomer() {

        Cat      testCat      = new Cat(0, 1, "Test Dummy");
        Customer fakeCustomer = mock(Customer.class);
        testCat.setRentingCustomer(fakeCustomer);
        assertEquals(fakeCustomer, testCat.getRentingCustomer());

    }

    @Test
    public void testSetRentedTrue() {

        Cat testCat = new Cat(0, 1, "Test Dummy");
        testCat.setRented(true);
        assertTrue(testCat.isRented());

    }

    @Test
    public void testSetRentedFalse() {

        Cat testCat = new Cat(0, 1, "Test Dummy");
        testCat.setRented(false);
        assertFalse(testCat.isRented());

    }

    @Test
    public void rentCatTest() {

        Cat      testCat      = new Cat(0, 1, "Test Dummy");
        Customer fakeCustomer = mock(Customer.class);
        testCat.rentCat(fakeCustomer);
        assertTrue(testCat.isRented());

    }

    @Test
    public void returnCatTest() {

        Cat testCat = new Cat(0, 1, "Test Dummy");
        Customer fakeCustomer = mock(Customer.class);
        testCat.rentCat(fakeCustomer);
        testCat.returnCat();
        assertFalse(testCat.isRented());

    }

}	
