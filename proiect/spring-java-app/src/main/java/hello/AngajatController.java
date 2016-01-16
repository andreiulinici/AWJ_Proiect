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
public class AngajatController {
	private List<Angajat> angajat = new ArrayList<Angajat>();

	AngajatController() {
		Angajat a1 = new Angajat(1, "Popescu Marius",2007);
		Angajat a2 = new Angajat(2, "Popescu Ana",2008);
		Angajat a3 = new Angajat(3, "Stefanescu Mihai",2009);
		
		angajat.add(a1);
		angajat.add(a2);	
		angajat.add(a3);
	}

	@RequestMapping(value="/angajat", method = RequestMethod.GET)
	public List<Angajat> index() {
		return this.angajat;
	}
  
	@RequestMapping(value="/angajat/{id}", method = RequestMethod.GET)
	public ResponseEntity show(@PathVariable("id") int id) {
		for(Angajat p : this.angajat) {
			if(p.getId() == id) {
				return new ResponseEntity<Angajat>(p, new HttpHeaders(), HttpStatus.OK);
			}
		}
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
  
	@RequestMapping(value="/angajat/{id}/{nume}/{an}", method = RequestMethod.POST)
	public List<Angajat> create(@PathVariable(value="id") int id,@PathVariable(value="nume") String nume,@PathVariable(value="an") int an) {
		Angajat p = new Angajat (id, nume, an);
		angajat.add(p);
		return this.angajat;
	}
  
	@RequestMapping(value="/angajat/{id}", method = RequestMethod.PUT)
	public ResponseEntity update(@PathVariable("id") int id) {
		for(Angajat p : this.angajat){
			if(p.getId() == id) {				
				p.setNume("Nume default");
				p.setId(id);
				p.setAn(2015);	
				return new ResponseEntity<Angajat>(p, new HttpHeaders(), HttpStatus.OK);
			}
		}
	return new ResponseEntity<String>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="/angajat/{id}", method = RequestMethod.DELETE)
	public ResponseEntity remove(@PathVariable("id") int id) {
		for(Angajat p : this.angajat) {
			if(p.getId() == id) {
				this.angajat.remove(p);
				return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}


}