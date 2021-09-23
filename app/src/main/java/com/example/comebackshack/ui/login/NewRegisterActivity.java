package com.example.comebackshack.ui.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.comebackshack.R;
import com.example.comebackshack.ui.requests.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class NewRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etDisplayName = (EditText) findViewById(R.id.etDisplayName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etphoneNumber = (EditText) findViewById(R.id.etphoneNumber);
        final EditText etlocation = (EditText) findViewById(R.id.etlocation);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etEmail.getText().toString();
                final String displayName = etDisplayName.getText().toString();
                final String password = etPassword.getText().toString();
                final String phoneNumber = etphoneNumber.getText().toString();
                final String location = etlocation.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(NewRegisterActivity.this, LoginActivity.class);
                                NewRegisterActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(NewRegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

//                RegisterRequest registerRequest = new RegisterRequest(email, displayName, password, phoneNumber, location, responseListener, );
//                RequestQueue queue = Volley.newRequestQueue(NewRegisterActivity.this);
//                queue.add(registerRequest);
            }
        });
    }
}
