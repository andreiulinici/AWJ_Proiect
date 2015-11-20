package hello;

import java.util.List;
import java.util.ArrayList;

public class Persoana {
  private String name;
  private int id;
  private int age;

  public Persoana() {}

  public Persoana(int id, String name, int age) {
      this.name = name;
      this.id = id;
	  this.age = age;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }
  
  public int getAge(){
	  return this.age;
  }
}