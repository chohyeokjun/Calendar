package com.example.calender.repository;

import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;

import java.util.List;

public interface ScheduleRepository{

    Schedule saveSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules ();

    Schedule findScheduleById(Long id);
}
