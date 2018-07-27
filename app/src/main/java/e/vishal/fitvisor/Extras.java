package e.vishal.fitvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Extras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);
        final Button MedicalCondition =(Button)findViewById(R.id.medical_condition);
        Button ThingsCarry =(Button)findViewById(R.id.Things_carry);
        final Button SmokeDrink =(Button)findViewById(R.id.smoke_drink);

        MedicalCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent medicalintent =new Intent(getApplicationContext(),MedicalCondition.class);
                startActivity(medicalintent);
            }
        });
        ThingsCarry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thingscarry =new Intent(getApplicationContext(),ThingsCarry.class);
                startActivity(thingscarry);

            }
        });
        SmokeDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smoke =new Intent(getApplicationContext(),SmokeActivity.class);
                startActivity(smoke);
            }
        });

    }
}
