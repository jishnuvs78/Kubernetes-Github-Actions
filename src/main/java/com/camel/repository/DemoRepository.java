package com.camel.repository;

import com.camel.model.Demo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends CrudRepository<Demo,Integer> {
}
