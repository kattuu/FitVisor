package e.vishal.fitvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DietQuestionsActivity extends AppCompatActivity {


    String fitnessGoal,mealType,foolSupplements, stringLevel, position;

    RadioButton radFatLoss,radWeightGain,radMuscleBuilding;
    RadioGroup grpMeals,grpGoals,grpSupplements;
    View layoutDiabetes, layoutHtn, layoutThyroid;
    Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_questions);

        final int level = getIntent().getIntExtra("LEVEL", -1);
        TextView levelText = (TextView) findViewById(R.id.txt_level);
        position = getIntent().getStringExtra("WEIGHT");

        layoutDiabetes = findViewById(R.id.layout_diabetes);
        layoutHtn = findViewById(R.id.layout_htn);
        layoutThyroid = findViewById(R.id.layout_thyroid);
        btnProceed = findViewById(R.id.btn_get_workout);


        radFatLoss = (RadioButton) findViewById(R.id.rad_fat_loss);
        radWeightGain = (RadioButton) findViewById(R.id.rad_weight_gain);
        radMuscleBuilding = (RadioButton) findViewById(R.id.rad_muscle_building);


        grpMeals = (RadioGroup) findViewById(R.id.rad_grp_meals);
        grpGoals = (RadioGroup) findViewById(R.id.rad_grp_goals);
        grpSupplements = (RadioGroup) findViewById(R.id.rad_grp_suppl);

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fitnessGoal == null) {
                    Toast.makeText(getApplicationContext(), "Select your issue!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                switch (fitnessGoal){
                    case "Diabetes":
                    case "Hypertension":
                    case "Thyroid":
                        startActivity(new Intent(DietQuestionsActivity.this, FinalActivity.class)
                                .putExtra("issue", fitnessGoal));
                        break;
                    default:
                        break;
                }
            }
        });


        grpGoals.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rad_fat_loss: // Diabetes
                        fitnessGoal = "Diabetes";
                        layoutDiabetes.setVisibility(View.VISIBLE);
                        layoutHtn.setVisibility(View.GONE);
                        layoutThyroid.setVisibility(View.GONE);
                        break;
                    case R.id.rad_weight_gain: // Hypertension
                        fitnessGoal = "Hypertension";
                        layoutDiabetes.setVisibility(View.GONE);
                        layoutHtn.setVisibility(View.VISIBLE);
                        layoutThyroid.setVisibility(View.GONE);
                        break;
                    case R.id.rad_muscle_building: // Thyroid
                        fitnessGoal = "Thyroid";
                        layoutDiabetes.setVisibility(View.GONE);
                        layoutHtn.setVisibility(View.GONE);
                        layoutThyroid.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });


        grpMeals.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rad_veg:
                        mealType = "Vegetarian";
                        break;
                    case R.id.rad_non_veg:
                        mealType = "NonVegetarian";
                        break;
                }
            }
        });

        grpSupplements.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rad_yes:
                        foolSupplements = "true";
                        break;
                    case R.id.rad_no:
                        foolSupplements = "false";
                        break;

                }
            }
        });



        if(level == 0){
            stringLevel = "BEGINNER";

        }
        else if(level == 1){
            stringLevel = "INTERMEDIATE";

        }
        else {
            stringLevel = "ADVANCED";


        }

        levelText.setText(stringLevel);

        findViewById(R.id.btn_get_diet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (fitnessGoal == null || foolSupplements == null || mealType == null){
                    return;
                }
               else if (fitnessGoal.equals("Fat Loss") || fitnessGoal.equals("Muscle Building") || fitnessGoal.equals("Strength Building")|| fitnessGoal.equals("Muscle Toning") ){

                    if (level == 0){
                        Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                        intent.putExtra("type","1a");

                        startActivity(intent);

                        return;



                    }else if (level == 1){
                        Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                        intent.putExtra("type","2a");

                        startActivity(intent);
                        return;



                    }else if(level == 2){
                        Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                        intent.putExtra("type","3a");

                        startActivity(intent);
                        return;



                    }


                }
                else if(fitnessGoal.equals("Weight Gain") || fitnessGoal.equals("Build Muscle Mass")){
                    if(level==0){
                        Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                        intent.putExtra("type","1b");

                        startActivity(intent);
                        return;


                    }
                   else if (level==1){
                        Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                        intent.putExtra("type","2b");

                        startActivity(intent);
                        return;


                    }
                    else if(level==2){
                        Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                        intent.putExtra("type","3b");

                        startActivity(intent);
                        return;


                    }
                    if (fitnessGoal == null || foolSupplements == null || mealType == null){
                        return;
                    }
                   else if (fitnessGoal.equals("Fat Loss") || fitnessGoal.equals("Muscle Building") || fitnessGoal.equals("Strength Building")|| fitnessGoal.equals("Muscle Toning")){

                        if (level == 0){
                            Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                            intent.putExtra("type","1c");
                            if(mealType.equals("Vegetarian")){
                            startActivity(intent);}
                            return;



                        }else if (level == 1){
                            Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                            intent.putExtra("type","2c");
                            if(mealType.equals("Vegetarian")){
                            startActivity(intent);}
                            return;



                        }else if(level == 2){
                            Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                            intent.putExtra("type","3c");
                            if(mealType.equals("Vegetarian")){
                            startActivity(intent);}
                            return;



                        }



                    }
                    else if((fitnessGoal.equals("Weight Gain") || fitnessGoal.equals("Build Muscle Mass"))){
                        if (level == 0){
                            Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                            intent.putExtra("type","1d");
                            if(mealType.equals("Vegetarian")){
                            startActivity(intent);}
                            return;



                        }else if (level == 1){
                            Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                            intent.putExtra("type","2d");
                            if(mealType.equals("Vegetarian")){
                            startActivity(intent);}
                            return;



                        }else if(level == 2){
                            Intent intent = new Intent(DietQuestionsActivity.this,DietPlanActivity.class);
                            intent.putExtra("type","3d");
                            if(mealType.equals("Vegetarian")){
                            startActivity(intent);}
                            return;



                        }

                    }

                }

            }
        });
        findViewById(R.id.btn_get_workout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (fitnessGoal == null || foolSupplements == null || mealType == null){
                    return;
                }
                else if (fitnessGoal.equals("Fat Loss") || fitnessGoal.equals("Muscle Building") || fitnessGoal.equals("Strength Building")|| fitnessGoal.equals("Muscle Toning")){

                    if (level == 0){
                        Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                        intent.putExtra("type","1a");
                        startActivity(intent);



                    }else if (level == 1){
                        Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                        intent.putExtra("type","2a");
                        startActivity(intent);



                    }else if(level == 2){
                        Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                        intent.putExtra("type","3a");
                        startActivity(intent);



                    }


                }
                else if(fitnessGoal.equals("Weight Gain") || fitnessGoal.equals("Build Muscle Mass")){
                    if(level==0){
                        Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                        intent.putExtra("type","1b");
                        startActivity(intent);


                    }
                    else if (level==1){
                        Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                        intent.putExtra("type","2b");
                        startActivity(intent);


                    }
                    else if(level==2){
                        Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                        intent.putExtra("type","3b");
                        startActivity(intent);


                    }
                    if (fitnessGoal == null || foolSupplements == null || mealType == null){
                        return;
                    }
                    else if (fitnessGoal.equals("Fat Loss") || fitnessGoal.equals("Muscle Building") || fitnessGoal.equals("Strength Building")|| fitnessGoal.equals("Muscle Toning")){

                        if (level == 0){
                            Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                            intent.putExtra("type","1c");
                            startActivity(intent);



                        }else if (level == 1){
                            Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                            intent.putExtra("type","2c");
                            startActivity(intent);



                        }else if(level == 2){
                            Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                            intent.putExtra("type","3c");
                            startActivity(intent);



                        }



                    }
                    else if((fitnessGoal.equals("Weight Gain") || fitnessGoal.equals("Build Muscle Mass"))){
                        if (level == 0){
                            Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                            intent.putExtra("type","1d");
                            startActivity(intent);



                        }else if (level == 1){
                            Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                            intent.putExtra("type","2d");
                            startActivity(intent);



                        }else if(level == 2){
                            Intent intent = new Intent(DietQuestionsActivity.this,WorkoutPlanActivity.class);
                            intent.putExtra("type","3d");
                            startActivity(intent);



                        }

                    }

                }

            }
        });



    }
}
