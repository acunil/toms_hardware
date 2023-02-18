package com.example.toms_hardware.service;

import com.example.toms_hardware.model.Drive;
import com.example.toms_hardware.repo.DriveDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DriveService {

    private final DriveDao driveDao;

    public DriveService(@Qualifier("fakeDao") DriveDao driveDao) {
        this.driveDao = driveDao;
    }

    public int addDrive(Drive drive) {
        return driveDao.addDrive(drive);
    }

    public List<Drive> selectAllDrives() {
        return driveDao.selectAllDrives();
    }

    public Optional<Drive> selectDriveById(UUID id) {
        return driveDao.selectDriveById(id);
    }

    public int updateDriveById(UUID id, Drive drive) {
        return driveDao.updateDriveById(id, drive);
    }

    public int deleteDriveById(UUID id) {
        return driveDao.deleteDriveById(id);
    }
}
