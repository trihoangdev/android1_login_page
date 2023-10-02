package com.example.android1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText edtAccount, edtPassword, edtPasswordAgain;
    private TextView txtContinue;
    private String account = "", password = "", passwordAgain = "";

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAccount = findViewById(R.id.edtAccount);
        edtPassword = findViewById(R.id.edtPassword);
        edtPasswordAgain = findViewById(R.id.edtPasswordAgain);
        txtContinue = findViewById(R.id.txtContinue);

        edtAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void afterTextChanged(Editable editable) {
                account = editable.toString().trim();
                //điều kiện: Độ dài phải lớn hơn 6
                if (account.length() < 6) {
                    edtAccount.setError("Độ dài phải lớn hơn 6");
                    edtAccount.setBackground(getDrawable(R.drawable.background_edittext_error));
                } else {
                    edtAccount.setBackground(getDrawable(R.drawable.background_edittext));
                }
            }
        });
        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void afterTextChanged(Editable editable) {
                password = editable.toString().trim();
                //điều kiện: Độ dài phải lớn hơn 8
                if (password.length() < 8) {
                    edtPassword.setError("Độ dài phải lớn hơn 8");
                    edtPassword.setBackground(getDrawable(R.drawable.background_edittext_error));
                } else {
                    edtPassword.setBackground(getDrawable(R.drawable.background_edittext));
                }
            }
        });
        edtPasswordAgain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void afterTextChanged(Editable editable) {
                passwordAgain = editable.toString().trim();
                //điều kiện: trùng với password
                if (!passwordAgain.equals(password))  {
                    edtPasswordAgain.setError("Mật khẩu không trùng khớp");
                    edtPasswordAgain.setBackground(getDrawable(R.drawable.background_edittext_error));
                } else {
                    edtPasswordAgain.setBackground(getDrawable(R.drawable.background_edittext));
                }
            }
        });

        txtContinue.setOnClickListener(view->{
            if(!account.equals("") && !password.equals("") && !passwordAgain.equals("")){
                Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
            }
            else{
                if(account.equals("")){
                    edtAccount.setError("Không được để trống");
                    edtAccount.setBackground(getDrawable(R.drawable.background_edittext_error));
                }
                if(password.equals("")){
                    edtPassword.setError("Không được để trống");
                    edtPassword.setBackground(getDrawable(R.drawable.background_edittext_error));
                }
                if(passwordAgain.equals("")){
                    edtPasswordAgain.setError("Không được để trống");
                    edtPasswordAgain.setBackground(getDrawable(R.drawable.background_edittext_error));
                }
            }
        });
    }
}