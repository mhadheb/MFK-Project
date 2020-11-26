package com.mfk.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mfk.models.Cars;
import com.mfk.models.ModelDim;


public class main3 {

	
	public static void main(String[] args) {
		List<Cars> cars = readCarsFromCSV("CARS-2.csv");
		
		//print total data rows
		System.out.println("Total data rows=/n"+cars.stream().count());
		//Print Top 5 sales in Thousands of all time
		System.out.println("Top 5 sales in Thousands of all time");
		cars.stream().sorted(Comparator.comparing(Cars::getSalesInThounsands,(a,b)-> {
			if(a-b<0)
				return 1;
			if(a-b>0)
				return -1;
			else
				return 0;
		})).limit(5)
		.forEach(i->System.out.println(i.getModel()+": "+i.getSalesInThounsands()));
		
		//Print Top 5 sales in thousands in 2012
		System.out.println("Top 5 sales in thousands in 2012");
		cars.stream().filter(i->{
			   Calendar calendar = Calendar.getInstance();
		       calendar.setTime(i.getLatestLaunch());
		       return calendar.get(Calendar.YEAR) == 2012;
		})
		.sorted(Comparator.comparing(Cars::getSalesInThounsands,(a,b)-> {
			if(a-b<0)
				return 1;
			if(a-b>0)
				return -1;
			else
				return 0;
		})).limit(5)
		.forEach(i->System.out.println(i.getModel()+": "+i.getSalesInThounsands()));
		//Print Total Sales in Thousands
		System.out.println("Total Sales in Thousands");
		Double totalSales = cars.stream().mapToDouble(i->i.getSalesInThounsands()).sum();
		System.out.println(totalSales);
		
		//Print Top Fuel Efficient cars
		System.out.println("Top 5 Fuel Efficient cars");
		cars.stream()
		.sorted(Comparator.comparing(Cars::getFuelEfficiency,(a,b)-> {
			float minus = b-a;
			return (int) minus;
		})).limit(5)
		.forEach(i->System.out.println(i.getModel()+": "+i.getFuelEfficiency()));
		
		//Print max width * length of cars
		System.out.println(cars.stream().map(i->new ModelDim(i.getModel(),i.getWidth(),i.getLenght()))
		.max(Comparator.comparing(ModelDim::getDim)).get());
		
		
		// Print Audi cars groupped by Year
		Map<Integer, List<Cars>> myMap = cars.stream().filter(i->i.getManufacturer().equals("Audi"))
				.collect(Collectors.groupingBy(Cars::getYear));
		
		for(Map.Entry<Integer, List<Cars>> entry: myMap.entrySet()) {
			System.out.println(entry.getKey());
			entry.getValue().stream().forEach(i->System.out.println(i));
		}
		
		


	}
	private static List<Cars> readCarsFromCSV(String fileName) {
		List<Cars> Carss = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] attributes = line.split(",");
				Cars Cars = createCars(attributes);
				Carss.add(Cars);
				line = br.readLine();
				
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return Carss;
	}

	public static Cars createCars(String[] metadata) {
		

		String manufacturer= metadata[0];
		String model= metadata[1];
		float salesInThounsands=Float.parseFloat(metadata[2]);
		float yearResaleValue=Float.parseFloat(metadata[3]);
		String vehicleType =metadata[4];
		float priceInThousands = Float.parseFloat(metadata[5]);
		float engineSize= Float.parseFloat(metadata[6]);
		float horsepower =Float.parseFloat(metadata[7]);
	    float wheelbase= Float.parseFloat(metadata[8]);
	    float width = Float.parseFloat(metadata[9]);
	    float lenght =Float.parseFloat(metadata[10]);
	    float curbWeight=Float.parseFloat(metadata[11]);
	    float fuelCapacity= Float.parseFloat(metadata[12]);
	    float fuelEfficiency = Float.parseFloat(metadata[13]);
	    Date latestLaunch = new Date();
		try {
			latestLaunch = new SimpleDateFormat("dd/MM/yyyy").parse(metadata[14]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    float powerPerfFactor = Float.parseFloat(metadata[15]);
		
       
        return new Cars(manufacturer,model,salesInThounsands,yearResaleValue,vehicleType,priceInThousands,engineSize,horsepower,wheelbase,width,lenght,curbWeight,fuelCapacity,fuelEfficiency,latestLaunch,powerPerfFactor);
	}

}
