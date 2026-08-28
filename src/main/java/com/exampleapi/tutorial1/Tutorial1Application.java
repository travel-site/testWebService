package com.exampleapi.tutorial1;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@SpringBootApplication
@RestController
public class Tutorial1Application {
	public static void main(String[] args) {
		SpringApplication.run(Tutorial1Application.class, args);
	}
	private static HashMap<String,Product> productRepo=new HashMap<>();
	private static String[] tab={"Alex","Leo","Ben"};
	static{
		for(int i=0;i<=2;i++){
	Product product=new Product();
	product.setId(Integer.toString(i));
	product.setName(tab[i]);
    productRepo.put(product.getId(),product);}
	}
	
@RequestMapping(value = "/products",method =RequestMethod.GET)
public ResponseEntity<Object> getAllProducts(){
return new ResponseEntity<Object>(productRepo.values(),HttpStatus.OK);
}
@RequestMapping(value = "/products",method = RequestMethod.POST)
public ResponseEntity<Object> postProduct(@RequestBody Product product){
	productRepo.put(product.getId(), product);
return new ResponseEntity<Object>("The object is created successfully !",HttpStatus.CREATED);
}
@RequestMapping(value = "/products/{id}",method = RequestMethod.PUT)
public ResponseEntity<Object> putProduct(@PathVariable("id") String id,@RequestBody Product product){
	productRepo.remove(id);
	productRepo.put(product.getId(), product);
return new ResponseEntity<Object>("The object is updated successfully !",HttpStatus.OK);
}
@RequestMapping(value = "/products/{id}",method = RequestMethod.DELETE)
public ResponseEntity<Object> putProduct(@PathVariable("id") String id)throws Exception{
	if (!productRepo.containsKey(id)) {
		throw new productNotFoundException();
	}
	productRepo.remove(id);
return new ResponseEntity<Object>("The object is deleted successfully !",HttpStatus.OK);
}
}
