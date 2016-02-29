package com.scranol.ajeet.button;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Process;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view){
//       Intent intent = new Intent(this,DisplayMessageActivity.class);
//        EditText editText= (EditText) findViewById(R.id.edit_message);
        checkMyPermission("android.permission.ACCESS_GPS");
        SystemClock.sleep(3000);
        checkMyPermission("android.permission.ACCESS_COARSE_LOCATION");
        SystemClock.sleep(3000);
        checkMyPermission("android.permission.ACCESS_FINE_LOCATION");

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
    private boolean checkMyPermission(String permisssion){
        int pid =Process.myPid();
        int uid = Process.myUid();
        try{
            enforcePermission(permisssion,pid,uid,"Touch not allow");
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, permisssion + "not XXXXXX allow", Toast.LENGTH_LONG).show();
            Log.e("cgm", permisssion + " XXXXXX not allow");
            return false;
        }
        Log.e("cgm",permisssion + " oooooo allow");
        return true;
    }
}
