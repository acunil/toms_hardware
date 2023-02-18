package com.example.toms_hardware.repo;

import com.example.toms_hardware.model.Drive;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("unused")
@Repository("fakeDao")
public class FakeDriveDataAccessService implements DriveDao {

    private static List<Drive> DB = new ArrayList<>();

    @Override
    public int addDrive(UUID id, Drive drive) {
        DB.add(new Drive(id, drive.getName(), drive.getStorageType(), drive.getSize(), drive.getSpeed()));
        return 1;
    }

    @Override
    public List<Drive> selectAllDrives() {
        return DB;
    }

    @Override
    public Optional<Drive> selectDriveById(UUID id) {
        return DB.stream()
            .filter(drive -> id.equals(drive.getId()))
            .findFirst();
    }

    @Override
    public int updateDriveById(UUID id, Drive updated) {
        return selectDriveById(id)
            .map(existingDrive -> {
                int indexOfDriveToUpdate = DB.indexOf(existingDrive);
                if (indexOfDriveToUpdate >= 0) {
                    DB.set(indexOfDriveToUpdate,
                        new Drive(id,
                            updated.getName(),
                            updated.getStorageType(),
                            updated.getSize(),
                            updated.getSpeed()));
                    return 1;
                } else {
                    return 0;
                }
            })
            .orElse(0);
    }

    @Override
    public int deleteDriveById(UUID id) {
        Optional<Drive> driveMaybe = selectDriveById(id);
        if (driveMaybe.isEmpty()) {
            return 0;
        } else {
            DB.remove(driveMaybe.get());
            return 1;
        }
    }
}
