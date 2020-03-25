import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BedroomTest {

    Bedroom singleBedroom;
    Bedroom doubleBedroom;
    Guest guest;

    @Before
    public void before(){
        singleBedroom = new Bedroom(9, 1, "single", 70);
        doubleBedroom = new Bedroom(10,2, "double", 100);
        guest = new Guest("Roosa");
        guest = new Guest("Calum");
    }

    @Test
    public void roomShouldStartEmpty(){
      assertEquals(0, singleBedroom.numberOfGuests());
    }

    @Test
    public void canAddGuest(){
      singleBedroom.addGuest(guest);
      assertEquals(1, singleBedroom.numberOfGuests());
    }

    @Test
    public void cannotAddGuestIfFull(){
        singleBedroom.addGuest(guest);
        singleBedroom.addGuest(guest);
        assertEquals(1, singleBedroom.numberOfGuests());
    }

    @Test
    public void canDeactivateGuest(){
        singleBedroom.addGuest(guest);
        singleBedroom.deactivateGuest(guest);
        assertEquals(0, singleBedroom.numberOfGuests());
    }

    @Test
    public void canDeactivateGuestByIndex(){
        singleBedroom.addGuest(guest);
        singleBedroom.deactivateGuestByIndex(0);
        assertEquals(0, singleBedroom.numberOfGuests());
    }

    @Test
    public void checkIsOccupied__true(){
        singleBedroom.addGuest(guest);
        assertTrue(singleBedroom.isOccupied());
    }

    @Test
    public void checkIsOccupied__false(){
        assertFalse(singleBedroom.isOccupied());
    }

    @Test
    public void checkIsEmpty__true(){
        assertTrue(singleBedroom.isEmpty());
    }
    @Test
    public void checkIsEmpty__false(){
        singleBedroom.addGuest(guest);
        assertFalse(singleBedroom.isEmpty());
    }

    @Test
    public void checkIsFull__true(){
        singleBedroom.addGuest(guest);
        assertTrue(singleBedroom.isFull());
    }
    @Test
    public void checkIsFull__false(){
        assertFalse(singleBedroom.isFull());
    }




}
