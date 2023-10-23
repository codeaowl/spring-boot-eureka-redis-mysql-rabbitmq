package com.microservice.producermicroservice;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	@Autowired
	private RabbitMessagingTemplate rabbitMessagingTemplate;

	@Autowired
	private MappingJackson2MessageConverter mappingJackson2MessageConverter;

	public String publishProductMessage(Product product) {
		this.rabbitMessagingTemplate.setMessageConverter(this.mappingJackson2MessageConverter);
		this.rabbitMessagingTemplate.convertAndSend(ProducerMicroserviceApplication.PRODUCT_EXCHANGE, ProducerMicroserviceApplication.PRODUCT_ROUTING_KEY,product);
		return "Product Message Published";
	}
}
