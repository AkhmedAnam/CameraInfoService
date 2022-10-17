package ru.ahmed.anam.camerasinfoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class CameraInfoResponse {
    private Long id;
    private String sourceDataUrl;
    private String tokenDataUrl;
}
