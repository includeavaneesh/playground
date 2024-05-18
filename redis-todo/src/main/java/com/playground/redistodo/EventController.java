package com.playground.redistodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController {

    @Autowired
    private EventService EVENT_SERVICE;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Event event) {
        int size = EVENT_SERVICE.getAllTasks().size() - 1;
        int newUid = EVENT_SERVICE.getAllTasks().get(size).getUid() + 1;
        event.setUid(newUid);
        return ResponseEntity.ok().body(EVENT_SERVICE.addTask(event));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(EVENT_SERVICE.getAllTasks());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Event event) {
        return ResponseEntity.ok().body(EVENT_SERVICE.deleteTask(event));
    }

    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody Event event) {
        return ResponseEntity.ok().body(EVENT_SERVICE.updateTask(event));
    }
}
