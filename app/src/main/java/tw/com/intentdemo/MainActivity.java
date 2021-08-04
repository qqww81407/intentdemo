package tw.com.intentdemo;
// intent 頁面跳轉
// 可以把值給其他頁
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button intentbtn1,intentbtn2,intentbtn3,intentbtn4,intentbtn5,intentbtn7;
    private EditText name,age;
    private TextView txtprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews(){
        intentbtn1 = findViewById(R.id.intentbtn1);
        intentbtn2 = findViewById(R.id.intentbtn2);
        intentbtn3 = findViewById(R.id.intentbtn3);
        intentbtn4 = findViewById(R.id.intentbtn4);
        intentbtn5 = findViewById(R.id.intentbtn5);


        name = findViewById(R.id.username);
        age = findViewById(R.id.userage);

        intentbtn7 = findViewById(R.id.intentbtn7);
        txtprice = findViewById(R.id.txtprice);


        intentbtn1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        });

        intentbtn2.setOnClickListener(v -> {

            Uri uri = Uri.parse("tel:");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);

        });

        intentbtn3.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });

        intentbtn4.setOnClickListener(v -> {

            Uri uri = Uri.parse("http://www.google.com.tw");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        });

        //多變數傳送 -> 用bundle打包一起傳送
        /*intentbtn5.setOnClickListener(v -> {
            String Uname = name.getText().toString();
            int Uage=Integer.parseInt(age.getText().toString());

            Bundle bundle = new Bundle(); //把數值打包在bundle 一起傳送
            bundle.putString("username",Uname);
            bundle.putInt("usage",Uage);

            Intent intent = new Intent(MainActivity.this,MainActivity2.class);

            intent.putExtras(bundle);//把值帶入

            startActivity(intent);


        });*/
        //單一變數傳送 個別傳送
        intentbtn5.setOnClickListener(v -> {
            String Uname = name.getText().toString();

            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("name",Uname);
            startActivity(intent); //不關閉 等下一頁結束 跳回


        });


        intentbtn7.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,MainActivity3.class);
            //跳至第三頁
            startActivityForResult(intent,101);
        });
    }

    //以前的做法
    protected void onActivityResult(int requestCode, int ResultCode, Intent data) {
        super.onActivityResult(requestCode, ResultCode, data);
        if(requestCode != 101){
            return;
        }
        switch(ResultCode) {
            case RESULT_OK:

                Bundle bundle = data.getExtras();
                int price = bundle.getInt("Price");
                String product = bundle.getString("Product");
                Double pi = bundle.getDouble("pi");
                txtprice.setText(product+'-'+price+'-'+pi);
                break;

            case RESULT_CANCELED:
                txtprice.setText("取消了");
                break;
        }
    }
}