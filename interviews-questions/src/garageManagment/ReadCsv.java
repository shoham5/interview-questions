package garageManagment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadCsv {
	BufferedReader br;
	FileReader fr;
	String src;
	List<List<String>> records ; 
	List<String> values;
	
	
	public ReadCsv(String src) throws IOException {
		super();
		this.src=src;
		records = new ArrayList<>();
			fr = new FileReader(this.src);
			br = new BufferedReader(fr);
			
		
			
	}
	

	
	public void read()
	{
	    String line;
	    try {
			while ((line = br.readLine()) != null) {
			    String[] values = line.split(",");
			    records.add(Arrays.asList(values));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
	

