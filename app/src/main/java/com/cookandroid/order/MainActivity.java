package com.cookandroid.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton radioArray[] = new RadioButton[3];
    int [] menuID = {R.id.menu1, R.id.menu2, R.id.menu3};
    int [] draw={R.drawable.sea_pasta,R.drawable.tomato_pasta, R.drawable.cream_pasta  };
    RadioGroup Rgroup;
    Button finish;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[심이진]파스타 전문점");
        finish=findViewById(R.id.finish);
        img=findViewById(R.id.img);
        Rgroup = findViewById(R.id.Rgroup);

       for(int i=0; i<radioArray.length; i++){
           radioArray[i]=findViewById(menuID[i]);
           final int index = i;
           radioArray[index].setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   img.setImageResource(draw[index]);
               }
           });
       }

       finish.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               switch (Rgroup.getCheckedRadioButtonId()){
                   case R.id.menu1:
                       Toast.makeText(getApplicationContext(), radioArray[0].getText().toString()+"\n주문하셨습니다", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.menu2:
                       Toast.makeText(getApplicationContext(), radioArray[1].getText().toString()+"\n주문하셨습니다", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.menu3:
                       Toast.makeText(getApplicationContext(), radioArray[2].getText().toString()+"\n주문하셨습니다", Toast.LENGTH_SHORT).show();
                       break;
                       default:
                           Toast.makeText(getApplicationContext(), "메뉴를 먼저 선택해주세요", Toast.LENGTH_SHORT).show();
               }
           }
       });
    }
}
