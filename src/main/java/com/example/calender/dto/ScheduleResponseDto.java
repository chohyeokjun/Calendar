package com.example.calender.dto;

import com.example.calender.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String todo;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;

    public ScheduleResponseDto (Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.todo = schedule.getTodo();
        this.name = schedule.getName();
        this.createDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }
}
