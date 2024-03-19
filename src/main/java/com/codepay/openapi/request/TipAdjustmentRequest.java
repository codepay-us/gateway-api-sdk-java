package com.codepay.openapi.request;

import com.codepay.openapi.response.TipAdjustmentResponse;
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
public class TipAdjustmentRequest extends OpenApiRequest<TipAdjustmentResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // The internal order number of the merchant system must be within 32 characters and can only be a number, uppercase and lowercase letters _ - | * @, And unique under the same merchant
    private String merchant_order_no;

    // Tip adjustment amount
    private Double tip_adjustment_amount;

}
