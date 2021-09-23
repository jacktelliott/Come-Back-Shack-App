package com.example.comebackshack.ui.requests;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL =
            "https://jackelliotthomework.000webhostapp.com/register.php";
    private Map<String, String> params;

    public RegisterRequest(String email, String displayName, String password,
                           String phoneNumber,String location,
                           Response.Listener<String> listener,
                           Response.ErrorListener errorListener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, errorListener);
        params = new HashMap<>();
        params.put("email", email);
        params.put("displayName", displayName);
        params.put("password", password);
        params.put("phoneNumber", phoneNumber);
        params.put("location", location);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}