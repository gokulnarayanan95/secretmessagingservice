package sms.dbz.com.secretmessageservice; /**
 * Created by kcarj on 20-03-2016.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import sms.dbz.com.secretmessageservice.de1;

public class ReceiveSMS extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {/*

        Bundle bundle=intent.getExtras();
        SmsMessage[] msgs=null;
        String str="";
        if(bundle!=null)
        {
            Object[] pdus=(Object[])bundle.get("pdus");
            msgs=new SmsMessage[pdus.length];
            for(int i=0;i<msgs.length;i++)
            {
                msgs[i]=SmsMessage.createFromPdu((byte[]) pdus[i]);
                str+=msgs[i].getMessageBody().toString();
                str+="\n";
            }
            Toast.makeText(context,"sms Received:"+str,Toast.LENGTH_SHORT).show();
            Intent i=new Intent();
            i.setAction("SMS_RECEIVED_ACTION");
            i.putExtra("rec", str);
            context.sendBroadcast(i);


        }
*/Bundle myBundle = intent.getExtras();
        SmsMessage [] messages = null;
        String strMessage = "";
        String mc=" ";
        if (myBundle != null)
        {
            Object [] pdus = (Object[]) myBundle.get("pdus");

            messages = new SmsMessage[pdus.length];

            for (int i = 0; i < messages.length; i++)
            {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String format = myBundle.getString("format");
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                }
                else {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                strMessage += "SMS From: " + messages[i].getOriginatingAddress();
                strMessage += " : ";
                strMessage += messages[i].getMessageBody();
                strMessage += "\n";
                mc=mc+messages[i].getMessageBody();
            }

            Log.e("SMS", strMessage);
            Toast.makeText(context, strMessage, Toast.LENGTH_LONG).show();
            Intent v=new Intent(context,de1.class);
            v.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            v.putExtra("rec",mc);
            context.startActivity(v);

            Intent i=new Intent();
            i.setAction("SMS_RECEIVED_ACTION");
            i.putExtra("rec", mc);
            context.sendBroadcast(i);
        }

    }
}