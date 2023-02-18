package com.example.toms_hardware.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
public class Drive {

    @JsonProperty
    @Getter
    private final UUID id;

    @JsonProperty
    @Getter
    @NotBlank
    private final String name;

    @JsonProperty
    @Getter
    private final StorageType storageType;

    @JsonProperty
    @Getter
    @Positive
    private final int size;

    @JsonProperty
    @Getter
    @Positive
    private final int speed;

    @SuppressWarnings("unused")
    private enum StorageType {
        HDD,
        SSD
    }
}
