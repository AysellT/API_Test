package pojos;

public class PojoHerkokuappRequestBody {

    //1- tum variable'lari rpivate olustur
    private String firstname ;
    private String lastname ;
    private int totalprice ;
    private Boolean depositpaid ;
    private PojoHerokuappBookingdates bookingdates ;
    private String additionalneeds ;

    //2-tum variable'lar icin getter ve setter olustur
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public PojoHerokuappBookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(PojoHerokuappBookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    //3-tum parametreleri kullanarak constructor
    public PojoHerkokuappRequestBody(String firstname, String lastname, int totalprice,
                         Boolean depositpaid, PojoHerokuappBookingdates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    //4- parametresiz constructor
    public PojoHerkokuappRequestBody() {
    }

    //5-toString methodu olusturalim
    @Override
    public String toString() {
        return "PojoHerkokuappRequestBody{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
