package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class TelefonController {
  private List<Telefon> telefon = new ArrayList<Telefon>();

  TelefonController() {
	Telefon t1 = new Telefon(1, "Iphone 6", "gri", 2015, 3200);
	Telefon t2 = new Telefon(2, "Samsung Edge", "alb", 2015, 2900);
	Telefon t3 = new Telefon(3, "LG G4", "rosu", 2014, 2100);
	
	telefon.add(t1);
	telefon.add(t2);
	telefon.add(t3);
  }

  @RequestMapping(value="/telefon", method = RequestMethod.GET)
  public List<Telefon> index() {
	  return this.telefon;
	}
  
  @RequestMapping(value="/telefon/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
	for(Telefon p : this.telefon) {
	  if(p.getId() == id) {
		return new ResponseEntity<Telefon>(p, new HttpHeaders(), HttpStatus.OK);
	  }
	}
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/telefon/{id}/{marca}/{culoare}/{an}/{pret}", method = RequestMethod.POST)
  public List<Telefon> create(@PathVariable(value="id") int id,@PathVariable(value="marca") String marca,@PathVariable(value="culoare") String culoare,@PathVariable(value="an") int an,@PathVariable(value="pret") int pret) {
	Telefon p = new Telefon (id, marca, culoare, an, pret);
	telefon.add(p);
	return this.telefon;
  }
	// exemplu POST ->  localhost:8080/telefon/4/Iphone 6+/gri/2015/2800
  
  @RequestMapping(value="telefon/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id) {
	for(Telefon p : this.telefon) {
	  if(p.getId() == id) {
		p.setId(id);
		p.setMarca("Marca implicita");
		p.setCuloare("Culoare implicita");
		p.setAn(2015);
		p.setPret(0);
		return new ResponseEntity<Telefon>(p, new HttpHeaders(), HttpStatus.OK);
	  }
	}
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/telefon/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
	for(Telefon p : this.telefon) {
	  if(p.getId() == id) {
		this.telefon.remove(p);
		return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
	  }
	}
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

}