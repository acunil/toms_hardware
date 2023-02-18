package com.example.toms_hardware.repo;

import com.example.toms_hardware.model.Drive;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DriveDao {

    int addDrive(UUID id, Drive drive);

    default int addDrive(Drive drive) {
        UUID id = UUID.randomUUID();
        return addDrive(id, drive);
    }

    List<Drive> selectAllDrives();

    Optional<Drive> selectDriveById(UUID id);

    int updateDriveById(UUID id, Drive drive);

    int deleteDriveById(UUID id);

}