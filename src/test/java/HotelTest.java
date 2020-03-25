import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private Bedroom singleBedroom;
    private Bedroom doubleBedroom;
    private ConferenceRoom conferenceRoom;
    private ConferenceRoom smallConferenceRoom;
    private Guest guest;
    private Guest guest2;
    private Booking booking;
    private ArrayList<Guest> guests;


    @Before
    public void before(){
        singleBedroom = new Bedroom(1,1, "single", 70);
        doubleBedroom = new Bedroom(2,2, "double", 100);
        conferenceRoom = new ConferenceRoom(100, "Andrew");
        smallConferenceRoom = new ConferenceRoom(5, "Aliisa");
        guest = new Guest("Calum");
        guest2 = new Guest("Roosa");
        guests = new ArrayList<Guest>();
        booking = new Booking(singleBedroom, 5);

        ArrayList<Bedroom> bedrooms = new ArrayList<Bedroom>();
        bedrooms.add(singleBedroom);
        bedrooms.add(doubleBedroom);

        ArrayList<ConferenceRoom> conferenceRooms = new ArrayList<ConferenceRoom>();
        conferenceRooms.add(conferenceRoom);
        conferenceRooms.add(smallConferenceRoom);
        
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        bookings.add(booking);

        hotel = new Hotel(bedrooms, conferenceRooms, bookings, guests);
    }

    @Test
    public void canCheckInGuestToBedroom(){
        guests.add(guest);
        hotel.checkInGuestToBedroom(guests, singleBedroom);
        assertEquals(1, singleBedroom.numberOfGuests());
    }

    @Test
    public void cannotCheckInIfRoomFull(){
        guests.add(guest);
        hotel.checkInGuestToBedroom(guests, singleBedroom);
        hotel.checkInGuestToBedroom(guests, singleBedroom);
        assertEquals(1, singleBedroom.numberOfGuests());
    }

    @Test
    public void canCheckInMultipleGuestsToBedroom(){
        guests.add(guest);
        guests.add(guest2);
        hotel.checkInGuestToBedroom(guests, doubleBedroom);
        assertEquals(2, doubleBedroom.numberOfGuests());
    }

    @Test
    public void canDeactivateGuestFromBedroom(){
        guests.add(guest);
        guests.add(guest2);
        hotel.checkInGuestToBedroom(guests, doubleBedroom);
        hotel.deactivateGuestFromBedroom(guest, doubleBedroom);
        assertEquals(1, doubleBedroom.numberOfGuests());
    }

    @Test
    public void canCheckInGuestsToConferenceRoom(){
        hotel.checkInGuestToConferenceRoom(guest, smallConferenceRoom);
        hotel.checkInGuestToConferenceRoom(guest, smallConferenceRoom);
        hotel.checkInGuestToConferenceRoom(guest2, smallConferenceRoom);
        hotel.checkInGuestToConferenceRoom(guest2, smallConferenceRoom);
        assertEquals(4, smallConferenceRoom.numberOfGuests());
    }

    @Test
    public void canDeactivateGuestsFromConferenceRoom(){
        hotel.checkInGuestToConferenceRoom(guest, smallConferenceRoom);
        hotel.checkInGuestToConferenceRoom(guest2, smallConferenceRoom);
        hotel.deactivateGuestFromConferenceRoom(guest2, smallConferenceRoom);
        assertEquals(1, smallConferenceRoom.numberOfGuests());
    }

    @Test
    public void hasBooking(){
        assertEquals(1, hotel.getBookings());
    }

    @Test
    public void canAddBooking(){
        hotel.bookRoom(singleBedroom, 5);
        assertEquals(2, hotel.getBookings());
    }

    @Test
    public void canGetEmptyRooms(){
        guests.add(guest);
        hotel.checkInGuestToBedroom(guests, singleBedroom);
        assertEquals(1, hotel.getEmptyRooms().size());
    }
}
