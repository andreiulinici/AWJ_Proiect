package hello;

import java.util.List;
import java.util.ArrayList;

public class Persoana {
  private int id;
  private String nume;
  private int varsta;

  public Persoana() {}

  public Persoana(int id, String nume, int varsta) {
    this.id = id;
	this.nume = nume;
	this.varsta = varsta;
  }

  public int getId() {
    return this.id;
  }
  public String getNume() {
    return this.nume;
  }
  public int getVarsta(){
	return this.varsta;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public void setNume(String nume) {
    this.nume = nume;
  }
  
  public void setVarsta(int varsta){
	this.varsta = varsta;
  }
}