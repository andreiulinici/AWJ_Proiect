package hello;

import java.util.List;
import java.util.ArrayList;

public class Angajati {
  private String nume;
  private int id;
  private int an;

  public Angajati() {}

  public Angajati(int id, String nume, int an) {
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
}