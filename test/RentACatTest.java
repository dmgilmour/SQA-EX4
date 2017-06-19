package test;

import org.junit.Before;
import org.junit.Test;
import src.Cat;
import src.Identifiable;
import src.RentACat;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Eric on 6/15/2017.
 */
public class RentACatTest {

    private ArrayList<Cat> cats;

    @Before
    public void init() {

        cats = new ArrayList<>();

        // More likable cats cost more. :P
        cats.add(new Cat(1, 700, "Mosse"));
        cats.add(new Cat(2, 500, "Tan"));
        cats.add(new Cat(3, 550, "Farnan"));
        cats.add(new Cat(4, -10000, "Laboon")); // We've gotta pay people to take this one off our hands.
        cats.add(new Cat(5, 450, "Garrison"));

    }

    @Test
    public void testGetAvailableCatsNone() {

        cats = new ArrayList<>();
        String out      = RentACat.getAvailableCatsString(cats);
        String expected = "Cats for Rent:\n";
        assertTrue(expected.equals(out));


    }

    @Test
    public void testGetAvailableCatsNoneAvailable() {

        for (Cat c : cats) {
            c.setRented(true);
        }
        String out      = RentACat.getAvailableCatsString(cats);
        String expected = "Cats for Rent:\n";
        assertTrue(expected.equals(out));


    }

    @Test
    public void testGetAvailableCatsSomeAvailable() {

        for (int i = 0; i < cats.size(); i += 2) {
            cats.get(i)
                .setRented(true);
        }
        String out      = RentACat.getAvailableCatsString(cats);
        String expected = "Cats for Rent:\n" + "ID 2. Tan: $500.00 / day\n" + "ID 4. Laboon: $-10000.00 / day\n";
        assertTrue(expected.equals(out));


    }

    @Test
    public void testGetAvailableCatsAllAvailable() {

        String out      = RentACat.getAvailableCatsString(cats);
        String expected = "Cats for Rent:\n" + "ID 1. Mosse: $700.00 / day\n" + "ID 2. Tan: $500.00 / day\n" + "ID 3. Farnan: $550.00 / day\n" + "ID 4. Laboon: $-10000.00 / day\n" + "ID 5. Garrison: $450.00 / day\n";
        assertTrue(expected.equals(out));

    }

//    Test will not work because Scanner is final, and as such, cannot be doubled.
//    @Test
//    public void testPromptLoop() {
//
//        Scanner scanner = mock(Scanner.class);
//        when(scanner.nextInt()).thenThrow(new NumberFormatException())
//                               .thenReturn(9)
//                               .thenReturn(4);
//        RentACat.ValidOptionDecider decider = option -> false;
//        assertEquals(RentACat.promptObjectLoop(cats, scanner, decider, "", "", ""), cats.get(3));
//
//
//    }

}
