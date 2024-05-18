package com.playground.simpletodoredis.service;

import com.playground.simpletodoredis.model.Items;
import com.playground.simpletodoredis.repository.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemsService {

    @Autowired
    private ItemsRepository REPO;

    public void addItem(Items item) {
        REPO.save(item);
    }

    public List<Items> getAll() {
        return REPO.findAll();
    }

}
