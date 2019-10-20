package com.vaispa.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaispa.model.Orders;
import com.vaispa.repository.OrdersRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/orders")
public class OrdersController {

	@Autowired
	private OrdersRepository ordersRepository;

	@PostConstruct
	public void initialize() {
		Orders ord1 = new Orders("10001", 10, new Double(1000), "Nokia", "Vaishali Pawar", "Nagpur", "99009990090",
				"vpawar2139@gmail.com", "COD");
		Orders ord2 = new Orders("10002", 5, new Double(5000), "MI", "Anup Mridha", "Hyderabad", "8887777777",
				"anupmridha007@gmail.com", "NET BANKING");

		ordersRepository.save(ord1);
		ordersRepository.save(ord2);
	}

	@GetMapping
	public ResponseEntity<Iterable<Orders>> getOrders() {
		return ResponseEntity.ok(ordersRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Orders> createOrder(@Valid @RequestBody Orders order) {
		Orders createdOrder = order;

		ordersRepository.save(createdOrder);

		return ResponseEntity.ok(createdOrder);
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<Orders> deleteOrder(@PathVariable("id") Integer id) {

		Optional<Orders> order = ordersRepository.findById(id);

		if (!order.isPresent()) {
			ResponseEntity.badRequest().build();
		}

		ordersRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@PutMapping(path = { "/{id}" })
	public ResponseEntity<Orders> updateOrder(@PathVariable("id") Integer id, @Valid @RequestBody Orders orders) {
		Optional<Orders> order = ordersRepository.findById(id);

		if (!order.isPresent()) {
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(ordersRepository.save(orders));

	}
}
