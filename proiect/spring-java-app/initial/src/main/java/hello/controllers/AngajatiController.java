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
public class AngajatiController {
	private List<Angajati> angajati = new ArrayList<Angajati>();

	AngajatiController() {
		Angajati a1 = new Angajati(1, "Popescu Marius",2007);
		Angajati a2 = new Angajati(2, "Popescu Ana",2008);
		Angajati a3 = new Angajati(3, "Stefanescu Mihai",2009);
		angajati.add(a1);
		angajati.add(a2);	
		angajati.add(a3);
	}

	@RequestMapping(value="/angajati", method = RequestMethod.GET)
	public List<Angajati> index() {
		return this.angajati;
	}
  
	@RequestMapping(value="/angajati/{id}", method = RequestMethod.GET)
	public ResponseEntity show(@PathVariable("id") int id) {
		for(Angajati p : this.angajati) {
			if(p.getId() == id) {
				return new ResponseEntity<Angajati>(p, new HttpHeaders(), HttpStatus.OK);
		}
    }
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
  
	@RequestMapping(value="/angajati/{id}/{nume}/{an}", method = RequestMethod.POST)
	public List<Angajati> create(@PathVariable(value="id") int id,@PathVariable(value="nume") String nume,@PathVariable(value="an") int an) {
		Angajati p = new Angajati (id, nume, an);
		angajati.add(p);
		return this.angajati;
	}
  
	@RequestMapping(value="angajati/{id}",method = RequestMethod.PUT)
	public ResponseEntity update(@PathVariable("id") int id) {
		for(Angajati p : this.angajati){
			if(p.getId() == id) {
				return new ResponseEntity<Angajati>(p,new HttpHeaders(), HttpStatus.OK);
		}
	}
	return new ResponseEntity<String>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="/angajati/{id}", method = RequestMethod.DELETE)
	public ResponseEntity remove(@PathVariable("id") int id) {
		for(Angajati p : this.angajati) {
			if(p.getId() == id) {
				this.angajati.remove(p);
				return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}


}