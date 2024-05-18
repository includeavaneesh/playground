package com.playground.redistodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository EVENT_REPOSITORY;

    public List<Event> getAllTasks() {
        return EVENT_REPOSITORY.findAll();
    }

    public List<Event> addTask(Event event) {
        EVENT_REPOSITORY.save(event);
        return EVENT_REPOSITORY.findAll();
    }

    public List<Event> deleteTask(Event event) {
        EVENT_REPOSITORY.delete(event);
        return EVENT_REPOSITORY.findAll();
    }

    public List<Event> updateTask(Event event) {
        EVENT_REPOSITORY.save(event);
        return EVENT_REPOSITORY.findAll();
    }
}
