public class Booking {

    private Bedroom bedroom;
    private int numberOfNights;

    public Booking(Bedroom bedroom, int numberOfNights){
        this.bedroom = bedroom;
        this.numberOfNights = numberOfNights;
    }

    public int getNumberOfNights() {
        return this.numberOfNights;
    }
    
    public Object getRoom(){
        return this.bedroom;
    }

    public double getTotalBill(){
        return (this.bedroom.getNightlyRate() * this.numberOfNights);
    }

}
