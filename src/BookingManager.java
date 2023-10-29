import java.math.BigDecimal;
import java.math.MathContext;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingManager {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d.M.YYYY");

    private List<Booking> bookingList;

    public BookingManager() {
        this.bookingList = new ArrayList<>();
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public void addBooking(Booking newBooking)
    {
        bookingList.add(newBooking);
    }

    public Booking getBooking(int index){ return bookingList.get(index); }

    public List<Booking> getBookings(){ return bookingList; }

    public int getNumberOfWorkingBookings(){
        int count=0;
        for(Booking booking : bookingList)
        {
            if (booking.getType()==BookingType.WORK) count++;
        }
        return count;
    }

    public BigDecimal getAverageGuests(){
        BigDecimal average=BigDecimal.ZERO;
        int guestCount = 0;
        for(Booking booking : bookingList)
        {
            guestCount+=booking.getNumberOfGuests();
        }
        average = BigDecimal.valueOf(guestCount).divide(BigDecimal.valueOf(bookingList.size()),new MathContext(5));
        return average;
    }

    public void clearBookings(){ bookingList.clear(); }

    public void removeBooking(Booking canceledBooking)
    {
        bookingList.remove(canceledBooking);
    }
    @Override
    public String toString()
    {
        String reservationsString = bookingList.stream().map(Booking::toString)
                .collect(Collectors.joining("\n"));
        return reservationsString;
    }
}
