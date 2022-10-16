package ru.ahmed.anam.camerasinfoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CameraInfoDTO {
    private Long id;
    private String urlType;
    private String videoUrl;
    private String value;
    private Long ttl;

    public static CameraInfoDTO create(Long id, SourceDataInfo sourceDataInfo, TokenDataInfo tokenDataInfo){
        return new CameraInfoDTO(
                id,
                sourceDataInfo.getUrlType(),
                sourceDataInfo.getVideoUrl(),
                tokenDataInfo.getValue(),
                tokenDataInfo.getTtl()
        );
    }
}
