package com.microservice.producermicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProducerController {

	@Autowired
	private ProducerService producerService;

	@PostMapping
	public String publishProductMessage(@RequestBody Product product) {
		return producerService.publishProductMessage(product);//View readme
	}

}
