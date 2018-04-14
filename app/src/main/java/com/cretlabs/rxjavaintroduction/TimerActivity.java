package com.cretlabs.rxjavaintroduction;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class TimerActivity extends AppCompatActivity {
    Disposable disposable;
    Button start, stop;
    TextView textView;
    private long seconds;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        start = findViewById(R.id.button);
        stop = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        start.setOnClickListener(view -> {
            startTimer();
        });
        stop.setOnClickListener(view -> {
            stopTimer();
        });


    }

    private void stopTimer() {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private void startTimer() {
        disposable = Observable.interval(1, TimeUnit.SECONDS)
                .map((tick) -> {
                    seconds += 1;
                    handler.post(() -> textView.setText(String.format(Locale.getDefault(), "%ds", seconds)));
                    return true;
                }).subscribe();
    }
}
