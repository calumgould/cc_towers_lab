import java.awt.print.Book;
import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Booking> bookings;
    private ArrayList<Guest> guests;

    public Hotel(ArrayList<Bedroom> bedrooms,
                 ArrayList<ConferenceRoom> conferenceRooms,
                 ArrayList<Booking> bookings,
                 ArrayList<Guest> guests
                ){

        this.bedrooms = bedrooms;
        this.conferenceRooms = conferenceRooms;
        this.bookings = bookings;
        this.guests = guests;
    }

    public int getBedrooms(){
        return this.bedrooms.size();
    }

    public void checkInGuestToBedroom(ArrayList<Guest> guests, Bedroom room){
        ArrayList emptyRooms = getEmptyRooms();
        if (emptyRooms.contains(room)){
            for (int i = 0; i < guests.size(); i++) {
                room.addGuest(guests.get(i));
            }
        }
    }

    public void checkInGuestToConferenceRoom(Guest guest, ConferenceRoom conferenceRoom){
      conferenceRoom.addGuest(guest);
    }

    public void deactivateGuestFromBedroom(Guest guest, Bedroom room){
      room.deactivateGuest(guest);
    }

    public void deactivateGuestFromConferenceRoom(Guest guest, ConferenceRoom conferenceRoom){
      conferenceRoom.deactivateGuest(guest);
    }

    public void bookRoom(Bedroom room, int numberOfNights){
        Booking booking = new Booking(room, numberOfNights);
        this.bookings.add(booking);
    }

    public int getBookings(){
        return this.bookings.size();
    }

    public ArrayList getEmptyRooms(){
        ArrayList<Bedroom> emptyRooms = new ArrayList<Bedroom>();
        for (int i = 0; i < getBedrooms(); i++) {
            if (this.bedrooms.get(i).isEmpty()) {
                emptyRooms.add(this.bedrooms.get(i));
            }
        }
        return emptyRooms;
    }



}
