package com.example.calender.service;

import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    // 일정 등록
    ScheduleResponseDto saveSchedule (ScheduleRequestDto dto);

    // 일정 전체 조회
    List<ScheduleResponseDto> findAllSchedule ();

    // 일정 단건 조회
    ScheduleResponseDto findScheduleById(Long id);

    // 일정 수정
    ScheduleResponseDto updateSchedule(Long id, String todo, String name, String password);

    // 일정 삭제
    void deleteSchedule(Long id);
}
