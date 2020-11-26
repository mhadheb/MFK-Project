package com.mfk.models;

public class VideoGames {

	public VideoGames(int rank, String name, String platform, String year, String genre, String publisher, float nASales,
			float eUSales, float jPSales, float otherSales, float globalSales) {
		super();
		this.rank = rank;
		this.name = name;
		this.platform = platform;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
		NASales = nASales;
		EUSales = eUSales;
		JPSales = jPSales;
		this.otherSales = otherSales;
		this.globalSales = globalSales;
	}
	private int rank;
	private String name;
	private String platform;
	private String year;
	private String genre;
	private String publisher;
	private float NASales;
	private float EUSales;
	private float JPSales;
	private float otherSales;
	private float globalSales;
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public float getNASales() {
		return NASales;
	}
	public void setNASales(float nASales) {
		NASales = nASales;
	}
	public float getEUSales() {
		return EUSales;
	}
	public void setEUSales(float eUSales) {
		EUSales = eUSales;
	}
	public float getJPSales() {
		return JPSales;
	}
	public void setJPSales(float jPSales) {
		JPSales = jPSales;
	}
	public float getOtherSales() {
		return otherSales;
	}
	public void setOtherSales(float otherSales) {
		this.otherSales = otherSales;
	}
	public float getGlobalSales() {
		return globalSales;
	}
	public void setGlobalSales(float globalSales) {
		this.globalSales = globalSales;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideoGames other = (VideoGames) obj;
		if (rank != other.rank)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VideoGames [rank=" + rank + ", name=" + name + ", platform=" + platform + ", year=" + year + ", genre="
				+ genre + ", publisher=" + publisher + ", NASales=" + NASales + ", EUSales=" + EUSales + ", JPSales="
				+ JPSales + ", otherSales=" + otherSales + ", globalSales=" + globalSales + "]";
	}
	
	
}
