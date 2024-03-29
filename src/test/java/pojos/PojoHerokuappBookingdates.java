package pojos;

public class PojoHerokuappBookingdates {

    //1-tum variable'lari private olarak olustur
    private String checkin;
    private String checkout;

    //2-tum variable'lar icin getter ve setter methodlari olustur
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    //3-tum parametreleri kullanarak bir constructor olusturalim
    public PojoHerokuappBookingdates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    //4-parametresiz constructor olusturalim
    public PojoHerokuappBookingdates() {
    }

    //5- toString methodu olusturalim
    @Override
    public String toString() {
        return "PojoHerokuappBookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }

}
