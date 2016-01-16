package hello;

import java.util.List;
import java.util.ArrayList;

public class Telefon {
  private int id;
  private String marca;
  private String culoare;
  private int an;
  private int pret;

  public Telefon() {}

  public Telefon(int id, String marca, String culoare, int an, int pret) {
    this.id = id;
	this.marca = marca;
	this.culoare = culoare;
    this.an = an;
	this.pret = pret;

  }

  public int getId() {
    return this.id;
  }
  public String getMarca() {
    return this.marca;
  }
  public String getCuloare() {
    return this.culoare;
  }
  public int getAn() {
    return this.an;
  }
  public int getPret() {
    return this.pret;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  public void setMarca(String marca) {
	this.marca = marca;
  }
  public void setCuloare(String culoare) {
    this.culoare = culoare;
  }
  public void setAn(int an) {
    this.an = an;
  }
  public void setPret(int pret) {
    this.pret = pret;
  }
}