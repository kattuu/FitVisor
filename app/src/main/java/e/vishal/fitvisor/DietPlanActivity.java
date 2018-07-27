package e.vishal.fitvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DietPlanActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan);


        TextView textView = (TextView) findViewById(R.id.txt_diet_plan);
        //TextView textView1 =(TextView)findViewById(R.id.txt_workout_plan);
        TextView textView2 =(TextView)findViewById(R.id.txt_diet_plan1);
        //TextView textView3 =(TextView)findViewById(R.id.txt_workout_plan1);
        Button extrabutton =(Button)findViewById(R.id.button_extra);
        //TextView textView4 =(TextView)findViewById(R.id.txt_margin);
        extrabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent extraintent = new Intent( getApplicationContext(),Extras.class);
                startActivity(extraintent);


            }
        });




        String type = getIntent().getStringExtra("type");
        switch (type){
            case "1a":
                textView.setText(MyStrings.beginnerFatLoss);
                //textView1.setText(MyStrings.beginnerfatloss_workoutplan);
                break;
            case "1b":
                textView.setText(MyStrings.beginnerGain);
                //textView1.setText(MyStrings.beginnergain_workoutplan);
                break;
            case "1c":
                textView.setText(MyStrings.veg_diet);
                //textView1.setText(MyStrings.beginnerfatloss_workoutplan);
                break;
            case"1d":
                textView.setText(MyStrings.veg_diet);
                //textView1.setText(MyStrings.beginnergain_workoutplan);
                break;

            case "2a":
                textView.setText(MyStrings.intermediateFatLoss);
                //textView1.setText(MyStrings.intermediatefat_workoutplan);
                break;
            case "2b":
                textView.setText(MyStrings.intermediateGain);
                //textView1.setText(MyStrings.intermediategain_workoutplan);
                break;
            case "2c":
                textView.setText(MyStrings.veg_diet);
                //textView1.setText(MyStrings.intermediatefat_workoutplan);
                break;
            case "2d":
                textView.setText(MyStrings.veg_diet);
                //textView1.setText(MyStrings.intermediategain_workoutplan);
                break;

            case "3a":
                textView.setText(MyStrings.advancemuscletonning);
                //textView1.setText(MyStrings.advancemuscletonning_workoutplan);
                break;
            case "3b":
                textView.setText(MyStrings.advanceBuildmusclemass);
                //textView1.setText(MyStrings.advancebuildmusclemass_workoutplan);
                break;
            case "3c":
                textView.setText(MyStrings.veg_diet);
                //textView1.setText(MyStrings.advancemuscletonning_workoutplan);
                break;
            case "3d":
                textView.setText(MyStrings.veg_diet);
                //textView1.setText(MyStrings.advancebuildmusclemass_workoutplan);
                break;
        }



    }
}
