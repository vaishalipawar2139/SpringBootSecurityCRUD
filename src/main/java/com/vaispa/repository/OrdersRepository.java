package com.vaispa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vaispa.model.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {

}
