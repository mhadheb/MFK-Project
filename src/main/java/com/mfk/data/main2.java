package com.mfk.data;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mfk.models.GooglePlayStore;
import com.opencsv.CSVReader;

public class main2 {

	public static void main(String[] args) {
		List<GooglePlayStore> googlePlayStore = readFromCSV();

		System.out.println(googlePlayStore.stream().count());

		// print top 5 installs
		System.out.println("********** Print top 5 installs**********");
		googlePlayStore.stream().sorted(Comparator.comparing(GooglePlayStore::customStringParser, (a, b) -> {
			if (a - b < 0)
				return 1;
			if (a - b > 0)
				return -1;
			else
				return 0;
		})).limit(5).forEach(i -> System.out.println(i.getApp() + "= " + i.getInstalls()));
		// print top 5 installs where genre = art and design
		System.out.println("\n********** Print top 5 installs where genre = art and design **********\n");
		googlePlayStore.stream().filter(i -> i.getGenres().equals("Art & Design"))
				.sorted(Comparator.comparing(GooglePlayStore::customStringParser, (a, b) -> {
					if (a - b < 0)
						return 1;
					if (a - b > 0)
						return -1;
					else
						return 0;
				})).limit(5).forEach(i -> System.out.println(i.getApp() + "= " + i.getInstalls()));
		// print top 5 Rating apps where genre = medical
		System.out.println("\n********** print top 5 Rating apps where genre = medical **********\n");
		googlePlayStore.stream().filter(i -> i.getGenres().equals("Medical"))
				.sorted(Comparator.comparing(GooglePlayStore::getRating, (a, b) -> {
					float minus = b - a;
					return (int) minus;
				})).limit(5).forEach(i -> System.out.println(i.getApp() + "= " + i.getRating()));

		// print top 5 most priced apps
		System.out.println("\n********** print top 5 most priced apps**********\n");
		googlePlayStore.stream().sorted(Comparator.comparing(GooglePlayStore::customPriceParser, (a, b) -> {
			float minus = b - a;
			return (int) minus;
		})).limit(5).forEach(i -> System.out.println(i.getApp() + "= " + i.getPrice()));
		// Print Google Play Store grouped by Genres
		System.out.println("\n**********  Print Google Play Store grouped by Genres **********\n");

		Map<String, List<GooglePlayStore>> myMap = googlePlayStore.stream().limit(5)
				.collect(Collectors.groupingBy(GooglePlayStore::getGenres));
		for (Map.Entry<String, List<GooglePlayStore>> entry : myMap.entrySet()) {
			System.out.println(entry.getKey());
			entry.getValue().stream().forEach(i -> System.out.println(i));
		}

		// Print Average rating for each Genre
		System.out.println("\n**********  Print Average rating for each Genre **********\n");
		googlePlayStore.stream().collect(Collectors.groupingBy(GooglePlayStore::getGenres)).entrySet().stream()
				.map(i -> i.getValue().stream().mapToDouble(x -> x.getRating()).average().getAsDouble()).forEach(i -> {
					googlePlayStore.stream().collect(Collectors.groupingBy(GooglePlayStore::getGenres)).keySet()
							.stream().forEach(c -> System.out.println(c + "= " + i));
				});

	}

	public static List<GooglePlayStore> readFromCSV() {

		CSVReader csvReader = null;
		List<GooglePlayStore> googlePlayStores = new ArrayList<GooglePlayStore>();

		try {

			csvReader = new CSVReader(new FileReader("Googleplay.csv"));
			String[] googlePlayDetails = null;
			csvReader.readNext();

			while ((googlePlayDetails = csvReader.readNext()) != null) {

				GooglePlayStore toAdd = new GooglePlayStore(googlePlayDetails[0], googlePlayDetails[1],
						Float.parseFloat(googlePlayDetails[2]), Integer.parseInt(googlePlayDetails[3]),
						googlePlayDetails[4], googlePlayDetails[5], googlePlayDetails[6], googlePlayDetails[7],
						googlePlayDetails[8], googlePlayDetails[9], googlePlayDetails[10], googlePlayDetails[11],
						googlePlayDetails[12]);

				googlePlayStores.add(toAdd);

			}

		} catch (Exception e) {
			System.out.println(e);

		}
		return googlePlayStores;
	}

}
