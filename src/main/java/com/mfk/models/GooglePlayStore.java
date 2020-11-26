package com.mfk.models;

import java.util.ArrayList;
import java.util.List;

public class GooglePlayStore {
	
	public GooglePlayStore(String app, String category, float rating, int reviews, String size, String installs,
			String type, String price, String contentRating, String genres, String lastUpdated, String currentVer,
			String androidVer) {
		super();
		this.app = app;
		this.category = category;
		this.rating = rating;
		this.reviews = reviews;
		this.size = size;
		this.installs = installs;
		this.type = type;
		this.price = price;
		this.contentRating = contentRating;
		this.genres = genres;
		this.lastUpdated = lastUpdated;
		this.currentVer = currentVer;
		this.androidVer = androidVer;
	}
	private String app;
	private String category;
	private float rating;
	private int reviews;
	private String size;
	private String installs;
	private String type;
	private String price;
	private String contentRating;
	private String genres;
	private String lastUpdated;
	private String currentVer;
	private String androidVer;
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getReviews() {
		return reviews;
	}
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getInstalls() {
		return installs;
	}
	public void setInstalls(String installs) {
		this.installs = installs;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getContentRating() {
		return contentRating;
	}
	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getCurrentVer() {
		return currentVer;
	}
	public void setCurrentVer(String currentVer) {
		this.currentVer = currentVer;
	}
	public String getAndroidVer() {
		return androidVer;
	}
	public void setAndroidVer(String androidVer) {
		this.androidVer = androidVer;
	}
	
	public float customPriceParser() {
		String toParse=this.price;

		char[] charArray = toParse.toCharArray();
		List<Character> myList= new ArrayList<>();
		for(int i=0;i<charArray.length;i++) {
	    myList.add(charArray[i]);
		}
		for(int i =0;i<myList.size();i++) {
			if(myList.get(i)== "$".toCharArray()[0]) {
				myList.remove(i);
			}
		}
		char[] toReturn=new char[50];
		for(int i=0;i<myList.size();i++) {
			toReturn[i] = myList.get(i);
		}
		
		String finalString = new String(toReturn);
		return Float.parseFloat(finalString);
	}
	
	public int customStringParser() {
		String toParse=this.installs;

		char[] charArray = toParse.toCharArray();
		List<Character> myList= new ArrayList<>();
		for(int i=0;i<charArray.length;i++) {
	    myList.add(charArray[i]);
		}
		for(int i =0;i<myList.size();i++) {
			if(myList.get(i)== ",".toCharArray()[0] || myList.get(i)== "+".toCharArray()[0]) {
				myList.remove(i);
			}
		}
		char[] toReturn=new char[50];
		for(int i=0;i<myList.size();i++) {
			toReturn[i] = myList.get(i);
		}
		
		String finalString = new String(toReturn);
		return (int)Float.parseFloat(finalString);
	}
	@Override
	public String toString() {
		return "GooglePlayStore [app=" + app + ", category=" + category + ", rating=" + rating + ", reviews=" + reviews
				+ ", size=" + size + ", installs=" + installs + ", type=" + type + ", price=" + price
				+ ", contentRating=" + contentRating + ", genres=" + genres + ", lastUpdated=" + lastUpdated
				+ ", currentVer=" + currentVer + ", androidVer=" + androidVer + "]";
	}
	
	
	
	
	

}
