package com.example.calender.repository;

import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository{
    private final Map<Long, Schedule> scheduleMap = new HashMap<>();

    @Override
    public Schedule saveSchedule(Schedule schedule) {

        Long ScheduleId = scheduleMap.isEmpty() ? 1 : Collections.max(scheduleMap.keySet()) + 1;
        schedule.setId(ScheduleId);

        scheduleMap.put(ScheduleId, schedule);
        return schedule;
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        List<ScheduleResponseDto> allSchedules = new ArrayList<>();
        for (Schedule schedule : scheduleMap.values()) {
            ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
            allSchedules.add(scheduleResponseDto);
        }
        return allSchedules;
    }

    @Override
    public Schedule findScheduleById(Long id) {
        return scheduleMap.get(id);
    }
}
