package garageManagment;

public class Motorcycle extends Vhicle{
boolean extraSit;


	public Motorcycle(vType type, int licensePlate, int year, String description, vStatus status,boolean extraSit) {
		super(type, licensePlate, year, description, status);
		this.extraSit=false ;
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Motorcycle [extraSit=" + extraSit + ", type=" + type + ", licensePlate=" + licensePlate + ", year="
				+ year + ", description=" + description + ", status=" + status + "]";
	}



}
