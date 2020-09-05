package com.example.androidshaper.databindingwithtextview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidshaper.databindingwithtextview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    TextView textViewName,textViewEmail;

    private ActivityMainBinding activityMainBinding;

    MainActivityClickHandlers mainActivityClickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        activityMainBinding.setStudent(getCurrentStudent());
        mainActivityClickHandlers=new MainActivityClickHandlers(this);
        activityMainBinding.setClickHandler(mainActivityClickHandlers);

//        textViewName=findViewById(R.id.textViewName);
//        textViewEmail=findViewById(R.id.textViewEmail);
//        textViewName.setText(getCurrentStudent().getStudentName());
//        textViewEmail.setText(getCurrentStudent().getStudentEmail());
    }

    public Student getCurrentStudent()
    {
        Student student=new Student("Rakib Hasan","rakibhasan@gmail.com");


        return student;
    }

    public class MainActivityClickHandlers
    {
        Context context;

        public MainActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void  buttonClick(View view)
        {
            Toast.makeText(getApplicationContext(),"click this button",Toast.LENGTH_SHORT).show();

        }
        public void  handlerClick(View view)
        {
            Toast.makeText(getApplicationContext(),"handler this button",Toast.LENGTH_SHORT).show();

        }

    }
}