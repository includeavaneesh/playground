package com.playground.simpletodoredis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "items")
public class Items {
    @Id
    @Column(nullable = false)
    private Integer uid;
    @Setter
    @Column(nullable = false)
    private String task;

    public Items() {
        this(0, null);
    }

    public Items(int uid, String task) {
        this.uid = uid;
        this.task = task;
    }

    public int UID() {
        return this.uid;
    }

    public String task() {
        return this.task;
    }

    public void setUid(int UID) {
        this.uid = UID;
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
