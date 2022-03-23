package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG= MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE
            = "com.example.android.twoactivities.extra.MESSAGE";

    public static final int TEXT_REQUEST = 1;
    private EditText MessageEditText;
    private TextView ReplyHeadTextView;
    private TextView ReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //log the start of the oncreate
        Log.d(LOG_TAG,"_______");
        Log.d(LOG_TAG,"onCreate");

        //initialization
        MessageEditText = findViewById(R.id.editText_main);
        ReplyHeadTextView = findViewById(R.id.text_header_reply);
        ReplyTextView = findViewById(R.id.text_message_reply);
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            if (isVisible) {
                ReplyHeadTextView.setVisibility(View.VISIBLE);
                ReplyTextView.setText(savedInstanceState
                        .getString("reply_text"));
                ReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (ReplyHeadTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text",
                    ReplyTextView.getText().toString());
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    public void launchSecondActivity(View view){
        Log.d(LOG_TAG,"Button clicked!!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = MessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {

            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                ReplyHeadTextView.setVisibility(View.VISIBLE);
                ReplyTextView.setText(reply);
                ReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}