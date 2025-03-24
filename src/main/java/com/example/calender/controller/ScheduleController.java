package com.example.calender.controller;


import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 일정 등록
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule (@RequestBody ScheduleRequestDto dto) {
        return new ResponseEntity<>(scheduleService.saveSchedule(dto), HttpStatus.CREATED);
    }

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule() {
        List<ScheduleResponseDto> schedules = scheduleService.findAllSchedule();
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    // 일정 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);
    }

    // 일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto dto) {
        return new ResponseEntity<>(scheduleService.updateSchedule(id, dto.getTodo(), dto.getName(), dto.getPassword()), HttpStatus.OK);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
