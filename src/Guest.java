import java.time.LocalDate;

public class Guest {
    private String name;
    private String surname;
    private LocalDate birthDate;

    public Guest(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name+" "+surname+" ("+BookingManager.FORMATTER.format(birthDate)+")";
    }
}
