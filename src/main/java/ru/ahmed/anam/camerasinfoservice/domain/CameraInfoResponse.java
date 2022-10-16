package ru.ahmed.anam.camerasinfoservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CameraInfoResponse {
    private Long id;
    private String sourceDataUrl;
    private String tokenDataUrl;
}
