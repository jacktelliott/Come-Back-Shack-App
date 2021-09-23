package com.example.comebackshack.ui.requests;

import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL =
            "https://jackelliotthomework.000webhostapp.com/login.php";
    private Map<String, String> params;

    public LoginRequest(String email, String password,
                        Response.Listener<String> listener,
                        Response.ErrorListener errorListener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, errorListener);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
/*public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL =
            "https://jackelliotthomework.000webhostapp.com/login.php";

    public LoginRequest(String email, String password, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.GET, LOGIN_REQUEST_URL, listener, errorListener);
    }
    public LoginRequest(String uri, Response.Listener<String> listener, Response.ErrorListener errorListener){
        super(Method.GET, uri, listener, errorListener);
    }
}*/
