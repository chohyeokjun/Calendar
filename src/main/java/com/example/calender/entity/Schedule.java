package com.example.calender.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Schedule {
    @Setter
    private Long id;
    private String title;
    private String todo;
    private String name;
    private Long password;

    public Schedule (String title, String todo, String name, Long password) {
        this.title = title;
        this.todo = todo;
        this.name = name;
        this.password = password;
    }

}
