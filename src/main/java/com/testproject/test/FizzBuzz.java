package com.testproject.test;

import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzz {
    private final AtomicLong counter = new AtomicLong();
    
	@RequestMapping(value="/fizzbuzz/{min}/{max}", method= RequestMethod.GET)
	public Response fizzbuzz(@PathVariable("min") int min, @PathVariable("max") int max){
	if(min>=max) throw new IllegalArgumentException("Parametros invalidos");
	String[] list = new String[Math.abs(min - max) + 1];
	String description;
	Boolean m3 = false , m5 = false;
	for(int i = min; i <= max; ++i) {
		if(i%3==0 && i%5==0) {
			list[i-min] = "FizzBuzz";
			m3 = m5 = true;
		}else if(i%3 == 0) {
			list[i-min] = "Fizz";
			m3=true;
		}else if(i%5==0) {
			list[i-min]= "Buzz";
			m5=true;
		}else {
			list[i-min]= ""+i;
		}
	}
	if(m3 || m5) {
		description = "Se encontraron multiplos de " + (m3&&m5 ? "3 y 5" : (m3? 3 : 5));
	}else {
		description = "No se encontraron multiplos";
	}
	return new Response(counter.incrementAndGet(),description,list);
	}
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(IllegalArgumentException ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase(),ex.toString(),request.getRequestURI());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }
}
