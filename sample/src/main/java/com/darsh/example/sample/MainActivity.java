package com.darsh.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.darsh.multipleimageselect.activities.AlbumSelect2Activity;
import com.darsh.multipleimageselect.helpers.Constants2;
import com.darsh.multipleimageselect.models.Image2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);

        Intent intent = new Intent(MainActivity.this, AlbumSelect2Activity.class);
        intent.putExtra(Constants2.INTENT_EXTRA_LIMIT, 3);
        startActivityForResult(intent, Constants2.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants2.REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            ArrayList<Image2> image2s = data.getParcelableArrayListExtra(Constants2.INTENT_EXTRA_IMAGES);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0, l = image2s.size(); i < l; i++) {
                stringBuffer.append(image2s.get(i).path + "\n");
            }
            textView.setText(stringBuffer.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
