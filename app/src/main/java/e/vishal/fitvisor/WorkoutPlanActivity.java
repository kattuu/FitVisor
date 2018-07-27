package e.vishal.fitvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WorkoutPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plan2);
        TextView workoutplan =(TextView)findViewById(R.id.workout_plan);
        String type = getIntent().getStringExtra("type");
        switch (type){
            case "1a":
                workoutplan.setText(MyStrings.beginnerfatloss_workoutplan);
                break;
            case "1b":
                workoutplan.setText(MyStrings.beginnergain_workoutplan);
                break;
            case "1c":
                workoutplan.setText(MyStrings.beginnerfatloss_workoutplan);
                break;

            case"1d":
                workoutplan.setText(MyStrings.beginnergain_workoutplan);
                break;

            case "2a":
                workoutplan.setText(MyStrings.intermediatefat_workoutplan);
                break;

            case "2b":
                workoutplan.setText(MyStrings.intermediategain_workoutplan);
                break;

            case "2c":
                workoutplan.setText(MyStrings.intermediatefat_workoutplan);
                break;

            case "2d":
                workoutplan.setText(MyStrings.intermediategain_workoutplan);
                break;

            case "3a":
                workoutplan.setText(MyStrings.advancemuscletonning_workoutplan);
                break;
            case "3b":
                workoutplan.setText(MyStrings.advancebuildmusclemass_workoutplan);
                break;

            case "3c":
                workoutplan.setText(MyStrings.advancemuscletonning_workoutplan);
                break;

            case "3d":
                workoutplan.setText(MyStrings.advancebuildmusclemass_workoutplan);
                break;
        }
    }
}
