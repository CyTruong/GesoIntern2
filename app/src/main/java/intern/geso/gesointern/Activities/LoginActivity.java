package intern.geso.gesointern.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import intern.geso.gesointern.R;

public class LoginActivity extends AppCompatActivity {
        Button loginbt;
        EditText edtusername,edtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Init();
        Setaction();
    }

    public void Setaction() {
        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();  
            }
        });
    }

    private void Login() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void Init(){
        loginbt = findViewById(R.id.login_bt);
        edtusername = findViewById(R.id.login_username);
        edtpass = findViewById(R.id.login_pass);
    }
}
