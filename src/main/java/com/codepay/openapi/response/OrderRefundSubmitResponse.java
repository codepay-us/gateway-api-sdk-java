package com.codepay.openapi.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 */
@Getter
@Setter
@ToString(callSuper = true)
public class OrderRefundSubmitResponse extends OpenApiResponse {

    // The transaction serial number returned by the gateway, which uniquely identifies a transaction
    private String trans_no;

    // Amount of the transaction
    private Double trans_amount;

    // Customer pays handling fee
    private Double trans_fee_c;

    // VAT
    private Double vat_amount;

}
