package com.study.controller;

import com.study.apiPayload.ApiResponse;
import com.study.converter.MissionConverter;
import com.study.domain.Mission;
import com.study.dto.request.MissionRequestDTO;
import com.study.dto.response.MissionResponseDTO;
import com.study.service.MissionService.MissionCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
}
