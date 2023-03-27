package pl.naprawagsm.priceList.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PriceList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String model;
	private int lcd;
	private int battery;
	private int speaker;
	
	public PriceList() {};
	
	public PriceList(String brand, String model, int lcd, int battery, int speaker) {
		super();
		this.brand = brand;
		this.model = model;
		this.lcd = lcd;
		this.battery = battery;
		this.speaker = speaker;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getLcd() {
		return lcd;
	}

	public void setLcd(int lcd) {
		this.lcd = lcd;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public int getSpeaker() {
		return speaker;
	}

	public void setSpeaker(int speaker) {
		this.speaker = speaker;
	}

	@Override
	public String toString() {
		return "id=" + id + ", brand=" + brand + ", model=" + model + ", lcd=" + lcd + ", battery=" + battery
				+ ", speaker=" + speaker;
	}


}
