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
public class MasinaController {
	private List<Masina> masina = new ArrayList<Masina>();

	MasinaController() {
		Masina c1 = new Masina(1, "Bentley", "Continental", 2010, 2500, 90000);
		Masina c2 = new Masina(2, "Range Rover", "Evoque", 2012, 1550, 68000);
		Masina c3 = new Masina(3, "Ferrari", "LaFerrari", 2015, 4000, 145000);
		
		masina.add(c1);
		masina.add(c2);
		masina.add(c3);
	}

	@RequestMapping(value="/masina", method = RequestMethod.GET)
	public List<Masina> index() {
		return this.masina;
	}
  
	@RequestMapping(value="/masina/{id}", method = RequestMethod.GET)
	public ResponseEntity show(@PathVariable("id") int id) {
		for(Masina p : this.masina) {
			if(p.getId() == id) {
				return new ResponseEntity<Masina>(p, new HttpHeaders(), HttpStatus.OK);
		}
    }
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
  
	@RequestMapping(value="/masina/{id}/{marca}/{model}/{an}/{kilometri}/{pret}", method = RequestMethod.POST)
	public List<Masina> create(@PathVariable(value="id") int id,@PathVariable(value="marca") String marca,@PathVariable(value="model") String model,@PathVariable(value="an") int an,@PathVariable(value="kilometri") int kilometri,@PathVariable(value="pret") int pret) {
		Masina p = new Masina (id, marca, model, an, kilometri, pret);
		masina.add(p);
		return this.masina;
	}
  
	@RequestMapping(value="/masina/{id}",method = RequestMethod.PUT)
	public ResponseEntity update(@PathVariable("id") int id) {
		for(Masina p : this.masina){
			if(p.getId() == id) {
				p.setId(id);
				p.setMarca("Default Marca");
				p.setModel("Default Model");
				p.setAn(2008);
				p.setKilometri(0);
				p.setPret(0);
				return new ResponseEntity<Masina>(p,new HttpHeaders(), HttpStatus.OK);
		}
	}
	return new ResponseEntity<String>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="/masina/{id}", method = RequestMethod.DELETE)
	public ResponseEntity remove(@PathVariable("id") int id) {
		for(Masina p : this.masina) {
			if(p.getId() == id) {
				this.masina.remove(p);
				return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}