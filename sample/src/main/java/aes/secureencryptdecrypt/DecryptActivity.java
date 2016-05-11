package aes.secureencryptdecrypt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rage.aes.secureencryptanddecrypt.SecureMyText;

public class DecryptActivity extends AppCompatActivity {

    private static EditText EncryptedText,Pin,DecryptedText;
    private static Button Decrypt,EncryptActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);

        EncryptedText =(EditText)findViewById(R.id.editText);
        Pin=(EditText)findViewById(R.id.editText2);
        DecryptedText=(EditText)findViewById(R.id.editText3);


        Decrypt=(Button) findViewById(R.id.button);
        EncryptActivity=(Button) findViewById(R.id.button2);


        Decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EncryptedText.getText().toString().trim().isEmpty()||Pin.getText().toString().trim().isEmpty()){

                    Toast.makeText(getApplicationContext(),"EncryptedText/Pin cant be empty",Toast.LENGTH_LONG).show();

                }else{

                    SecureMyText secure=new SecureMyText(getApplicationContext(),Pin.getText().toString().trim());
                    DecryptedText.setText(secure.decrypt(EncryptedText.getText().toString().trim()));

                }
            }
        });

        EncryptActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DecryptActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                DecryptActivity.this.finish();
            }
        });



    }
}

