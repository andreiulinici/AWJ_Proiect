package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // adnotare
public class PersonController {

    private static final String template = "Hello! This is my class content: %s, ";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/person")  // adnotare
    public Person person(@RequestParam(value="name", defaultValue="Prenume") String name)
					//		@RequestParam(value="surname", defaultValue="Nume") String surname,
					//			@RequestParam(value="age", defaultValue="Varsta") int age) 
					{
        return new Person(counter.incrementAndGet(),
                            String.format(template, name));
								//String.format(template, surname),
								//	age)
    }
}
