package garageManagment;

public abstract class Vhicle implements Comparable<Vhicle>{
	
	public enum vType {
		Car,Motorcycle,Truck;
	}
	public enum vStatus{
		NEW,IN_PROCESS,RELESSE;
	}
	vType type;
	int licensePlate;
	int year;
	String description;
	vStatus status;
	
	

	@Override
	public int compareTo(Vhicle vhicle) {
		// TODO Auto-generated method stub
		int compareYear = ((Vhicle) vhicle).year;
		return this.year-compareYear;
	}
	public abstract String toString() ;
	public Vhicle(vType type, int licensePlate, int year, String description, vStatus status) {
		super();
		this.type = type;
		this.licensePlate = licensePlate;
		this.year = year;
		this.description = description;
		this.status = status;
	}
	
	///motorcycle 1000 
	// boolean extraSit
	//car 2000
	// truck 5000
	//double LimitWhigt
	
	
}
