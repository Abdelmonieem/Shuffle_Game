package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button shuffleBtn,Btn1,Btn2,Btn3,Btn4,Btn5,Btn6,Btn7,Btn8,Btn9,Btn10,Btn11,Btn12,Btn13,Btn14,Btn15,Btn16;
    private int seconds = 0;
    private boolean running=false;
    private boolean wasRunning;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Btn16 = findViewById(R.id.btn16);
        final String next = Btn16.getText().toString();
        shuffleBtn = findViewById(R.id.button);
        shuffleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setShuffleBtn(next);
                running = true;
                runTimer();
            }
        });
        Btn1 = findViewById(R.id.btn1);
        Btn2 = findViewById(R.id.btn2);
        Btn3 = findViewById(R.id.btn3);
        Btn4 = findViewById(R.id.btn4);
        Btn5 = findViewById(R.id.btn5);
        Btn6 = findViewById(R.id.btn6);
        Btn7 = findViewById(R.id.btn7);
        Btn8 = findViewById(R.id.btn8);
        Btn9 = findViewById(R.id.btn9);
        Btn10 = findViewById(R.id.btn10);
        Btn11 = findViewById(R.id.btn11);
        Btn12 = findViewById(R.id.btn12);
        Btn13 = findViewById(R.id.btn13);
        Btn14 = findViewById(R.id.btn14);
        Btn15 = findViewById(R.id.btn15);


        Button btns[]={Btn1,Btn2,Btn3,Btn4,Btn5,Btn6,Btn7,Btn8,Btn9,Btn10,Btn11,Btn12,Btn13,Btn14,Btn15,Btn16};

        for (int i =0;i<btns.length;i++){
            int finalI = i;
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int back=0,up=0,down=0,front = 0;

                    if (finalI==5||finalI==6||finalI==9||finalI==10){
                         back=finalI-1;
                         up = finalI-4;
                         down=finalI+4;
                         front= finalI+1;
                    }
                    else if (finalI==13||finalI==14){
                        back=finalI-1;
                        up = finalI-4;
                        front= finalI+1;
                    }
                    else if (finalI==1||finalI==2){
                        back=finalI-1;
                        down = finalI+4;
                        front= finalI+1;
                    }
                    else if (finalI==4||finalI==8){
                        up = finalI-4;
                        down=finalI+4;
                        front= finalI+1;
                    }
                    else if (finalI==11||finalI==7){
                        up = finalI-4;
                        down=finalI+4;
                       back= finalI-1;
                    }
                    else if (finalI==0){
                        down=finalI+4;
                        front= finalI+1;
                    }
                    else if (finalI==3){
                        back=finalI-1;
                        down=finalI+4;
                    }
                    else if (finalI==12){
                        up = finalI-4;
                        front= finalI+1;
                    }
                    else if (finalI==15){
                        back=finalI-1;
                        up = finalI-4;
                    }

                    if (btns[front].getText().toString()==next){
                        btns[front].setText(btns[finalI].getText());
                        btns[finalI].setText(next);
                    }
                    if (btns[back].getText().toString()==next){
                        btns[back].setText(btns[finalI].getText());
                        btns[finalI].setText(next);
                    }
                    if (btns[up].getText().toString()==next){
                        btns[up].setText(btns[finalI].getText());
                        btns[finalI].setText(next);
                    }
                    if (btns[down].getText().toString()==next){
                        btns[down].setText(btns[finalI].getText());
                        btns[finalI].setText(next);
                    }
                    
                    if(btns[0].getText().equals("1")&&btns[1].getText().equals("2")&&btns[2].getText().equals("3")&&btns[3].getText().equals("4")&&btns[4].getText().equals("5")&&btns[5].getText().equals("6")&&btns[6].getText().equals("7")&&btns[7].getText().equals("8")&&btns[8].getText().equals("9")&&btns[9].getText().equals("10")&&btns[10].getText().equals("11")&&btns[11].getText().equals("12")&&btns[12].getText().equals("13")&&btns[13].getText().equals("14")&&btns[14].getText().equals("15")&&btns[15].getText().equals(next)){

                        
                        Toast.makeText(MainActivity.this, "Congrats", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

    }

    public void setShuffleBtn (String next){
        int n=15;
        int arr[]=new  int[n];
        for (int z=0;z<n;z++){
            arr[z]=z;

        }

        int result[]=new  int[n];
        int x= n;
        SecureRandom rd= new SecureRandom();
        for (int z=0 ; z<n;z++) {
            int k = rd.nextInt(x);
            result[z] = arr[k];
            arr[k] = arr[x - 1];
            x--;
        }
        for (int i =0;i<result.length;i++) {
           // Toast.makeText(MainActivity.this, " " + result[i], Toast.LENGTH_SHORT).show();
            Button []buttons = {Btn1,Btn2,Btn3,Btn4,Btn5,Btn6,Btn7,Btn8,Btn9,Btn10,Btn11,Btn12,Btn13,Btn14,Btn15,Btn16};
            buttons[i].setText(""+(result[i]+1));
            buttons[15].setText(next);

        }
    }

    private void runTimer()
    {
        // Get the text view.
        final TextView timeView
                = (TextView)findViewById(
                R.id.textView);

        // Creates a new Handler
        final Handler handler
                = new Handler();

        // Call the post() method,
        // passing in a new Runnable.
        // The post() method processes
        // code without a delay,
        // so the code in the Runnable
        // will run almost immediately.
        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                // Format the seconds into hours, minutes,
                // and seconds.
                String time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs);

                // Set the text view text.
                timeView.setText(time);

                // If running is true, increment the
                // seconds variable.
                if (running) {
                    seconds++;
                }

                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 1000);
            }
        });

}
}