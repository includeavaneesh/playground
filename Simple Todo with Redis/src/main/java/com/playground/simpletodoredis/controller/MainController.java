package com.playground.simpletodoredis.controller;

import com.playground.simpletodoredis.model.Items;
import com.playground.simpletodoredis.service.ItemsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@Slf4j
public class MainController {

    @Autowired
    private ItemsService ITEM_SERVICE;

    @GetMapping("/getItems")
    public ResponseEntity<?> getAllItems() {
        return ResponseEntity.ok().body(ITEM_SERVICE.getAll());
    }

    @PostMapping("/addItem")
    public ResponseEntity<?> addItem(@RequestBody Items item) {
        Items newItem = new Items();
        newItem.setUid(item.UID());
        newItem.setTask(item.task());
        ITEM_SERVICE.addItem(newItem);
        log.warn(newItem.toString());
        return ResponseEntity.ok().body(ITEM_SERVICE.getAll());

    }

//    @DeleteMapping("/deleteItem")
//    public List<Items> deleteItem(@RequestBody Items item) {
//        ITEM_REPOSITORY.deleteById(item.UID());
//        return ITEM_REPOSITORY.findAll();
//    }
//
//    @PatchMapping("/updateItem")
//    public List<Items> updateItem(@RequestBody Items item) {
//        Items oldItem = ITEM_REPOSITORY.findById(item.UID()).get();
//        oldItem.setTask(item.task());
//        ITEM_REPOSITORY.save(oldItem);
//        return ITEM_REPOSITORY.findAll();
//    }

}
