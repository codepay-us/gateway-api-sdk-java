package FiservGoLive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codepay.openapi.OpenApiClient;
import com.codepay.openapi.OpenApiException;
import com.codepay.openapi.request.PayCheckoutRequest;
import com.codepay.openapi.response.PayCheckoutResponse;
import com.codepay.openapi.utils.EAuthType;
import org.junit.Test;

public class TestSample {

    private static final String APP_RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCSRlffOJLxmraSyJhw0ehu6iFaJ4LyfIwXo9Dk7lIFlsxHthfXk2PK86SpagrgLjnSvo6LjDZTIoWlEM7apEXsSnJUstEmF8LS6JfDfTaXPvF67DZT244MRSN17R/Tkl4bJTv073EN384e87gNyhi1N0N8fY5+5nzrzqcWxuXvrwhiTnWN9WLm3GDt75Hw5HjUZQtUJX3sPPQ98eWoDzfnG+72YXbINhAFLZ6Fs/n11agL43BhD7+RNKhHOqJN2UhRtTv0paVpBVyGHv1p0RnHWUQ+fiIEi36LW4KuOx88shPYDeFP/bS4YUcomuhWxY73MD6++Hr27e6vpPqXyVzxAgMBAAECggEAE1r7ha4Ww6GVRxcEFOmxt/uDLkrMKQoR/47NtX1TnSm3HkYaIYx/R/u1bjV5+vAi9qAAfLaw+Y833/+5X3UdS4cOWebPhhrezMm6S0PmVV0e1wUqqy4CPd1oM9KMw5I6oZzrsh18+DkFLVNSp4B2hIQrie2TTXdyUEGoGnt3MZ/jzKtain5dyYEuQRPfbD1Qbnb+NI+smzlcs3D/FkXpn3IDSY6Cx+vSUj2XJnm6gMh0OXa0BG0ukg1TRvWtNqg8aiX7fMI4YxZDvn6Ln3zjLIQdJw2UM4zyRzWhQLWnQ1tEWLMoCSL34rLt81bgUJJP7uQmBMAfVebQXtXdkweCAQKBgQDhbkW72XERZQAekDvZ3tH5PWv4IfuhJ3KxtW3WL8PUbBIqEo9Qs8O2zV66XArwolnDxHpfLogpvKmroIkMQWZxxUHkidj1bKuESyebQBXM7BNqNULdylR9HxbO44hZ7rMBwC1vB8PGgKkdowbzSnI60qKC/ANiDu9+EUKVqBP1JQKBgQCmHDTpPMF55RQ8oadsfs2jI4Gs1S2bRCQ9bpshNCHTvFkJ+ulmmTYPl7FUdLvmiT3eje/BC8N7ZxWxbM5GVX+ACvZ7O6J/puZlUKAtUhmvxGLZtNdGFVbzmlKfS3Bo73TsqZqFSNiZ+f92zEi/7Yv+JOfNcnsd7IkeRHVkrH0M3QKBgC+qIkJ60mZsJZ9QvebuLxV1ADxB6zOC5MRgaS3tgYmLpDeTHwxgRhSDzfC3f3SrzzEOfRVdAFta0cFBO1kFBwUtQSZyYxZZeNaLEX/JCBMBI4XEZzQAEOc3yJnMEEt7pgvLt4+PY7y3/YoPq2uLpSV83fG2GX0FTWwpeBuuozGlAoGAX1i9fkujesZlUVAw+/PlMYlF++D5pq/8ZU7BuNNlv1XTfgkKRBwZjeWyohnHaVLJsp+iSRrpgEHxj8A2vuSApQyl4qKeactxYCJhbuI7YErHutM05kOFf5rLZig1Q+Z/JQFNcsgXnHqFirlD4PcHbj/c1m6qAMkvA7Kj97+Sn/kCgYEA3dRLpM99NTnXeAkbC1XpIUCC74EO9aSy1ZxujSgvDeHyNFWKwNp8pGKcas3qWzQHLMV4pSHkYO7D39+pmDcdcDCpGZOTgnVNNOSWATXNFgvI8AxfkJ0m8kNGST4rwiG7yF08aZqSEjyeWeP7XGT6J5TEB1QBSB7z/KFqyE5L5kg=";
    private static final String GATEWAY_RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAirB9X4EmUwh5l4lCoA0uSGRUiUrl+5CXutY8BvT+6TbVCjzL1e72LKDtsUTubVmIYvytD0y8lXutrlHI+1W0eR6ZWrpav8k//qQecE6Yg55tdUTAO4dZtmGbhP4XQGRsqlRx5VQWIGP4Abq4XRLyUSGxIFafPhepvCWVsIK16U2nLdTQ43Er0U1ucMjwmHUoPrNK/TsImRzpc5KEUhsNFNVDcrJ9Mc81ThoXEDIUdxKEZpp/MyNK6WpZ8pCpa9TALgl2q8a+aD7K+yvowk3UZAFiRiFJ7Wrmw6kj3TVRtGPR5cgmobajdfK6V3enQeS/KXKHrid5wIUrIyO6po9MyQIDAQAB";
    private static final String APP_AES_KEY = "Wq8AhbaG1ZfmPEDS/FkUEBGZP/rRHMX3/6/H7vwyb8U=";
    private static final String APP_ID = "wze0fcae4016b4da15";
    public static final String SANDBOX_GATEWAY_URL = "https://codepay-open.codepay.me";

    @Test
    public void checkout() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY, "123456", "uiohajzklllz");

        // Build a request object, set parameters
        PayCheckoutRequest request = new PayCheckoutRequest();
        request.setMerchant_no("302300000342");
        request.setStore_no("4023000004");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("USD");
        request.setOrder_amount(1.0);
        request.setExpires(3600);
        request.setDescription("IPhone 15 5G White");

        JSONObject ext_params = new JSONObject();
        ext_params.put("service_entry_mode", "010"); // 010/100
        ext_params.put("tran_init", "Customer"); // Customer/Merchant
        ext_params.put("auth_indicator", "CrdOnFile");
        ext_params.put("stored_cred_ind", "Initial"); // Initial/Subsequent
        ext_params.put("cof_sched_ind", "Scheduled"); // Scheduled/Unscheduled
        ext_params.put("citmit_frame_ind", ""); // C101/M101
        request.setExt_params(ext_params.toJSONString());

        PayCheckoutResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request, EAuthType.BASIC_AUTH);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

}
