package com.example.rashmi.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

      int randomNum;
    int cnt =0;
      public void generateRandom()
      {
          Random rand = new Random();
          randomNum = rand.nextInt(20) + 1;
      }

      public  void guess(View view)
      {
          EditText editText = (EditText) findViewById(R.id.editText);
          int guessVal = Integer.parseInt(editText.getText().toString());
          String message;

          if(guessVal>randomNum)
          {
              message = "Lower!";
              cnt++;
          }
          else if(guessVal<randomNum)
          {
              message = "Higher!";
              cnt++;
          }
          else
          {
             if(cnt<=5)
             {
                 message = "You Won!!";
             }
             else
             {
                 message = "You Lost.....You Guesses Right but the number of attempts exceeded 5 !!";
                 generateRandom();
             }
          }

          Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
      }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandom();
    }
}
