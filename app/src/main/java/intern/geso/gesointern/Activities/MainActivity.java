package intern.geso.gesointern.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import intern.geso.gesointern.R;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fbt;
    ImageButton calenderbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }

    public void Init(){
        fbt = findViewById(R.id.roll_call_fbt);
        calenderbt = findViewById(R.id.btCalender);
        fbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chamcong();
            }
        });
        calenderbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenCalender();
            }
        });
    }

    public void Chamcong(){
        JSONObject jsonbody = new JSONObject();
        try {
            jsonbody.put("user_pkseq",1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://gesointerns.azurewebsites.net/api/chamcong/addchamcong?id=1";
        StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Diem danh thanh cong","diem danh ok ");
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                fbt.setVisibility(View.INVISIBLE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

            }
        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                final Map<String, String> headers = new HashMap<>();
//                headers.put("token", "tokenUser");//put your token here
//                return headers;
//            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();
                headers.put("token", "tokenUser");//put your token here
                return headers;
            }
        };
        queue.add(request);
    }

    public void OpenCalender(){
        Intent intent = new Intent(this,DiemdanhActivity.class);
        this.startActivity(intent);
    }
}
