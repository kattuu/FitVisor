package e.vishal.fitvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MedicalCondition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_condition);
        Button diabetes =(Button)findViewById(R.id.diabetes);
        Button high_chelosterol =(Button)findViewById(R.id.high_cholestrerol);
        Button high_bp =(Button)findViewById(R.id.high_bp);

        diabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diabetes =new Intent(getApplicationContext(),Type2Diabetes.class);
                startActivity(diabetes);
            }

        });
        high_chelosterol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent high_ch =new Intent(getApplicationContext(),HighCholesterol.class);
                startActivity(high_ch);
            }
        });
        high_bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent highbp =new Intent(getApplicationContext(),HighBloodPressure.class);
                startActivity(highbp);
            }
        });
    }
}
