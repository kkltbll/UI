package com.example.administrator.ui;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;
import android.graphics.Color;

public class alertDialog extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view2 = View.inflate(alertDialog.this, R.layout.activity_alert_dialog, null);
        final EditText username = (EditText) view2.findViewById(R.id.username);
        final EditText password = (EditText) view2.findViewById(R.id.password);
        final Button button = (Button) view2.findViewById(R.id. btn_login);
        final Button button1 = (Button) view2.findViewById(R.id.btn_cancel);
        builder.setTitle("Android App").setIcon(R.drawable.header_logo).setView(view2);
        /*TextView title = new TextView(this);
        title.setPadding(10, 10, 10, 10);//边距
        title.setTextColor(Color.parseColor("#FFE4C4"));//字体的颜色
        title.setTextSize(23);//字体的大小
        builder.setTitle("Android App").setView(view2);*/
        final AlertDialog alertDialog1 = builder.create();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString().trim();
                String psd = password.getText().toString().trim();
                int duration1 = Toast.LENGTH_LONG;
                if(uname.equals("lqh") && psd.equals("123")){
                    Toast toast=Toast.makeText(alertDialog.this,"登录成功!" , duration1);
                    toast.show();
                }
                Toast toast=Toast.makeText(alertDialog.this,"登录失败!" , duration1);
                toast.show();
                alertDialog1.dismiss();
            }
        });
        alertDialog1.show();

    }
}



