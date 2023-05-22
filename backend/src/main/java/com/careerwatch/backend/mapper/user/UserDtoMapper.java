package com.careerwatch.backend.mapper.user;

import com.careerwatch.backend.dto.application.ApplicationDto;
import com.careerwatch.backend.dto.application.StageDto;
import com.careerwatch.backend.dto.resume.ResumeDto;
import com.careerwatch.backend.dto.user.UserDto;
import com.careerwatch.backend.entity.User;
import com.careerwatch.backend.mapper.application.ApplicationDtoMapper;
import com.careerwatch.backend.mapper.application.StageDtoMapper;
import com.careerwatch.backend.mapper.resume.ResumeDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDtoMapper {
    private ResumeDtoMapper resumeDtoMapper;
    private StageDtoMapper stageDtoMapper;
    private ApplicationDtoMapper applicationDtoMapper;
    public UserDto entityToDto(User user){

        List<ResumeDto> resumeDtoList = user.getResumes()
                .stream().map(
                        resumeDtoMapper::entityToDto)
                .toList();

        List<StageDto> stageDtoList = user.getStages()
                .stream().map(
                        stageDtoMapper::entityToDto)
                .toList();

        List<ApplicationDto> applicationsDtoList = user.getApplications()
                .stream().map(
                        applicationDtoMapper::entityToDto)
                .toList();

        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .clientSince(user.getClientSince())
                .profileImage(user.getProfileImage())
                .resumes(resumeDtoList)
                .stages(stageDtoList)
                .applications(applicationsDtoList)
                .build();
    }
}