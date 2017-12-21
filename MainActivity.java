package sms.dbz.com.secretmessageservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton imb=(ImageButton)findViewById(R.id.ib);
        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info=new Intent(getBaseContext(),infoactivity.class);
                startActivity(info);
            }
        });
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),en.class);
                startActivity(i);
            }
            }
        );
        Button b1=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),de1.class);
                startActivity(i);
            }
        });

    }

}
