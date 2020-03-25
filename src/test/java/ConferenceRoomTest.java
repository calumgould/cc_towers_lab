import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConferenceRoomTest {

  ConferenceRoom conferenceRoom;
  Guest guest;
  Guest guest2;

  @Before
  public void before(){
      conferenceRoom = new ConferenceRoom(5, "Hopper");
      guest = new Guest("Roosa");
      guest2 = new Guest("Calum");
  }

  @Test
  public void checkHasName(){
    assertEquals("Hopper", conferenceRoom.getName());
  }

  @Test
  public void checkStartsEmpty(){
    assertTrue(conferenceRoom.isEmpty());
  }

  @Test
  public void canCheckIfFull(){
    conferenceRoom.addGuest(guest);
    conferenceRoom.addGuest(guest);
    conferenceRoom.addGuest(guest2);
    conferenceRoom.addGuest(guest2);
    conferenceRoom.addGuest(guest2);
    assertTrue(conferenceRoom.isFull());
  }

  @Test
  public void checkCannotExceedCapacity(){
    conferenceRoom.addGuest(guest);
    conferenceRoom.addGuest(guest);
    conferenceRoom.addGuest(guest);
    conferenceRoom.addGuest(guest2);
    conferenceRoom.addGuest(guest2);
    conferenceRoom.addGuest(guest2);
    assertEquals(5, conferenceRoom.numberOfGuests());
  }

  @Test
  public void canDeactivateGuest(){
    conferenceRoom.addGuest(guest);
    conferenceRoom.addGuest(guest);
    conferenceRoom.addGuest(guest2);
    conferenceRoom.deactivateGuest(guest);
    assertEquals(2, conferenceRoom.numberOfGuests());
  }



}