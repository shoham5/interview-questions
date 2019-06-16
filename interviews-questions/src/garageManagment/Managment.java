package garageManagment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

import garageManagment.Vhicle.vStatus;
import garageManagment.Vhicle.vType;

public class Managment {

	TreeMap<Integer, Vhicle> allVhic ;// = new TreeMap<>();
	ArrayList<Vhicle> ansList;
	Garage garage;
	private Scanner in;
	Vhicle ansVec;
	List<Vhicle> lsVec;




	public Managment() {
		super();
		this.allVhic = new TreeMap<Integer, Vhicle>();
		this.ansList = new ArrayList<Vhicle>();
		this.garage = new Garage();
		this.in = new Scanner(System.in);
		this.ansVec = null;
		lsVec = new ArrayList<Vhicle>();
	}



	public void menu(){
		int i=0;
		while (i!=9) {
			System.out.println("please choose from the menu: "
					+ "\n1.insert new vhicle"
					+ "\n2.change vhicle status"
					+ "\n3.change vhicle license number"
					+ "\n4.Garage profit"
					+ "\n5.get vhicle by descrption"
					+ "\n6.vhicle in  garage"
					+ "\n7.vhicle sort by year "
					+ "\n8. vhicle by license plate"
					+ "\n9.exit");
			in = new Scanner(System.in);
			i=in.nextInt();
			switch(i){
			case 1:
				insertVhicle();
				break;
			case 2:
				changeStatus();
				break;
			case 3:
				changeLicense();
				break;
			case 4:
				System.out.println("garage profit: "+getGarageProfit());
				break;
			case 5:
				System.out.println("please type a description: ");
				in = new Scanner(System.in);
				String  serchDesc=in.nextLine();
				getListByDescription(serchDesc);
				System.out.println("finish 5");
				break;
			case 6:
				vhicleListInGarage();
				System.out.println("finish 6");
				break;
			case 7:
				getVhicleSortByYear();
				System.out.println("finish 7");
				break;
			case 8:
				System.out.println("please type a License plate: ");
				in = new Scanner(System.in);
				int serchLicense=in.nextInt();
				System.out.println(getVhicleByLicensePlate(serchLicense).toString());
				break;
			case 9:
				finishMenu();
				break;
			}
		}
	}



	private void MapActionList() {

		for (Entry<Integer, Vhicle> entry:allVhic.entrySet()) {
			System.out.println("Key = " + entry.getKey() + 
					", Value = " + entry.getValue()); 
		}

	}
	private void itreateMapActionList() {

	} 
	private void finishMenu() {

		System.out.println("you chose to exit garage management");
		System.out.println("GOOD BYE");
		in.close();
	}

	private Vhicle getVhicleByLicensePlate(int licensePlate) {
		ansVec = allVhic.get(licensePlate);
		return ansVec;

	}
	private ArrayList<Vhicle> getVhicleSortByYear() {
		lsVec.clear();
		for (Map.Entry<Integer, Vhicle> entr:allVhic.entrySet())  
		{ 
						lsVec.add(entr.getValue());
		}
		Collections.sort(lsVec);
		System.out.println("ans: " + lsVec.toString());
		return (ArrayList<Vhicle>) lsVec;

	}

	private ArrayList<Vhicle> vhicleListInGarage() {
		ansList.clear();
		for (Map.Entry<Integer, Vhicle> entr:allVhic.entrySet()) 
		{ 
			if(entr.getValue().status.equals(vStatus.IN_PROCESS)) {
				ansList.add(entr.getValue());
			}
		}
		System.out.println("ans: " + ansList.toString());
		return ansList;

	}

	private ArrayList<Vhicle> getListByDescription(String s) {
		ansList.clear();
		for (Map.Entry<Integer, Vhicle> entr:allVhic.entrySet()) { 
			if(entr.getValue().description.equals(s)) {
				ansList.add(entr.getValue());
			}
		}
		System.out.println("ans: " + ansList.toString());
		return ansList;
	}

	private int getGarageProfit() {
		return garage.totalAmaunt;
	}

