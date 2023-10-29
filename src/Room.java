public class Room {
    private int roomNumber;
    private int persons;

    private boolean hasBalcony;

    private boolean seeView;

    private int pricePerNight;

    public Room(int roomNumber, int persons, boolean hasBalcony, boolean seeView, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.persons = persons;
        this.hasBalcony = hasBalcony;
        this.seeView = seeView;
        this.pricePerNight = pricePerNight;
    }


    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isBalcony() {
        return hasBalcony;
    }

    public void setBalcony(boolean balcony) {
        this.hasBalcony = balcony;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isSeeView() {
        return seeView;
    }

    public String isSeeViewCzech() {
        if(seeView){
            return "ano";
        } else {
            return "ne";
        }
    }

    public void setSeeView(boolean seeView) {
        this.seeView = seeView;
    }
}
