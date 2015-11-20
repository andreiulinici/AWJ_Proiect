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
public class CarsController {
	private List<Cars> cars = new ArrayList<Cars>();

	CarsController() {
		Cars c1 = new Cars(1, "Bentley", "Continental", 2500, 90000);
		Cars c2 = new Cars(2, "Range Rover", "Evoque", 1550, 68000);
		Cars c3 = new Cars(3, "Ferrari", "LaFerrari", 4000, 145000);
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
	}

	@RequestMapping(value="/cars", method = RequestMethod.GET)
	public List<Cars> index() {
		return this.cars;
	}
  
	@RequestMapping(value="/cars/{id}", method = RequestMethod.GET)
	public ResponseEntity show(@PathVariable("id") int id) {
		for(Cars p : this.cars) {
			if(p.getId() == id) {
				return new ResponseEntity<Cars>(p, new HttpHeaders(), HttpStatus.OK);
		}
    }
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
  
	@RequestMapping(value="/cars/{id}/{manufacturer}/{model}/{miles}/{price}", method = RequestMethod.POST)
	public List<Cars> create(@PathVariable(value="id") int id,@PathVariable(value="manufacturer") String manufacturer,@PathVariable(value="model") String model,@PathVariable(value="miles") int miles,@PathVariable(value="price") int price) {
		Cars p = new Cars (id, manufacturer, model, miles, price);
		cars.add(p);
		return this.cars;
	}
  
	@RequestMapping(value="cars/{id}",method = RequestMethod.PUT)
	public ResponseEntity update(@PathVariable("id") int id) {
		for(Cars p : this.cars){
			if(p.getId() == id) {
				return new ResponseEntity<Cars>(p,new HttpHeaders(), HttpStatus.OK);
		}
	}
	return new ResponseEntity<String>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="/cars/{id}", method = RequestMethod.DELETE)
	public ResponseEntity remove(@PathVariable("id") int id) {
		for(Cars p : this.cars) {
			if(p.getId() == id) {
				this.cars.remove(p);
				return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	

}