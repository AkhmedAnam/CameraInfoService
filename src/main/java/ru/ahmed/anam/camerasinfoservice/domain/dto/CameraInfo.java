package ru.ahmed.anam.camerasinfoservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ahmed.anam.camerasinfoservice.domain.SourceDataInfo;
import ru.ahmed.anam.camerasinfoservice.domain.TokenDataInfo;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CameraInfo implements Serializable {

    private static final long serialVersionUID = 1248339345646646290L;

    private Long id;
    private String urlType;
    private String videoUrl;
    private String value;
    private Long ttl;

    public static CameraInfo create(Long id, SourceDataInfo sourceDataInfo, TokenDataInfo tokenDataInfo){
        return new CameraInfo(
                id,
                sourceDataInfo.getUrlType(),
                sourceDataInfo.getVideoUrl(),
                tokenDataInfo.getValue(),
                tokenDataInfo.getTtl()
        );
    }
}
