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
public class PayUnifiedorderResponse extends OpenApiResponse {

    // Payment link URL
    private String pay_url;

    // Original request message of the payment company
    private String pay_original_request;

    // Original response message requesting payment company
    private String pay_original_response;

    // Payment parameter packet
    private String pay_params;

    // Amount of the transaction
    private Double trans_amount;

    // Customer pays handling fee
    private Double trans_fee_c;

    // VAT
    private Double vat_amount;

}
