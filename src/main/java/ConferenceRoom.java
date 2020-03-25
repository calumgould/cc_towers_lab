import java.util.ArrayList;

public class ConferenceRoom {

  private int capacity;
  private ArrayList<Guest> guests;
  private String name;

  public ConferenceRoom(int capacity, String name){
    this.capacity = capacity;
    this.guests = new ArrayList<Guest>();
    this.name = name;
  }

  public String getName(){
      return this.name;
  }

  public int numberOfGuests(){
      return this.guests.size();
  }

  public void addGuest(Guest guest){
      if(isFull()) {
          return;
      }
        this.guests.add(guest);
  }

  public void deactivateGuest(Guest guest){
      this.guests.remove(guest);
  }

  public boolean isEmpty(){
      return numberOfGuests() == 0;
  }

  public boolean isFull(){
      return numberOfGuests() >= this.capacity;
  }






}
