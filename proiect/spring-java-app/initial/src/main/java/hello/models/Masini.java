package hello;

import java.util.List;
import java.util.ArrayList;

public class Masini {
  private String marca;
  private int id;
  private int an;

  public Masini() {}

  public Masini(int id, String marca,int an) {
    this.marca = marca;
    this.id = id;
    this.an=an;

  }

  public String getMarca() {
    return this.marca;
  }
  public int getId() {
    return this.id;
  }
  public int getAn() {
    return this.an;
  }
  
  public void setMarca(String marca) {
	this.marca = marca;
  }
  public void setId(int id) {
    this.id = id;
  }
  public void setAn(int an) {
    this.an = an;
  }
}