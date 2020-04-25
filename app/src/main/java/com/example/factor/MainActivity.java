package com.example.factor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    private static final long COUNTDOWN_IN_MILLIS =10000;
    private Button button1, button2, button3, submit;
    private EditText number;
    private TextView countdown, score;
    private int num, nFac1, nFac2, check;
    private int wrong = Color.argb(255, 255, 0, 0);
    private int right = Color.argb(255, 0, 255, 0);
    private ColorStateList colorDefault;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private int displayScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countdown = (TextView) findViewById(R.id.countdown);

        score = (TextView) findViewById(R.id.score);

        button1 = (Button) findViewById(R.id.button1);

        button2 = (Button) findViewById(R.id.button2);

        button3 = (Button) findViewById(R.id.button3);

        submit = (Button) findViewById(R.id.submit);

        number = (EditText) findViewById(R.id.number);

        colorDefault = countdown.getTextColors();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeLeftInMillis = COUNTDOWN_IN_MILLIS;
                startCountDown();
                num = Integer.parseInt(number.getText().toString());
                check = (int) (Math.random() * 3);
                nFac1 = NotFactor(num);
                nFac2 = NotFactor(num);
                if (nFac1 != nFac2) {
                    switch (check) {
                        case 0:
                            button1.setText(String.valueOf(FindFactor(num)));
                            button2.setText(String.valueOf(nFac1));
                            button3.setText(String.valueOf(nFac2));
                            button1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "Correct Answer", LENGTH_SHORT).show();
                                    button1.setBackgroundColor(right);
                                    displayScore+=1;
                                    score.setText(Integer.toString(displayScore));
                                    NextQuestion();
                                }
                            });
                            button2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "Wrong Answer", LENGTH_SHORT).show();
                                    button1.setBackgroundColor(right);
                                    button2.setBackgroundColor(wrong);
                                    NextQuestion();
                                }
                            });
                            button3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "Wrong Answer", LENGTH_SHORT).show();
                                    button1.setBackgroundColor(right);
                                    button3.setBackgroundColor(wrong);
                                    NextQuestion();
                                }
                            });
                            break;
                        case 1:
                            button2.setText(String.valueOf(FindFactor(num)));
                            button1.setText(String.valueOf(nFac1));
                            button3.setText(String.valueOf(nFac2));
                            button2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "Correct Answer", LENGTH_SHORT).show();
                                    button2.setBackgroundColor(right);
                                    displayScore+=1;
                                    score.setText(Integer.toString(displayScore));
                                    NextQuestion();
                                }
                            });
                            button1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "Wrong Answer", LENGTH_SHORT).show();
                                    button2.setBackgroundColor(right);
                                    button1.setBackgroundColor(wrong);
                                    NextQuestion();
                                }
                            });
                            button3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "Wrong Answer", LENGTH_SHORT).show();
                                    button2.setBackgroundColor(right);
                                    button3.setBackgroundColor(wrong);
                                    NextQuestion();
                                }
                            });
                            break;
                        case 2:
                            button3.setText(String.valueOf(FindFactor(num)));
                            button1.setText(String.valueOf(nFac1));
                            button2.setText(String.valueOf(nFac2));
                            button3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "Correct Answer", LENGTH_SHORT).show();
                                    button3.setBackgroundColor(right);
                                    displayScore+=1;
                                    score.setText(Integer.toString(displayScore));
                                    NextQuestion();
                                }
                            });
                            button2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "Wrong Answer", LENGTH_SHORT).show();
                                    button3.setBackgroundColor(right);
                                    button2.setBackgroundColor(wrong);
                                    NextQuestion();
                                }
                            });
                            button1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "Wrong Answer", LENGTH_SHORT).show();
                                    button3.setBackgroundColor(right);
                                    button1.setBackgroundColor(wrong);
                                    NextQuestion();
                                }
                            });
                            break;
                        default:

                    }
                }
            }
        });

    }

    public int FindFactor(int num) {
        int i, index = 0, notIndex = 0;
        int arr[] = new int[100];
        for (i = 2; i <= num; i++) {
            if (num % i == 0) {
                arr[index] = i;
                index++;
            }
        }
        if (num == 1) {
            return 1;
        } else {
            return arr[(int) (Math.random() * index)];
        }
    }

    public int NotFactor(int num) {
        int i, notIndex = 0;
        int notArr[] = new int[1000];
        if (num < 5) {
            for (i = 1; i <= 5; i++) {
                if (num % i != 0) {
                    notArr[notIndex] = i;
                    notIndex++;
                }
            }
        } else {
            for (i = 2; i <= num; i++) {
                if (num % i != 0) {
                    notArr[notIndex] = i;
                    notIndex++;
                }
            }
        }
        return notArr[(int) (Math.random() * notIndex)];
    }

    private void NextQuestion() {
        countDownTimer.cancel();
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
        alertdialog.setMessage("Enter another number")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                });
        alertdialog.show();
                    }
    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDown();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDown();
                NextQuestion();
            }
        }.start();
    }
    private void updateCountDown() {
        int minutes = (int) ((timeLeftInMillis/1000) / 60);
        int seconds = (int) ((timeLeftInMillis/1000) % 60);
        String time = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        countdown.setText(time);

        if(timeLeftInMillis < 3000) {
            countdown.setTextColor(Color.RED);
        }
        else{
            countdown.setTextColor(colorDefault);
        }
    }
}