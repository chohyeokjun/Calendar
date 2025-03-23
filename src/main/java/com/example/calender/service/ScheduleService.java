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
}
