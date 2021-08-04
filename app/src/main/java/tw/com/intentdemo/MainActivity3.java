package tw.com.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    private Button btnsend,btncancel;
    private EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        findView();
    }

    private void findView(){
        price = findViewById(R.id.edtprice);
        btnsend = findViewById(R.id.btnsend);
        btncancel = findViewById(R.id.btncancel);



        btnsend.setOnClickListener(v -> {
            Intent intent = new Intent(); //回送Intent()不需要填值
            Bundle bundle = new Bundle();
            bundle.putInt("Price",Integer.parseInt(price.getText().toString()));
            bundle.putString("Product","iphone13");
            bundle.putDouble("pi",3.1415026);

            intent.putExtras(bundle);

            setResult(RESULT_OK,intent); //回傳結果

            finish();


        });

        btncancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED); //刪除結果回傳
            finish();
        });

    }
}