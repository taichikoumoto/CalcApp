package taichi.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;

    Float val1;
    Float val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(this);

        Button buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(this);

        Button buttonTimes = findViewById(R.id.buttonTimes);
        buttonTimes.setOnClickListener(this);

        Button buttonDiv = findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String editText1Str = editText1.getText().toString();
        String editText2Str = editText2.getText().toString();

        try {
            val1 = Float.valueOf(editText1Str);
            val2 = Float.valueOf(editText2Str);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "不正な値です", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, ResultActivity.class);
        if (v.getId() == R.id.buttonPlus) {
            intent.putExtra("VALUE", val1 + val2);
        } else if (v.getId() == R.id.buttonMinus) {
            intent.putExtra("VALUE", val1 - val2);
        } else if (v.getId() == R.id.buttonTimes) {
            intent.putExtra("VALUE", val1 * val2);
        } else if (v.getId() == R.id.buttonDiv) {
            if (val2 == 0.0) {
                Toast.makeText(this, "0で割り算はできません", Toast.LENGTH_SHORT).show();
                return;
            }
            intent.putExtra("VALUE", val1 / val2);
        } else {
            Log.d("UI_PARTS", "エラー！");
        }
        startActivity(intent);
    }
}
