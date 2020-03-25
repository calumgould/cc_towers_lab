import java.util.ArrayList;

  public class Bedroom {

    private int roomNumber;
    private int capacity;
    private ArrayList<Guest> guests;
    private String type;
    private int nightlyRate;

    public Bedroom(int roomNumber, int capacity, String type, int nightlyRate){
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
        this.type = type;
        this.nightlyRate = nightlyRate;
    }

      public int getNightlyRate(){
        return this.nightlyRate;
      }

      public int numberOfGuests() {
        return this.guests.size();
      }

      public void addGuest(Guest guest){
        if (isFull()) {
          return;
        }
          this.guests.add(guest);
      }

      public void deactivateGuest(Guest guest) {
        this.guests.remove(guest);
      }

      public void deactivateGuestByIndex(int index){
        this.guests.remove(index);
      }

      public boolean isOccupied() {
        return numberOfGuests() > 0;
      }

      public boolean isEmpty(){
        return numberOfGuests() == 0;
      }

      public boolean isFull(){
        return numberOfGuests() >= this.capacity;
      }


  }
//- by Calum, 2020 <3
