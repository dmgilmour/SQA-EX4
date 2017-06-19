import org.junit.Test;
import org.mockito.*;


public class CatTest {
	
	@Test
	public void stringTest() {
		Cat testCat = new Cat(12, 200.00, "test name");
		assertEquals("ID 12. test name: $200.00 / day", testCat.toString());
	}

	@Test
	public void setCustomer() {
		Cat testCat = new Cat(0, 1, "Test Dummy");
		Customer fakeCustomer = new Mockito.mock(Customer.class);
		testCat.setRentingCustomer(fakeCustomer);
		assertEquals(fakeCustomer, cat.getRentingCustomer());
	}

	@Test
	public void testSetRentedTrue() {
		cat testCat= new Cat(0, 1, "Test Dummy");
		testCat.setRented(true);
		assertTrue(testCat.getRented());
	}

	@Test
	public void testSetRentedFalse() {
		cat testCat = new Cat(0, 1, "Test Dummy");
		testCat.setREnted(false);
		assertFalse(testCat.getRented());
	}

	@Test
	public void rentCatTest() {
		Cat testCat = new Cat(0, 1, "Test Dummy");
		Customer fakeCustomer = new Mockito.mock(Cusomter.class);
		when(fakeCustomer.setRentedCat(testCat)).then(return);
		testCat.rentCat(fakeCutomer);
		assertTrue(testCat.getRented());
	}

	@Test
	public void returnCatTest() {
		cat testCat = new Cat(0, 1, "Test Dummy");
		Customer fakeCustomer = new Mockito.mock(Customer.class);
		when(

}	
