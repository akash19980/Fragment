package com.example.user.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Fragment {

    View view;
    EditText username, password;
    Button login;
    String user, pass;
    String bundle_user,bundle_pass;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_login,container,false);
        username=(EditText)view.findViewById(R.id.username);
        password=(EditText)view.findViewById(R.id.password);
        login=(Button)view.findViewById(R.id.login);
//------------------------------GettingBundleFromMAinActivity---------------------------------------//
        Bundle bundle=getArguments();
        bundle_user=bundle.getString("USER2");
        bundle_pass=bundle.getString("PASS2");

//----------------------------------------LoginButton-----------------------------------------------//
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                AlertDialog.Builder alert=new AlertDialog.Builder(view.getContext());
                alert.setTitle("ALERT !");
                alert.setMessage("Invaled Username or Password");
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.cancel();
                    }
                });
                user = username.getText().toString();
                pass = password.getText().toString();

                if (user.equals(bundle_user) && pass.equals(bundle_pass))
                {
                    Intent intent = new Intent(getActivity(), DevicesGrid.class);
                    intent.putExtra("USERNAME", user + "");
                    startActivity(intent);
                }
                else
                {
                    alert.show();
                }


            }
        });
        // Inflate the layout for this fragment
        return view;
    }




}
