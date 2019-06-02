package com.example.realchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] mobileArray = {"QwyFteAahHpzv1UB"};
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
        try {
            Intent intent = new Intent(this, ChatActivity.class);

            TextView temp = (TextView) view;
            EditText inputEditText = (EditText) findViewById(R.id.inputEditText);

            String channel = temp.getText().toString();
            String name = inputEditText.getText().toString();

            Bundle extras = new Bundle();
            extras.putString(Constants.EXTRA_CHANNEL_ID, channel);
            extras.putString(Constants.USERNAME, name);

            intent.putExtras(extras);
            startActivity(intent);
        } catch(Exception e) {
            Log.e(Constants.TAG, "chooseChannel: " + e);
        }
    }

}
