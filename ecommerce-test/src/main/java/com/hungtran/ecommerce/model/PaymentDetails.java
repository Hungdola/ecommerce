package com.hungtran.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDetails {

    private String paymentMethod;
    private String status;
    private String paymentId;
    private String razopayPaymentLinkId;
    private String razopayPaymentLinkReferenceld;
    private String razopayPaymentLinkStatus;
    private String razopayPaymentId;
}
