package hello;

import java.util.List;
import java.util.ArrayList;

public class Angajat {
  private String nume;
  private int id;
  private int an;

  public Angajat() {}

  public Angajat(int id, String nume, int an) {
    this.nume = nume;
    this.id = id;
    this.an = an;
  }

  public String getNume() {
	return this.nume;
  }

  public int getId() {
	return this.id;
  }
  public int getAn() {
    return this.an;
  }
  
  public void setNume(String nume) {
	this.nume = nume;
  }
	  
  public void setId(int id) {
	this.id = id;
  }
  public void setAn(int an) {
	this.an = an;
  }
  
}