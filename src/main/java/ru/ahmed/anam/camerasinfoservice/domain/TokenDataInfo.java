package ru.ahmed.anam.camerasinfoservice.domain;

import lombok.Data;

@Data
public class TokenDataInfo {
    private String value;
    private Long ttl;
}
