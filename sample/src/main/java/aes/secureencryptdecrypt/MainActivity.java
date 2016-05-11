package aes.secureencryptdecrypt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import rage.aes.secureencryptanddecrypt.SecureMyText;

public class MainActivity extends AppCompatActivity {

    private static EditText Text,Pin,EncryptedText,TransferText;
    private static Button Encrypt,DecryptActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text=(EditText)findViewById(R.id.editText);
        Pin=(EditText)findViewById(R.id.editText2);
        EncryptedText=(EditText)findViewById(R.id.editText3);
        TransferText=(EditText)findViewById(R.id.editText4);

        Encrypt=(Button) findViewById(R.id.button);
        DecryptActivity=(Button) findViewById(R.id.button2);


        Encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Text.getText().toString().trim().isEmpty()||Pin.getText().toString().trim().isEmpty()){

                    Toast.makeText(getApplicationContext(),"Text/Pin cant be empty",Toast.LENGTH_LONG).show();

                }else{

                    SecureMyText secure=new SecureMyText(getApplicationContext(),Pin.getText().toString().trim());
                    EncryptedText.setText(secure.encrypt(Text.getText().toString().trim()));
                    TransferText.setText(secure.EncryptToFinalTransferText(Text.getText().toString().trim()));
                }
            }
        });


       DecryptActivity.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this,DecryptActivity.class);
               startActivity(intent);
           }
       });

    }
}

