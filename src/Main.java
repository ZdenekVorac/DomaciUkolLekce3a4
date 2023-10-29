import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        BookingManager reservationBook = new BookingManager();
        fillBooking(reservationBook);
        System.out.println("Počet pracovních rezervací je: " + String.valueOf(reservationBook.getNumberOfWorkingBookings()));
        System.out.println("Průměrný počet hostů je: " + String.valueOf(reservationBook.getAverageGuests()));
        System.out.println(reservationBook.toString());
        firstEightRecreationBookings(reservationBook, 8);
        printGuestStatistics(reservationBook);
    }

    public static void fillBooking(BookingManager reservationBook)
    {
        Guest guest1 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15));
        Guest guest2 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3));
        Guest guest3 = new Guest("Karolína", "Tmavá", LocalDate.of(2000, 8, 20));

        Room room1 = new Room(1, 1, true, true, 1000);
        Room room2 = new Room(2, 1, true, true, 1000);
        Room room3 = new Room(3, 3, false, true, 2400);

        reservationBook.addBooking(new Booking(room3, LocalDate.of(2023, 6, 1),
                LocalDate.of(2023, 6, 7), guest1, BookingType.WORK));
        reservationBook.addBooking(new Booking(room2, LocalDate.of(2023, 7, 18),
                LocalDate.of(2023, 7, 21), guest2, BookingType.RECREATIONAL));
        LocalDate startDate = LocalDate.of(2023, 8, 1);
        for (int i = 0; i < 10; i++) {

            reservationBook.addBooking(new Booking(room2, startDate, startDate.plusDays(1), guest3, BookingType.RECREATIONAL));
            startDate = startDate.plusDays(2);
        }
        reservationBook.addBooking(new Booking(room3, LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), guest3, BookingType.RECREATIONAL));
        Booking dvaHoste = new Booking(room3, LocalDate.of(2023, 6, 1),
                LocalDate.of(2023, 6, 7), guest1, BookingType.WORK);
        dvaHoste.addOtherGuest(guest2);
        reservationBook.addBooking(dvaHoste);

    }

    public static void firstEightRecreationBookings(BookingManager reservationBook, int count) {
        int repetition = 1;
        for (Booking booking : reservationBook.getBookingList()) {
            if (repetition <= count && booking.getType() == BookingType.RECREATIONAL) {

                System.out.println(booking.toString());
                repetition++;
            }
        }
    }

    public static void printGuestStatistics(BookingManager reservationBook) {
        int countSingleGuest = 0;
        int countDoubleGuest = 0;
        int countMoreGuest = 0;
        for (Booking booking : reservationBook.getBookingList()) {
            switch (booking.getNumberOfGuests()) {
                case 0: {
                    break;
                }
                case 1: {
                    countSingleGuest++;
                    break;
                }
                case 2: {
                    countDoubleGuest++;
                    break;
                }
                default: {
                    countMoreGuest++;
                    break;
                }
            }
        }
        System.out.println("Počet rezervací s jedním hostem: " + String.valueOf(countSingleGuest));
        System.out.println("Počet rezervací se dvěma hosty: " + String.valueOf(countDoubleGuest));
        System.out.println("Počet rezervací s více než dvěma hosty: " + String.valueOf(countMoreGuest));
    }
}