package garageManagment;

public class Car extends Vhicle {

	public Car(vType type, int licensePlate, int year, String description, vStatus status) {
		super(type, licensePlate, year, description, status);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Car [type=" + type + ", licensePlate=" + licensePlate + ", year=" + year + ", description="
				+ description + ", status=" + status + "]";
	}

	

}
