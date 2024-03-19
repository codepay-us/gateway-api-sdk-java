package com.codepay.openapi.request;

import com.codepay.openapi.response.BatchCloseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: Close the current batch, and new transactions will proceed to a new batch. After the batch transaction,
 * the current batch transaction can only be refunded and cannot be canceled. Closing the batch does not mean that settlement will be made immediately.
 */
@Getter
@Setter
@ToString
public class BatchCloseRequest extends OpenApiRequest<BatchCloseResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Device hardware serial number
    private String terminal_sn;

}
