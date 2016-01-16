package hello;

import java.util.List;
import java.util.ArrayList;

public class Angajat {
  private int id;
  private String nume;
  private int an;

  public Angajat() {}

  public Angajat(int id, String nume, int an) {
    this.id = id;
	this.nume = nume;
    this.an = an;
  }


  public int getId() {
	return this.id;
  }
  public String getNume() {
	return this.nume;
  }
  public int getAn() {
    return this.an;
  }
	  
  public void setId(int id) {
	this.id = id;
  }
  public void setNume(String nume) {
	this.nume = nume;
  }
  public void setAn(int an) {
	this.an = an;
  }
  
}