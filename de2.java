package sms.dbz.com.secretmessageservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class de2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de2);
        Bundle extras=getIntent().getExtras();
        TextView etf=(TextView)findViewById(R.id.textView2);
        if(extras!=null){
            String pt=extras.getString("PLA_TEXT");
            etf.setText(pt);
        }
        Button be=(Button)findViewById(R.id.button12);
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });
    }
}
