package com.cretlabs.rxjavaintroduction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    AppCompatTextView appCompatTextView;
    Observable<String> observable = Observable.just("Hello ", " World");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appCompatTextView = findViewById(R.id.AM_txt);

      //  showHelloWorld();
     //   showHelloWorldWithOperatorAndMap();
        showHelloWorldWithOperatorAndMapLambda();


    }

    private void showHelloWorldWithOperatorAndMapLambda() {
        Observable.just("Hello, world!")
                .map(s -> s + " -wow")
                .subscribe(i -> appCompatTextView.setText(i));
    }

    private void showHelloWorldWithOperatorAndMap() {
        Observable.just("Hello, world!")
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s + " -wow";
                    }
                })
                .subscribe(i -> appCompatTextView.setText(i));
    }

    private void showHelloWorld() {
        Observable.just("Hello, world! Wow")
                .subscribe(s -> appCompatTextView.setText(s));

        Observable.just("Hello, world!")
                .subscribe(s -> appCompatTextView.setText(String.format("%s wow", s)));
    }
}
