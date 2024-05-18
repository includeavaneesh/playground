package com.playground.simpletodoredis.repository;

import com.playground.simpletodoredis.model.Items;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends ListCrudRepository<Items, Integer> {
}
