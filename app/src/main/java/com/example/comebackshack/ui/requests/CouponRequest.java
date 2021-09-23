package com.example.comebackshack.ui.requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CouponRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL =
            "https://jackelliotthomework.000webhostapp.com/coupon.php";
    private Map<String, String> params;

    public CouponRequest(String coupon1, String coupon2, String coupon3,
                         Response.Listener<String> listener,
                         Response.ErrorListener errorListener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, errorListener);
        params = new HashMap<>();
        params.put("coupon1", coupon1);
        params.put("coupon2", coupon2);
        params.put("coupon3", coupon3);
    }

    public Map<String, String> getParams() {
        return params;
    }
}
