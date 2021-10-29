package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView tv_meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_meal = findViewById(R.id.tv_meal);
        btn = findViewById(R.id.btn_choice);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, Main2Activity.class), 1);
            }
        });
    }
 /*
        int value1 = 123;
        String value2 = "123";

        Bundle bundle = new Bundle();
        bundle.putInt("value1",value1);
        bundle.putString("value2",value2);

        Intent intent = new Intent(this,Main2Activity.class);
        int requestCode = 100;
        startActivityForResult(intent, requestCode);
        */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) return;

        if (requestCode == 1) {
            if (resultCode == 101) {
                Bundle b = data.getExtras();
                String str1 = b.getString("drink");
                String str2 = b.getString("sugar");
                String str3 = b.getString("ice");
                tv_meal.setText(String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n",
                        str1,
                        str2,
                        str3));
            }
             /*   case 100:
                    if(resultCode == 0)
                    {
                        Bundle bundle = data.getExtras().getBundle("key");
                        int value1 = bundle.getInt("value1");
                        String value2 = bundle.getString("value2");
                    }else(
                            //Do Something
                            )
                            break;
                default:
                    break;
            }
        }
        intent.putExtra("key",bundle);
        startActivities(intent);


              */
        }
    }
}