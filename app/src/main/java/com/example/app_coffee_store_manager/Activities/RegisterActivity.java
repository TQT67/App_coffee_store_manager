package com.example.app_coffee_store_manager.Activities;

import static com.sinhvien.orderdrinkapp.R.*;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    ImageView IMG_signup_back;
    Button BTN_signup_next;
    TextView TXT_signup_title;
    TextInputLayout TXTL_signup_HoVaTen, TXTL_signup_TenDN, TXTL_signup_Email, TXTL_signup_SDT, TXTL_signup_MatKhau;
    public static final String BUNDLE = "BUNDLE";
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{6,}" +                // at least 4 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.register_layout);

        //region lấy đối tượng view
        IMG_signup_back = (ImageView)findViewById(id.img_signup_back);
        BTN_signup_next = (Button)findViewById(id.btn_signup_next);
        TXT_signup_title = (TextView)findViewById(id.txt_signup_title);
        TXTL_signup_HoVaTen = (TextInputLayout)findViewById(id.txtl_signup_HoVaTen);
        TXTL_signup_TenDN = (TextInputLayout)findViewById(id.txtl_signup_TenDN);
        TXTL_signup_Email = (TextInputLayout)findViewById(id.txtl_signup_Email);
        TXTL_signup_SDT = (TextInputLayout)findViewById(id.txtl_signup_SDT);
        TXTL_signup_MatKhau = (TextInputLayout)findViewById(id.txtl_signup_MatKhau);
        //endregion

        BTN_signup_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kiểm tra validate false => phải thỏa đk validate
                if(!validateFullName() | !validateUserName() | !validateEmail() | !validatePhone() | !validatePassWord()){
                    return;
                }
                String hoTen = TXTL_signup_HoVaTen.getEditText().getText().toString();
                String tenDN = TXTL_signup_TenDN.getEditText().getText().toString();
                String eMail = TXTL_signup_Email.getEditText().getText().toString();
                String sDT = TXTL_signup_SDT.getEditText().getText().toString();
                String matKhau = TXTL_signup_MatKhau.getEditText().getText().toString();

                byBundleNextSignupScreen(hoTen,tenDN,eMail,sDT,matKhau);
            }
        });

    }

