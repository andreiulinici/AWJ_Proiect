package hello;

import java.util.List;
import java.util.ArrayList;

public class Masina {
  private String marca;
  private String model;
  private int id;
  private int an;
  private int kilometri;
  private int pret;

  public Masina() {}

  public Masina(int id, String marca, String model, int an, int kilometri, int pret) {
    this.marca = marca;
	this.model = model;
    this.id = id;
	this.an = an;
    this.kilometri = kilometri;
	this.pret = pret;

  }

  public String getMarca() {
	return this.marca;
  }  
  public String getModel() {
	return this.model;
  }
  public int getId() {
	return this.id;
  }
  public int getAn() {
	return this.an;
  }
  public int getKilometri() {
    return this.kilometri;
  }
  public int getPret() {
    return this.pret;
  }
  
  public void setMarca(String marca) {
	this.marca = marca;
  }  
  public void setModel(String model) {
	this.model = model;
  }
  public void setId(int id) {
	this.id = id;
  }
  public void setAn(int an) {
	this.an = an;
  }
  public void setKilometri(int kilometri) {
    this.kilometri = kilometri;
  }
  public void setPret(int pret) {
    this.pret = pret;
  }
}