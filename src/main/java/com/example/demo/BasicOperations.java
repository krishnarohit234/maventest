package com.example.demo;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class BasicOperations  implements CommandLineRunner{
	
	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String...args)throws Exception{
		repo.save(new Product("PENCIAL", 5.8, "RED"));
		repo.save(new Product("MOBILE", 5000.8, "BLACK"));
		repo.save(new Product("LAPTOP", 2000.8, "GRAY"));
	

		//2.1 method.
		Optional<Product> p = repo.findById(3);
		if(p.isPresent())
		 {
		System.out.println(p.get());
		} else {
		System.out.println("No Data found");
		}
		//2.2 Method.
		repo.findAll().forEach((System.out::println));
		/*3. *****************Delete****************/
		//3.1 Delete by specific Id
		repo.deleteById(3);
		//3.2 Delete all Rows one by one in (Sequence order)
		repo.deleteAll(); //Multiple Query fired No of record = no of Query
		//3.3 Delete all rows in Batch (Single Query fired)
		repo.deleteAllInBatch();
	}

}
