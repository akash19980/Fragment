package com.example.user.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button login,register;
TextView tv;
String intent_user,intent_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView);
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);
//----------------------------GettingIntentFromRegisterFragment-------------------------------------//
        Intent intent =getIntent();
        intent_user=intent.getStringExtra("USER");
        intent_pass=intent.getStringExtra("PASS");
//--------------------------------------LOGIN BUTTON------------------------------------------------//

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                tv.setText("       LOGIN");
                login.setVisibility(View.INVISIBLE);
                register.setVisibility(View.INVISIBLE);
                //load(new Login());
                Bundle bundle =new Bundle();
                bundle.putString("USER2",intent_user);
                bundle.putString("PASS2",intent_pass);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Login login = new Login();
                login.setArguments(bundle);
                ft.replace(R.id.frame,login);
                ft.commit();
            }
        });
//-----------------------------REGISTER BUTTON----------------------------------//

        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                tv.setText("    REGISTER");
                login.setVisibility(View.INVISIBLE);
                register.setVisibility(View.INVISIBLE);
                load(new Register());
            }
        });
    }

    public void load(Fragment fragment){
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();    }
}
