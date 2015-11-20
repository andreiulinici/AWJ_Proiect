package hello;

import java.util.List;
import java.util.ArrayList;

public class Telefon {
  private String marca;
  private String culoare;
  private int id;
  private int an;
  private int pret;

  public Telefon() {}

  public Telefon(int id, String marca, String culoare, int an, int pret) {
    this.marca = marca;
	this.culoare = culoare;
    this.id = id;
    this.an = an;
	this.pret = pret;

  }

  public String getName() {
    return this.marca;
  }
  public String getCuloare() {
    return this.culoare;
  }
  public int getId() {
    return this.id;
  }
  public int getAn() {
    return this.an;
  }
  public int getPret() {
    return this.pret;
  }
}