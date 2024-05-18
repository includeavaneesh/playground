package com.playground.simpletodoredis.controller;

import com.playground.simpletodoredis.model.Items;
import com.playground.simpletodoredis.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ItemsRepository ITEM_REPOSITORY;

    @GetMapping("/getItems")
    public List<Items> getAllItems() {
        return ITEM_REPOSITORY.findAll();
    }

    @PostMapping("/addItem")
    public List<Items> addItem(@RequestBody Items item) {
        Items newItem = new Items(item.UID(), item.task());
        ITEM_REPOSITORY.save(newItem);
        return ITEM_REPOSITORY.findAll();
    }

    @DeleteMapping("/deleteItem")
    public List<Items> deleteItem(@RequestBody Items item) {
        ITEM_REPOSITORY.deleteById(item.UID());
        return ITEM_REPOSITORY.findAll();
    }

    @PatchMapping("/updateItem")
    public List<Items> updateItem(@RequestBody Items item) {
        Items oldItem = ITEM_REPOSITORY.findById(item.UID()).get();
        oldItem.setTask(item.task());
        ITEM_REPOSITORY.save(oldItem);
        return ITEM_REPOSITORY.findAll();
    }

}
