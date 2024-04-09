package assignment3;
import java.time.LocalDate;
public class Registration{
	    int uniqueID;
	    LocalDate startDate;
	    LocalDate endDate;
	    Owner owner;
	    Vehicle vehicle;
	    String plate;

	    Registration(int uniqueID, LocalDate startDate, LocalDate endDate, Owner owner, Vehicle vehicle, String plate) {
	        this.uniqueID = uniqueID;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.owner = owner;
	        this.vehicle = vehicle;
	        this.plate = plate;
	    }

	    @Override
	    public String toString() {
	        return "Registration{" +
	                "uniqueID=" + uniqueID +
	                ", startDate=" + startDate +
	                ", endDate=" + endDate +
	                ", owner=" + owner +
	                ", vehicle=" + vehicle +
	                ", plate='" + plate + '\'' +
	                '}';
	    }
	
	

}
