package sms.dbz.com.secretmessageservice;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class en2 extends AppCompatActivity {
    Button bs;
    EditText et;
    String ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_en2);
        bs = (Button) findViewById(R.id.button6);
        et = (EditText) findViewById(R.id.editText3);
        Bundle extras = getIntent().getExtras();
        ct = extras.getString("CT");
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendSMSMessage();
                /*
                Bundle extras = getIntent().getExtras();
                String ct = extras.getString("CT");
                EditText et = (EditText) findViewById(R.id.editText3);
                String ph = et.getText().toString();


                String SENT = "SMS_SENT";
                String DELIVERED = "SMS_DELIVERED";
                PendingIntent sentPI = PendingIntent.getBroadcast(getBaseContext(), 0, new Intent(SENT), 0);
                PendingIntent deliveredPI = PendingIntent.getBroadcast(getBaseContext(), 0, new Intent(DELIVERED), 0);
                registerReceiver(new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "sms sent", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio Off", Toast.LENGTH_SHORT).show();
                        break;


                }
            }

        }, new IntentFilter(SENT));
                registerReceiver(new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context arg0, Intent arg1) {
                        switch (getResultCode()) {
                            case Activity.RESULT_OK:
                                Toast.makeText(getBaseContext(), "sms delivered", Toast.LENGTH_SHORT).show();
                                break;
                            case Activity.RESULT_CANCELED:
                                Toast.makeText(getBaseContext(), "sms not delivered", Toast.LENGTH_SHORT).show();
                                break;

                        }
                    }
                }), new IntentFilter(DELIVERED);
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(ph, null, ct, sentPI, deliveredPI);

                Intent i=new Intent(Intent.ACTION_VIEW);
                i.putExtra("address","a");
                i.putExtra("sms_body",ct);
                i.setType("vnd.android-dir/mms-sms");
                startActivity(i);*/


            }


        });
    }

    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        String phoneNo = et.getText().toString();
        String message = ct;

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent SUCCESSFULLY", Toast.LENGTH_LONG).show();
            Intent a=new Intent(getBaseContext(),MainActivity.class);
            startActivity(a);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}








