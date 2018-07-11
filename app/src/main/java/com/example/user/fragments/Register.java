package com.example.user.fragments;



import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Register extends Fragment {
    View view;
    Spinner gender;
    String[] genderArray={"Select Gender","Male","Female","Others"};
    EditText username,password,confirm_password;
    Button register;
    String pass,cnfmpass,user;
    int temp=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);
        confirm_password = (EditText) view.findViewById(R.id.confirmPassword);
        register = (Button) view.findViewById(R.id.register);
//-------------------------------------------Spinner------------------------------------------------//
        gender = (Spinner) view.findViewById(R.id.gedner);
        ArrayAdapter<String> adapterView = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, genderArray);
        adapterView.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapterView);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                        temp=1;

                }
                else
                {
                    temp=0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//---------------------------------------ButtonOnCLickListener--------------------------------------//
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                user=username.getText().toString();
                pass=password.getText().toString();
                cnfmpass=confirm_password.getText().toString();

//-------------------------------------------AlertDialog--------------------------------------------//
                AlertDialog.Builder alert=new AlertDialog.Builder(view.getContext());
                alert.setTitle("ALERT !");
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.cancel();
                    }
                });
//-------------------------------------CheckingInvalidConditions------------------------------------//
                if(pass.length()<8)
                {
                    alert.setMessage("Password Must Be 8 Character Long");
                    alert.show();
                }

                   else if(pass.equals(cnfmpass))
                    {
                        if(temp==0)
                        {
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            intent.putExtra("USER",user+"");
                            intent.putExtra("PASS",pass+"");
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Login Now", Toast.LENGTH_SHORT).show();
                        }
                        else if(temp==1)
                        {
                            alert.setMessage("Enter Valid Gender");
                            alert.show();
                        }
                    }
                    else
                    {
                        if(temp==0)
                        {
                            alert.setMessage("Incorrect Password");
                            alert.show();
                        }
                        else if(temp==1)
                        {
                            alert.setMessage("Invalid password and gender");
                            alert.show();
                        }
                    }


            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
