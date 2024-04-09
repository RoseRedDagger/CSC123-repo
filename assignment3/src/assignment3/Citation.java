package assignment3;
import java.time.LocalDate;
public class Citation{
	LocalDate date;
    int offenseCode;
    double amount;
    String status;
    Registration registration;

    Citation(LocalDate date, int offenseCode, double amount, String status, Registration registration) {
        this.date = date;
        this.offenseCode = offenseCode;
        this.amount = amount;
        this.status = status;
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "Citation{" +
                "date=" + date +
                ", offenseCode=" + offenseCode +
                ", amount=" + String.format("%.2f", amount) +
                ", status='" + status + '\'' +
                '}';
    }
	

}
