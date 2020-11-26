package com.mfk.data;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mfk.models.VideoGames;
import com.mfk.models.YearSales;




public class main1 {

	public static void main(String[] args) {
		List<VideoGames> videoGames = readVideoGamesFromCsv("vgames.csv");
		
		
		// print games where publisher is nintendo
		System.out.println(videoGames.stream().count());
		
		System.out.println("**** print games where publisher is nintendo ****\n".toUpperCase());
		videoGames.stream().filter(v->v.getPublisher().equals("Nintendo")).limit(5)
		.forEach(v->System.out.println(v));
		
		System.out.println("\n**** print games where global sales > 30 in millions ****\n".toUpperCase());
		//print games where global sales > 30 in millions
		videoGames.stream().filter(v->v.getGlobalSales()>(float) 30)
		.forEach(v->System.out.println(v));
		
		//print games where platform string contains Wi and EU Sales > 5 Millions
		System.out.println("\n**** print games where platform string contains Wi and EU Sales > 5 Millions ****\n".toUpperCase());
		videoGames.stream().filter(v->v.getPlatform().contains("Wi") && v.getEUSales()>5)
		.forEach(v->System.out.println(v));
		
		//print 5 distinct publishers and print total distinct publishers
		System.out.println("\n**** print 5 distinct publishers and print total distinct publishers ****\n".toUpperCase());
		List<String> distinctPublishers= videoGames.stream()
			.map(v->v.getPublisher()).distinct().collect(Collectors.toList());
		distinctPublishers.stream().limit(5).forEach(p->System.out.println(p));
		System.out.println("Total distinct Publishers= "+distinctPublishers.stream().count());
		
		
		//Print total sales for each year
		System.out.println("\n**** Print total sales for each year ****\n".toUpperCase());
		Map<String,List<YearSales>> myMap=videoGames.stream().map(v->{
			YearSales obj = new YearSales(v.getYear(),v.getGlobalSales());
			return obj;
		}).collect(Collectors.groupingBy(YearSales::getYear));
		
	
		myMap.keySet().forEach(k-> {
				float r = Float.parseFloat(k);
				int i = (int) r;
			System.out.println("Total sales in year "+i+"== ");
			System.out.println(myMap.get(k).stream().mapToDouble(y->y.getSales()).reduce((a,b)->{
				return a + b;
			}).getAsDouble());
				}
			);
		
	
	}
	
	
	
	private static List<VideoGames> readVideoGamesFromCsv(String fileName) {
		List<VideoGames> videoGames = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
			String line = br.readLine();
			line = br.readLine();
		
			while (line != null) {
				
				String[] attributes = line.split(",");
				
				VideoGames videoGame = createVideoGames(attributes);
				if(videoGame != null)
				videoGames.add(videoGame);
				line = br.readLine();
				
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return videoGames;
	}

	public static VideoGames createVideoGames(String[] metadata) {
		
		 int rank = Integer.parseInt(metadata[0]);
		 String name =metadata[1];
		 String platform =metadata[2];
		 String year = metadata[3];
		 String genre =metadata[4];
		 String publisher=metadata[5];
		 float NASales=0f;
		 float EUSales=0f;
		 float JPSales=0f;
		 float otherSales=0f;
		 float globalSales=0f;
		 try {
			 
			  NASales = Float.parseFloat(metadata[6]);
			  EUSales=Float.parseFloat(metadata[7]);
			  JPSales=Float.parseFloat(metadata[8]);
			  otherSales=Float.parseFloat(metadata[9]);
			  globalSales=Float.parseFloat(metadata[10]);
		 }
		 catch(Exception e) {
			 
			return null;
		 }
		
       
        return new VideoGames(rank,name,platform,year,genre,publisher,NASales,EUSales,JPSales,otherSales,globalSales);
	
	}
	
}
