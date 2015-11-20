package hello;

import java.util.List;
import java.util.ArrayList;

public class Persoana {
  private String nume;
  private int id;
  private int varsta;

  public Persoana() {}

  public Persoana(int id, String nume, int varsta) {
    this.nume = nume;
    this.id = id;
	this.varsta = varsta;
  }

  public String Nume() {
    return this.nume;
  }
  public int getId() {
    return this.id;
  }
  public int getVarsta(){
	return this.varsta;
  }
  
  public void setNume(String nume) {
    this.nume = nume;
  }
  public void setId(int id) {
    this.id = id;
  }
  public void setVarsta(int varsta){
	this.varsta = varsta;
  }
}