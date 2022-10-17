package ru.ahmed.anam.camerasinfoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDataInfo {
    private String value;
    private Long ttl;
}
