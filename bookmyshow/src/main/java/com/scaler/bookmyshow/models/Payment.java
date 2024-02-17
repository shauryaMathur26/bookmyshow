package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.PaymentMode;
import com.scaler.bookmyshow.enums.PaymentProvider;
import com.scaler.bookmyshow.enums.PaymentStatus;
import lombok.Data;

@Data
public class Payment extends BaseModel{
    private int amount;
    private String referenceNumber;
    private PaymentMode paymentMode;
    private PaymentProvider paymentProvider;
    private PaymentStatus paymentStatus;
}
