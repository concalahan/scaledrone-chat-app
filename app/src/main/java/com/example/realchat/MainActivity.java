package com.example.realchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.realchat.MESSAGE";

    String[] mobileArray = {"Java","C++","C#","CSS",
            "HTML","XML",".Net","VisualBasic", "SQL", "Python", "PHP"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);
        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
    }

    /** Called when the user taps the Send button */
    public void chooseChannel(View view) {
        Log.d(Constants.TAG, "chooseChannel:nene ");

        try {
            Intent intent = new Intent(this, ChatActivity.class);

            TextView temp = (TextView) view;
            String channel = temp.getText().toString();

            Log.d(Constants.TAG, "chooseChannel: " + channel);

            String message = "abc";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } catch(Exception e) {
            Log.e(Constants.TAG, "chooseChannel: " + e);
        }
    }

}
