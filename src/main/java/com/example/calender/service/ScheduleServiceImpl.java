package com.example.calender.service;

import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;
import com.example.calender.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {

        Schedule schedule = new Schedule(dto.getTitle(), dto.getTodo(), dto.getName(), dto.getPassword());
        Schedule savedSchedule = scheduleRepository.saveSchedule(schedule);
        return new ScheduleResponseDto(savedSchedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule() {
        return List.of();
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        return null;
    }
}
