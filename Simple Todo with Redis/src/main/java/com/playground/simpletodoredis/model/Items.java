package com.playground.simpletodoredis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "items")
public class Items {
    @Id
    @Column(nullable = false)
    private Integer uid;
    @Column(nullable = false)
    private String task;

    public Items() {

    }

    public Items(Integer uid, String task) {
        this.uid = uid;
        this.task = task;
    }

    public Integer UID() {
        return uid;
    }

    public String task() {
        return task;
    }

    public void setUid(Integer UID) {
        this.uid = UID;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Items items)) return false;
        return Objects.equals(task, items.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task);
    }

    @Override
    public String toString() {
        return "Items{" +
                "UID=" + uid +
                ", task='" + task + '\'' +
                '}';
    }
}
