package com.example.laboratorio3.domain.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GeneralResponse {
    private String message;
    private int status;
    private LocalDateTime time;
    private String uri;
    private Object data;
}
