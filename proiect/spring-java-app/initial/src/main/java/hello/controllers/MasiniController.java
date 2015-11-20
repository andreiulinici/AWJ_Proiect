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
public class MasiniController {
	private List<Masini> masini = new ArrayList<Masini>();

	MasiniController() {
		Masini m1 = new Masini(1, "Koenigsegg",2009);	// Prefer aceasta indentare, cu tab
		Masini m2 = new Masini(2, "Pagani",2010);
		Masini m3 = new Masini(3, "Bugatti",2008);
		Masini m4 = new Masini(4, "Ferrari",2012);
		
		masini.add(m1);
		masini.add(m2);
		masini.add(m3);
		masini.add(m4);
	}

	@RequestMapping(value="/masini", method = RequestMethod.GET)
	public List<Masini> index() {
		return this.masini;
	}
  
	@RequestMapping(value="/masini/{id}", method = RequestMethod.GET)
	public ResponseEntity show(@PathVariable("id") int id) {
		for(Masini p : this.masini) {
			if(p.getId() == id) {
				return new ResponseEntity<Masini>(p, new HttpHeaders(), HttpStatus.OK);
		}
    }
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
  
	@RequestMapping(value="/masini/{id}/{marca}/{an}", method = RequestMethod.POST)
	public List<Masini> create(@PathVariable(value="id") int id,@PathVariable(value="marca") String marca,@PathVariable(value="an") int an) {
		Masini p = new Masini (id, marca, an);
		masini.add(p);
		return this.masini;
	}
  
	@RequestMapping(value="masini/{id}",method = RequestMethod.PUT)
	public ResponseEntity update(@PathVariable("id") int id) {
		for(Masini p : this.masini){
			if(p.getId() == id) {
				p.setId(id);
				p.setMarca("Marca implicita");
				p.setAn(2015);
				return new ResponseEntity<Masini>(p,new HttpHeaders(), HttpStatus.OK);
		}
	}
	return new ResponseEntity<String>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="/masini/{id}", method = RequestMethod.DELETE)
	public ResponseEntity remove(@PathVariable("id") int id) {
		for(Masini p : this.masini) {
			if(p.getId() == id) {
				this.masini.remove(p);
				return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}


}