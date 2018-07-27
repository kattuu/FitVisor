package e.vishal.fitvisor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton male,female;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    String gender = null;

    private Context mContext;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        radioGroup = (RadioGroup) findViewById(R.id.rad_grp_mf);
        male = (RadioButton) findViewById(R.id.rad_m);
        female = (RadioButton) findViewById(R.id.rad_f);
        gender = null;

        mAuth =FirebaseAuth.getInstance();
        mAuthListner =new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser()==null){

                    startActivity(new Intent(MainActivity.this,IntroActivity.class) );
                }
            }
        };

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId == R.id.rad_m){
                    gender = "male";
                }else{
                    gender = "female";
                }
            }
        });


        findViewById(R.id.btn_calculate_bmi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gender == null){
                    Toast.makeText(getApplicationContext(),"Select Gender", Toast.LENGTH_SHORT).show();
                    return;
                }
                float age = Float.valueOf(((EditText)findViewById(R.id.edit_age)).getText().toString());
                float weight = Float.valueOf(((EditText)findViewById(R.id.edit_weight)).getText().toString());
                float height = Float.valueOf(((EditText)findViewById(R.id.edit_height)).getText().toString());
                float height_m = height/100.0f;
                float calc_bmi = (weight/(height_m*height_m));
                double calc = (double) Math.round(calc_bmi);
                String bmi = String.valueOf(calc);
                String position = null;

                if (calc<18.5)
                {
                    position ="Underweight";
                }
                else if (calc<24.9 && calc>18.5)
                {
                     position ="Normal";
                }
                else if (calc<29.9 && calc>25)
                   {
                       position ="OverWeight ";

                   }
                else {
                       position ="Obese";
                   }

                Intent intent = new Intent(mContext, BmiActivity.class);
                intent.putExtra("BMI", bmi);
                intent.putExtra("WEIGHT_LEVEL", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mAuth.signOut();
    }
}
