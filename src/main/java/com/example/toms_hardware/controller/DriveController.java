package com.example.toms_hardware.controller;

import com.example.toms_hardware.model.Drive;
import com.example.toms_hardware.service.DriveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
@RequestMapping("api/v1/drive")
@RestController
public class DriveController {

    private final DriveService driveService;

    @Autowired
    public DriveController(DriveService driveService) {
        this.driveService = driveService;
    }

    @PostMapping
    public void addDrive(@Valid @NonNull @RequestBody Drive drive) {
        driveService.addDrive(drive);
    }

    @GetMapping
    public List<Drive> getAllDrives() {
        return driveService.selectAllDrives();
    }

    @GetMapping(path = "{id}")
    public Drive getDriveById(@PathVariable("id") UUID id) {
        return driveService.selectDriveById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateDriveById(@PathVariable("id") UUID id,
                                @Valid @NonNull @RequestBody Drive drive) {
        driveService.updateDriveById(id, drive);
    }

    @DeleteMapping(path = "{id}")
    public void deleteDriveById(@PathVariable("id") UUID id) {
        driveService.deleteDriveById(id);
    }

}