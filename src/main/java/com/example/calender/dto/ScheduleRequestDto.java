package com.example.calender.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    @NotNull(message = "제목은 필수입니다.")
    private String title;
    private String todo;
    @NotNull(message = "작성자명은 필수입니다.")
    private String name;
    private String password;
}
