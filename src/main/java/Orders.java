
public class Orders {
    private String firstName;
    private String secondName;
    private String address;
    private String stationMetro;
    private String phoneNumber;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;

    public Orders(String firstName, String secondName, String address, String stationMetro, String phoneNumber,
                  int rentTime, String deliveryDate, String comment, String[] color) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.stationMetro = stationMetro;
        this.phoneNumber = phoneNumber;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStationMetro() {
        return stationMetro;
    }

    public void setStationMetro(String stationMetro) {
        this.stationMetro = stationMetro;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }
}
