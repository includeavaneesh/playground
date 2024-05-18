package com.playground.redistodo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todo")
@Getter
@Setter
public class Event {

    @Id
    @Column(name = "uid", nullable = false)
    private int uid;

    @Column(nullable = false)
    private String task;
    @Column(nullable = false)
    private boolean iscompleted;
    @Column(nullable = false)
    private String assignedto;

    public Event() {

    }
    public Event(int uid, String task, boolean isCompleted, String assignedTo) {
        this.uid = uid;
        this.task = task;
        this.iscompleted = isCompleted;
        this.assignedto = assignedTo;
    }

    @Override
    public String toString() {
        return "Event{" +
                "uid=" + uid +
                ", task='" + task + '\'' +
                ", isCompleted=" + iscompleted +
                ", assignedTo='" + assignedto + '\'' +
                '}';
    }
}
