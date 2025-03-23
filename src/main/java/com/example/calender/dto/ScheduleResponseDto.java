package com.example.calender.dto;

import com.example.calender.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String todo;
    private String name;
    private LocalDate date;

    public ScheduleResponseDto (Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.todo = schedule.getTodo();
        this.name = schedule.getName();
        this.date = LocalDate.now();
    }
}
