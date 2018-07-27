package e.vishal.fitvisor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    TextView textBmi;
    TextView textWeight;
    RadioGroup radioTime;
    Button proceedButton;

    private Context mContext;
    private int level = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        textBmi = (TextView) findViewById(R.id.txt_bmi);
        textWeight = (TextView) findViewById(R.id.txt_weight);
        radioTime = (RadioGroup) findViewById(R.id.rad_grp_time);
        proceedButton = (Button) findViewById(R.id.btn_proceed);
        mContext = this;

        Intent intent = getIntent();
        String bmiText = "Your BMI is \n"+intent.getStringExtra("BMI");
        textBmi.setText(bmiText);

        Intent intent1 =getIntent();
        String weightText = "You are "+ intent1.getStringExtra("WEIGHT_LEVEL") +"!";
        textWeight.setText(weightText);

        radioTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId == R.id.rad_none || checkedId == R.id.rad_less_1){
                    level = 0;
                }
                else if(checkedId == R.id.rad_1_to_3){
                    level = 1;
                }
                else {
                    level = 2;
                }
            }
        });

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == -1) return;
                Intent dietIntent = new Intent(mContext, DietQuestionsActivity.class);
                dietIntent.putExtra("LEVEL", level);
                dietIntent.putExtra("WEIGHT",getIntent().getStringExtra("WEIGHT_LEVEL"));
                startActivity(dietIntent);

            }
        });
    }
}
