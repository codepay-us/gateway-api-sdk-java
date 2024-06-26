package com.codepay.openapi.request;

import com.codepay.openapi.response.WisehubCloudPayOrderResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: The merchant background calls this API to create a prepaid transaction in the gateway payment service background.
 * The gateway push a message to the designated application of the IoT device (such as smart POS), starts the cash register application
 * on the device to display the order, and the cashier confirms the order and guides the user to complete the payment.
 */
@Getter
@Setter
@ToString
public class WisehubCloudPayOrderRequest extends OpenApiRequest<WisehubCloudPayOrderResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // The serial numbers of POS and other devices, need to be bound on the merchant platform in advance
    private String terminal_sn;

    // Payment scene
    // Enum: "BSCANQR_PAY" "SCANQR_PAY" "SWIPE_CARD"
    private String pay_scenario;

    // Payment Method ID
    private String pay_method_id;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;

    // Price currency-ISO three-digit letter code,For example: CNY,USD
    private String price_currency;

    // Order amount
    private Double order_amount;

    // Cashback amount
    private Double cashback_amount;

    // Tip Amount
    private Double tip_amount;

    // Whether or not to enter tips on the CodePay Rigister page, default is false, when "trans_type=1, 3, 4", this parameter can be set
    private Boolean on_screen_tip;

    // Transaction type
    private Integer trans_type;

    // Description of the goods or services of the order
    private String description;

    // Original merchant system order number
    private String orig_merchant_order_no;

    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;

    // For additional information of merchants, the system only does transparent transmission, does not do business processing,
    // payment inquiries and notifications, and the statement download will be returned as it is
    private String attach;

    // Specifies the callback address for receiving gateway payment notifications
    private String notify_url;

    // Message receiving application
    private String message_receiving_application;

    // Remaining time of transaction expiration
    private Integer expires;

    // Order queue mode
    private String order_queue_mode;

    // Whether to reject transactions when the terminal is offline
    private Boolean reject_trade_when_terminal_offline;

    // API version
    private String api_version;

    // When refund or void a transaction, does the store manager role need to authorize this operation on the terminal? default value: false
    private Boolean required_terminal_authentication;

    // Before the transaction, do you need CodePay Register to display a confirmation interface? The cashier can only proceed with the transaction after clicking confirm. By default, no confirmation is required and you can directly enter the card reading interface
    private Boolean confirm_on_terminal;

    // Type of bank card, 1-Debit card 2-Credit card 3-Ebt card 4-Gift card
    private Integer card_type;

    // This parameter controls the display logic of electronic signatures
    private Boolean on_screen_signature;

    // Receeipt printing mode
    // 0: No printing, default value
    // 1: Print merchant copy
    // 2: Print customer copy
    // 3: Print merchant copy + customer copy
    private Integer receipt_print_mode;

}
