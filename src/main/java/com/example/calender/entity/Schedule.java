package com.example.calender.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String title;
    private String todo;
    private String name;
    private String password;

    public Schedule (String title, String todo, String name, String password) {
        this.title = title;
        this.todo = todo;
        this.name = name;
        this.password = password;
    }

}
