package ru.ahmed.anam.camerasinfoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceDataInfo {
    private String urlType;
    private String videoUrl;
}