	private void changeLicense() {
		in = new Scanner(System.in);
		System.out.println("insert old license plate: ");
		int oldLicensePlate =in.nextInt();
		in =new Scanner(System.in);
		System.out.println("insert new license number? ");
		int newLicensePlate = in.nextInt();
		allVhic.get(oldLicensePlate).licensePlate=newLicensePlate;
		allVhic.put(newLicensePlate,allVhic.get(oldLicensePlate));
		allVhic.remove(oldLicensePlate);
	}

	private void changeStatus() {
		in = new Scanner(System.in);
		System.out.println("insert new status <1-IN PROCESS 2-RELESSED ");
		int statusNew=in.nextInt();
		in =new Scanner(System.in);
		System.out.println("license number? ");
		int licensePlate = in.nextInt();
		vStatus vStatusNew = null;
		switch(statusNew)
		{
		case 1: 
			vStatusNew = vStatus.IN_PROCESS ; 
			//garage.inProcess.add(allVhic.get(licensePlate));
			break ;
		case 2 : 
			vStatusNew = vStatus.RELESSE;
			garage.totalAmaunt+=garageProfit(allVhic.get(licensePlate));
			break ; 
		}	
		allVhic.get(licensePlate).status=vStatusNew;	
	}

	private int garageProfit(Vhicle vec) {
		vType vtype = vec.type;
		switch (vtype) {
		case Car:
			return 2000;
		case Motorcycle:
			return 1000;
		case Truck:
			return 5000;
		}
		return 0;
	}
	private void buildVhicle(int type , int licensePlate ,int year,String description,boolean extraSit , double weightLimit) {
		Vhicle vec=null ;
		switch(type){
		case 1: 
			vec=new Car(vType.Car, licensePlate, year, description, vStatus.NEW);
			break;
		case 2:
			vec = new Motorcycle (vType.Motorcycle, licensePlate, year, description, vStatus.NEW , extraSit);
			break;
		case 3:
			vec=new Truck(vType.Truck, licensePlate, year, description, vStatus.NEW,weightLimit);
			break;
		}
		allVhic.put(licensePlate, vec);
	}
	private void insertVhicle() {
		in = new Scanner(System.in);
		System.out.println("1-Car 2-Motorcycle 3-Truck");
		int type=in.nextInt();
		in =new Scanner(System.in);
		System.out.println("license number? ");
		int licensePlate = in.nextInt();
		in =new Scanner(System.in);
		System.out.println("manu year ");
		int year=in.nextInt();
		in =new Scanner(System.in);
		System.out.println("description ");
		String description = in.nextLine();
		in =new Scanner(System.in);
		boolean extraSit=false;
		double weightLimit=0;
		switch(type){
		case 1: 
			break;
		case 2:
			System.out.println("extra sit <1-false 2-true>:");
			in =new Scanner(System.in);
			int extrsit = in.nextInt();
			extraSit = extrsit==1 ? false:true;
			break;
		case 3:
			System.out.println("please insert weight limit:");
			in =new Scanner(System.in);
			weightLimit = in.nextInt();
			break;
		}
		buildVhicle(type,licensePlate, year, description,extraSit,weightLimit);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Managment mng = new Managment() ;
		mng.menu();
	ArrayList<Integer> in = new ArrayList<Integer>() ; 
		TreeMap<Integer, Integer> tm =new TreeMap<>();
		tm.put(3, 10);
		tm.put(13, 10);
		tm.put(23, 10);
		tm.put(1, 6);
		tm.put(5, 7);
		tm.put(10, 10);
		tm.put(11, 10);
		tm.put(233, 10);
		tm.put(31, 5);
		tm.put(113, 110);
		Iterator<Entry<Integer, Integer>> it = tm.entrySet().iterator();
		while(it.hasNext()) 
		{ 
			Entry<Integer, Integer> entry = it.next(); 
			if(entry.getValue()==10) {
				in.add(entry.getValue());
				System.out.println(entry.toString());
			}
			
		}
		System.out.println(in.toString());
		
	}

}
