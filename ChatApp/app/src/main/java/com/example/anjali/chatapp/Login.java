package com.example.anjali.chatapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import custom.CustomActivity;
import custom.Utils;

/**
 * Created by anjali on 1/9/15.
 */
public class Login extends CustomActivity {

    private EditText user;      //edittext for user
    private EditText pwd;       //edittext for password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTouchNClick(R.id.btn_login);
        setTouchNClick(R.id.btnReg);

        user = (EditText) findViewById(R.id.user);
        pwd = (EditText) findViewById(R.id.pwd);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    if(v.getId() == R.id.btnReg){
        startActivityForResult(new Intent(this,Register.class),10);
    }
        else{
        String u = user.getText().toString();
        String p = pwd.getText().toString();
        if(u.length()==0 || p.length()==0){
            Utils.showDialog(this, R.string.err_fields_empty);
            return;
        }
        final ProgressDialog dia = ProgressDialog.show(this,null,getString(R.string.alert_wait));
        ParseUser.logInInBackground(u, p, new LogInCallback() {
            @Override
            public void done(ParseUser pu, com.parse.ParseException e) {
                    dia.dismiss();
                    if (pu != null) {
                        UserList.user = pu;
                        startActivity(new Intent(Login.this, UserList.class));
                        finish();
                    } else {
                        Utils.showDialog(
                                Login.this, getString(R.string.err_login) + " " + e.getMessage()
                        );
                        e.printStackTrace();
                    }
                }
        });
    }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && resultCode == RESULT_OK)
            finish();
    }
}
