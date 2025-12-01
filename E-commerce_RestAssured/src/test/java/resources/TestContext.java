package resources;

public class TestContext {
 private static String authToken;
 private static String UserId;
    private static String orderId;
    private static String productId;

    public static String getProductId() {
        return productId;
    }

    public static String getOrderId() {
        return orderId;
    }

    public static void setOrderId(String orderId) {
        TestContext.orderId = orderId;
    }

    public static void setProductId(String productId) {
        TestContext.productId = productId;
    }

    public static void setUserId(String userId) {
        UserId = userId;
    }

    public static String getUserId() {
        return UserId;
    }

    public static String getAuthToken() {
            return authToken;
        }

        public static void setAuthToken(String token) {
            authToken = token;
        }
    }

