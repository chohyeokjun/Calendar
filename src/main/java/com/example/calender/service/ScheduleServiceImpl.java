package com.example.calender.service;

import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;
import com.example.calender.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

        return scheduleRepository.saveSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule() {
        List<ScheduleResponseDto> allSchedules = scheduleRepository.findAllSchedules();
        return allSchedules;
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule scheduleByIdOrElseThrow = scheduleRepository.findScheduleByIdOrElseThrow(id);

        return new ScheduleResponseDto(scheduleByIdOrElseThrow);
    }


    @Transactional
    @Override
    public ScheduleResponseDto updateSchedule(Long id, String todo, String name, String password) {


        // 비밀 번호 검증
        if (!scheduleRepository.findScheduleByIdOrElseThrow(id).getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "올바른 비밀번호를 입력하세요.");
        }

        // 일정 수정
        int updatedRow = scheduleRepository.updateSchedule(id, todo, name);

        if (updatedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        // 일정 조회
        Schedule scheduleByIdOrElseThrow = scheduleRepository.findScheduleByIdOrElseThrow(id);

        return new ScheduleResponseDto(scheduleByIdOrElseThrow);
    }

    @Override
    public void deleteSchedule(Long id, String password) {
        if (!scheduleRepository.findScheduleByIdOrElseThrow(id).getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "올바른 비밀번호를 입력하세요.");
        }
        int updatedRow = scheduleRepository.deleteSchedule(id);

        if (updatedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
    }
}
