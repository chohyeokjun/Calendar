package com.example.calender.repository;

import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;

import java.util.List;

public interface ScheduleRepository{

    ScheduleResponseDto saveSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules ();

    Schedule findScheduleByIdOrElseThrow(Long id);

    int updateSchedule(Long id, String todo, String name);

    int deleteSchedule(Long id);
}
