package garageManagment;

public class Truck extends Vhicle {
	double weightLimit;

	public Truck(vType type, int licensePlate, int year, String description, vStatus status,double wightLimit) {
		super(type, licensePlate, year, description, status);
		this.weightLimit=wightLimit;
	}

	@Override
	public String toString() {
		return "Truck [weightLimit=" + weightLimit + ", type=" + type + ", licensePlate=" + licensePlate + ", year="
				+ year + ", description=" + description + ", status=" + status + "]";
	}



	
	
}
