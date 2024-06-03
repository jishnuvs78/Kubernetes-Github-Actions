package com.camel.repository;

import com.camel.model.Payload;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayloadRepository extends CrudRepository<Payload,Long> {
}
