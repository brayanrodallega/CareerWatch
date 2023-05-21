package com.careerwatch.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    
    private final ProfileService profileService;
    

    @GetMapping
    public ResponseEntity<List<ProfileDto>> getAllProfiles() throws JsonProcessingException {
        return ResponseEntity.ok(profileService.getAllProfiles());
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileDto> getProfileById(@PathVariable Long profileId) throws JsonProcessingException  {
        return ResponseEntity.ok(profileService.getProfileById(profileId));
    }

    @PutMapping("/{profileId}")
    public ResponseEntity<ProfileDto> updateProfile(@PathVariable Long profileId, @ModelAttribute ProfileDto profileDto) throws JsonProcessingException {
        return ResponseEntity.ok(profileService.updateProfile(profileId, profileDto));
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long profileId) throws JsonProcessingException {
        profileService.deleteProfile(profileId);
        return ResponseEntity.noContent().build();
    }
}
