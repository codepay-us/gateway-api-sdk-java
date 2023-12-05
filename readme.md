# Java SDK instructions for use

You can use the open SDK we provide to integrate with the CodePay payment gateway. The SDK encapsulates the process of performing the integration, including adding and validating signatures that call the payment gateway API.
We do not guarantee the security and practicality of this code. It is just a examples that demonstrates the process of calling our API. You can refer to this code to write a program that is more suitable for your business system.

## Conditions

Suitable for Java language, JDK version 1.8 and above development environment.

## Java SDK integration

1. The SDK has encapsulated the signature verification logic, and the API can be called directly using the SDK.
2. Determine the class corresponding to the interface
   Such as the interface name: `wisehub.cloud.pay.order` <br />
   The class in the SDK is: capitalize the first letter of each word and remove the delimiter ("." ) and add Request (or Response) at the end. <br />
   The class corresponding to the interface name in the example is：<br />
   `WisehubCloudPayOrderRequest`（Request class） <br />
   `BscancPaySubmitResponse`（Response class）

## Usage steps

#### 1. Download the jar package and add it to your project, please refer to github source code

<a href="https://github.com/codepay-us/gateway-api-sdk-java/releases/tag/v1.0.0" target="_blank">gateway-api-sdk-java.jar</a><br />

![Javasdk1](src%2Fmain%2Fresources%2FJavasdk1.png)
![Javasdk2](src%2Fmain%2Fresources%2FJavasdk2.png)

#### 2. This JAR depends on some open source third party JARs. If these JARs are not integrated in your project, you will need to manually add dependencies to your project

```xml
<dependency>
  <groupId>com.alibaba</groupId>
  <artifactId>fastjson</artifactId>
  <version>1.2.62</version>
</dependency>
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.12</version>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>commons-logging</groupId>
  <artifactId>commons-logging</artifactId>
  <version>1.2</version>
</dependency>
<dependency>
  <groupId>commons-lang</groupId>
  <artifactId>commons-lang</artifactId>
  <version>2.6</version>
</dependency>
<dependency>
  <groupId>commons-codec</groupId>
  <artifactId>commons-codec</artifactId>
  <version>1.11</version>
</dependency>
<dependency>
  <groupId>org.apache.httpcomponents</groupId>
  <artifactId>httpclient</artifactId>
  <version>4.5.6</version>
</dependency>
<dependency>
  <groupId>org.apache.httpcomponents</groupId>
  <artifactId>httpmime</artifactId>
  <version>4.5.6</version>
</dependency>
```

#### 3. Refer to the following sample and develop against the <a href = "https://developer.codepay.us/docs/CloudAPI" target = "_blank">cloud API documentation </a>

```java
//  Instantiate the client
OpenApiClient openapiClient = new OpenApiClient(<YOUR_APP_ID>, <GATEWAY_URL>, <YOUR_APP_RSA_PRIVATE_KEY>, <GATEWAY_RSA_PUBLIC_KEY>);

// Build request object and set request parameters
WisehubCloudPayOrderRequest request = new WisehubCloudPayOrderRequest();
request.setMerchant_no("{Your merchant number}");
request.setStore_no("{Your store number}");
request.setTerminal_sn("{Your terminal sn}");
request.setMessage_receiving_application("CodePay Register");
request.setPay_method_category("BANKCARD");
request.setPrice_currency("USD");
request.setOrder_amount(34.50);
request.setTrans_type(1);
request.setMerchant_order_no("mapp" + System.currentTimeMillis());
request.setDescription("IPhone 15 white X2");
request.setExpires(5);
request.setOrder_queue_mode("FIFO");

// Execute API calls and receive response message objects
WisehubCloudPayOrderResponse response = null;
try {
    response = openapiClient.execute(request);
} catch (OpenApiException e) {
    // TODO
    // API request failed, possibly due to network issues, signature issues, or other issues. It is recommended to call the query or close the order API
    return;
}

// Process response
if (response.isSuccess()) {
    // TODO
    // The result of successful API response, saving the transaction number, calling the query interface in the background
    // to query the order payment result, and receiving asynchronous payment result notification
} else {
    // TODO
    // API response business result failed, execute failure handling logic
}
```
