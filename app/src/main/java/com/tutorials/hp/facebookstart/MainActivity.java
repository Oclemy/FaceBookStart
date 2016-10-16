package com.tutorials.hp.facebookstart;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.listeners.OnLoginListener;
import com.sromku.simple.fb.listeners.OnLogoutListener;
import com.tutorials.hp.facebookstart.mFaceBook.MyConfiguration;

import java.util.List;

public class MainActivity extends AppCompatActivity {


   SimpleFacebook fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        SimpleFacebook.setConfiguration(new MyConfiguration().getMyConfigs());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }


        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        fb=SimpleFacebook.getInstance(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        fb.onActivityResult(requestCode,resultCode,data);
    }

    private void login()
    {
        OnLoginListener loginListener=new OnLoginListener() {
            @Override
            public void onLogin(String accessToken, List<Permission> acceptedPermissions, List<Permission> declinedPermissions) {
                Toast.makeText(MainActivity.this,"Logged In",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this,"Cancelled ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onException(Throwable throwable) {
               Log.e("Exception ",throwable.getMessage());
            }

            @Override
            public void onFail(String reason) {
                Log.d("Fail ",reason);
            }
        };

        fb.login(loginListener);
    }
}
