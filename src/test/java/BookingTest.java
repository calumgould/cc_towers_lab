import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookingTest {
    Booking booking;
    Bedroom bedroom1;
    Hotel hotel;

    @Before
    public void before(){
        bedroom1 = new Bedroom(3, 2, "double", 50);
        booking = new Booking(bedroom1, 5);
    }

    @Test
    public void hasNumberOfNights(){
        assertEquals(5, booking.getNumberOfNights());
    }

    @Test
    public void hasRoomAssigned(){
        assertEquals(bedroom1, booking.getRoom());
    }

    @Test
    public void canGetBill(){
        assertEquals(250, booking.getTotalBill(), 0.01);
    }



}
