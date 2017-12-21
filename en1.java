package sms.dbz.com.secretmessageservice;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class en1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_en1);
        EditText et2=(EditText)findViewById(R.id.editText2);
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            String ct=extras.getString("CIPH_TEXT");
            et2.setText(ct);
        }
         Button b1=(Button)findViewById(R.id.button4);
        Button b2=(Button)findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Bundle extras=getIntent().getExtras();
                String ct=extras.getString("CIPH_TEXT");
                Intent i=new Intent(getBaseContext(),en2.class);
                i.putExtra("CT",ct);
                startActivity(i);
            }


        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String ct = extras.getString("CIPH_TEXT");
                Intent i = new Intent(getBaseContext(), en3.class);
                i.putExtra("CT", ct);
                startActivity(i);
            }});
        Button btw=(Button)findViewById(R.id.button9);
                btw.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PackageManager pm = getPackageManager();
                        try {

                            Intent waIntent = new Intent(Intent.ACTION_SEND);
                            waIntent.setType("text/plain");
                            Bundle extras=getIntent().getExtras();
                            String ct = extras.getString("CIPH_TEXT");
                            String text = ct;

                            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                            //Check if package exists or not. If not then code
                            //in catch block will be called
                            waIntent.setPackage("com.whatsapp");

                            waIntent.putExtra(Intent.EXTRA_TEXT, text);
                            startActivity(Intent.createChooser(waIntent, "Share with"));

                        } catch (PackageManager.NameNotFoundException e) {
                            Toast.makeText(getBaseContext(), "WhatsApp not Installed", Toast.LENGTH_SHORT)
                                    .show();
                        }

                    }
                   });
                   Button bm=(Button)findViewById(R.id.button10);
                   bm.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent i=new Intent(getBaseContext(),MainActivity.class);
                           i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                           startActivity(i);
                           finish();
                       }
                   });
        Button bd=(Button)findViewById(R.id.button11);
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras=getIntent().getExtras();
                String ct=extras.getString("CIPH_TEXT");
                Intent a=new Intent(getBaseContext(),de1.class);
                a.putExtra("DEDI",ct);
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);
                   finish();
            }
        });

            }







    }





