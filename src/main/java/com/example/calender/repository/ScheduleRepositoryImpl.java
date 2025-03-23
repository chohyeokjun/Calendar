package com.example.calender.repository;

import com.example.calender.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
}
