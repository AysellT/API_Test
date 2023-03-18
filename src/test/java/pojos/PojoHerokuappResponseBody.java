package pojos;

public class PojoHerokuappResponseBody {

    //1-
    private int bookingid;
    private PojoHerkokuappRequestBody booking;

    //2-
    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHerkokuappRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerkokuappRequestBody booking) {
        this.booking = booking;
    }

    //3-
    public PojoHerokuappResponseBody(int bookingid, PojoHerkokuappRequestBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    //4-
    public PojoHerokuappResponseBody() {
    }

    //5-
    @Override
    public String toString() {
        return "PojoHerokuappResponseBody{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
