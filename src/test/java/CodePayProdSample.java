import com.codepay.openapi.OpenApiClient;
import com.codepay.openapi.OpenApiException;
import com.codepay.openapi.request.WisehubCloudPayOrderRequest;
import com.codepay.openapi.response.WisehubCloudPayOrderResponse;
import org.junit.Test;

public class CodePayProdSample {

    private static final String APP_RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCSRlffOJLxmraSyJhw0ehu6iFaJ4LyfIwXo9Dk7lIFlsxHthfXk2PK86SpagrgLjnSvo6LjDZTIoWlEM7apEXsSnJUstEmF8LS6JfDfTaXPvF67DZT244MRSN17R/Tkl4bJTv073EN384e87gNyhi1N0N8fY5+5nzrzqcWxuXvrwhiTnWN9WLm3GDt75Hw5HjUZQtUJX3sPPQ98eWoDzfnG+72YXbINhAFLZ6Fs/n11agL43BhD7+RNKhHOqJN2UhRtTv0paVpBVyGHv1p0RnHWUQ+fiIEi36LW4KuOx88shPYDeFP/bS4YUcomuhWxY73MD6++Hr27e6vpPqXyVzxAgMBAAECggEAE1r7ha4Ww6GVRxcEFOmxt/uDLkrMKQoR/47NtX1TnSm3HkYaIYx/R/u1bjV5+vAi9qAAfLaw+Y833/+5X3UdS4cOWebPhhrezMm6S0PmVV0e1wUqqy4CPd1oM9KMw5I6oZzrsh18+DkFLVNSp4B2hIQrie2TTXdyUEGoGnt3MZ/jzKtain5dyYEuQRPfbD1Qbnb+NI+smzlcs3D/FkXpn3IDSY6Cx+vSUj2XJnm6gMh0OXa0BG0ukg1TRvWtNqg8aiX7fMI4YxZDvn6Ln3zjLIQdJw2UM4zyRzWhQLWnQ1tEWLMoCSL34rLt81bgUJJP7uQmBMAfVebQXtXdkweCAQKBgQDhbkW72XERZQAekDvZ3tH5PWv4IfuhJ3KxtW3WL8PUbBIqEo9Qs8O2zV66XArwolnDxHpfLogpvKmroIkMQWZxxUHkidj1bKuESyebQBXM7BNqNULdylR9HxbO44hZ7rMBwC1vB8PGgKkdowbzSnI60qKC/ANiDu9+EUKVqBP1JQKBgQCmHDTpPMF55RQ8oadsfs2jI4Gs1S2bRCQ9bpshNCHTvFkJ+ulmmTYPl7FUdLvmiT3eje/BC8N7ZxWxbM5GVX+ACvZ7O6J/puZlUKAtUhmvxGLZtNdGFVbzmlKfS3Bo73TsqZqFSNiZ+f92zEi/7Yv+JOfNcnsd7IkeRHVkrH0M3QKBgC+qIkJ60mZsJZ9QvebuLxV1ADxB6zOC5MRgaS3tgYmLpDeTHwxgRhSDzfC3f3SrzzEOfRVdAFta0cFBO1kFBwUtQSZyYxZZeNaLEX/JCBMBI4XEZzQAEOc3yJnMEEt7pgvLt4+PY7y3/YoPq2uLpSV83fG2GX0FTWwpeBuuozGlAoGAX1i9fkujesZlUVAw+/PlMYlF++D5pq/8ZU7BuNNlv1XTfgkKRBwZjeWyohnHaVLJsp+iSRrpgEHxj8A2vuSApQyl4qKeactxYCJhbuI7YErHutM05kOFf5rLZig1Q+Z/JQFNcsgXnHqFirlD4PcHbj/c1m6qAMkvA7Kj97+Sn/kCgYEA3dRLpM99NTnXeAkbC1XpIUCC74EO9aSy1ZxujSgvDeHyNFWKwNp8pGKcas3qWzQHLMV4pSHkYO7D39+pmDcdcDCpGZOTgnVNNOSWATXNFgvI8AxfkJ0m8kNGST4rwiG7yF08aZqSEjyeWeP7XGT6J5TEB1QBSB7z/KFqyE5L5kg=";
    private static final String GATEWAY_RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl838XBDyDxsR3ChhYPKTHo8pevqDb9TpjjnaeNpSOWvCsIABH3VWxYYErWI167oA1C/QukoBWKxK8TR4bz5doJQm0BKJ99fPK3Zx/H7f++UBjd97rG87bPFq1Q3pJs9BRqiHJwdZOegWwwfq3OPjD2m+sntyOcz2p6AhQ38l5q0bOPYjMWZ2k61e5x+CbJdfKxFCnICLzqe8A8oz1h1wGTdUNCZ/nyFZ2KwTUVwarPdgj6dJSV029dfjvcY9o3280nq+gKh5ZeAhpJSL0r0qk9mph7a9xY1oOi1jv3OGANIQLBOoN0GwibxUhmOJ3VnNv+9+e2D2ovO9i5TTw7TwiQIDAQAB";
    private static final String APP_ID = "wz6012822ca2f1as78";
    public static final String PROD_GATEWAY_URL = "https://gw.codepay.us";

    @Test
    public void crossTerminalIntegrationCloudModeCreateOrder() {
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, PROD_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);
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
        WisehubCloudPayOrderResponse response = null;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // TODO
            // API request failed, possibly due to network issues, signature issues, or other issues. It is recommended to call the query or close the order API
            return;
        }

        if (response.isSuccess()) {
            // TODO
            // The result of successful API response, saving the transaction number, calling the query interface in the background
            // to query the order payment result, and receiving asynchronous payment result notification
        } else {
            // TODO
            // API response business result failed, execute failure handling logic
        }
    }

}
