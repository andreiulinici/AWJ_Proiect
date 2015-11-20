package hello;

import java.util.List;
import java.util.ArrayList;

public class Cars {
  private String manufacturer;
  private String model;
  private int id;
  private int miles;
  private int price;

  public Cars() {}

  public Cars(int id, String manufacturer, String model, int miles, int price) {
    this.manufacturer = manufacturer;
	this.model = model;
    this.id = id;
    this.miles = miles;
	this.price = price;

  }

  public String getManufacturer() {
	return this.manufacturer;
  }  
  public String getModel() {
	return this.model;
  }
  public int getId() {
	return this.id;
  }
  public int getMiles() {
    return this.miles;
  }
  public int getPrice() {
    return this.price;
  }
  
  public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
  }  
  public void setModel(String model) {
	this.model = model;
  }
  public void setId(int id) {
	this.id = id;
  }
  public void setMiles(int miles) {
    this.miles = miles;
  }
  public void setPrice(int price) {
    this.price = price;
  }
}