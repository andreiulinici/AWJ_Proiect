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
public class PersoanaController {
  private List<Persoana> persoane = new ArrayList<Persoana>();

  PersoanaController() {
    Persoana p1 = new Persoana(1, "Sam", 21);
    Persoana p2 = new Persoana(2, "Robert", 22);
    Persoana p3 = new Persoana(3, "Paul", 23);

    persoane.add(p1);
    persoane.add(p2);
    persoane.add(p3);
  }

  @RequestMapping(value="/persoane", method = RequestMethod.GET)
  public List<Persoana> index() {
    return this.persoane;
  }
  
  @RequestMapping(value="persoane/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Persoana p : this.persoane) {
      if(p.getId() == id) {
        return new ResponseEntity<Persoana>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }  
    
  @RequestMapping(value="/persoane/{id}/{nume}/{varsta}", method = RequestMethod.POST)
  public List<Persoana> create(@PathVariable(value="id") int id,@PathVariable(value="nume") String nume,@PathVariable(value="varsta") int varsta) {
	//Persoana p = new Persoana(4, "Andrew", 24);
	Persoana p = new Persoana(id, nume, varsta);
	persoane.add(p);
	return this.persoane;
  }
	
  @RequestMapping(value="/persoane/{id}",method = RequestMethod.PUT)
	public ResponseEntity update(@PathVariable("id") int id) {
	  for(Persoana p : this.persoane){
		if(p.getId() == id) {
		  p.setId(id);
		  p.setNume("Andrew");
		  p.setVarsta(21);
		  return new ResponseEntity<Persoana>(p, new HttpHeaders(), HttpStatus.OK);
		}
	}
	return new ResponseEntity<String>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/persoane/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Persoana p : this.persoane) {
      if(p.getId() == id) {
        this.persoane.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}