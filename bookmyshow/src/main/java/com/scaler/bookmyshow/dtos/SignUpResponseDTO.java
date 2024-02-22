package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.enums.ResponseStatus;
import lombok.Data;

@Data
public class SignUpResponseDTO {
    private ResponseStatus responseStatus;
    private Long userId;
}
