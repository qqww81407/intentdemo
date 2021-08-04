package tw.com.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private Button intentbtn6;
    private TextView infortxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findView();
    }

    private void findView(){
        infortxt = findViewById(R.id.infortxt);
        intentbtn6 = findViewById(R.id.intentbtn6);
        //多變數處理
        /*Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("username");
        int age = bundle.getInt("usage");

        infortxt.setText(name+'-'+age);

         */
        //單變數處理

        String name = getIntent().getStringExtra("name");
        infortxt.setText(name);
        intentbtn6.setOnClickListener(v -> {

            finish(); //關閉此頁
        });


    }
}