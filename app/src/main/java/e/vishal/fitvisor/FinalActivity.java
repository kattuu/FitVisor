package e.vishal.fitvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class FinalActivity extends AppCompatActivity implements PaymentResultListener {

    RadioButton radOne, radTwo, radThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Checkout.preload(getApplicationContext());

        Button btnWorkOut = findViewById(R.id.btn_get_workout);
        Button btnDiet = findViewById(R.id.btn_get_diet);

        radOne = findViewById(R.id.rad_one);
        radTwo = findViewById(R.id.rad_two);
        radThree = findViewById(R.id.rad_three);

        String issue = getIntent().getStringExtra("issue");
        switch (issue) {
            case "Diabetes":
                radOne.setText("FitDiabetes");
                radTwo.setText("FitHtn");
                radThree.setText("FitThyroid");
                break;
            case "Hypertension":
                radOne.setText("FitHtn");
                radTwo.setText("FitDiabetes");
                radThree.setText("FitThyroid");
                break;
            case "Thyroid":
                radOne.setText("FitThyroid");
                radTwo.setText("FitHtn");
                radThree.setText("FitDiabetes");
                break;
        }

        btnWorkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayment();
            }
        });

        btnDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayment();
            }
        });
    }

    private void startPayment() {
        Checkout checkout = new Checkout();
        checkout.setImage(R.mipmap.icon);

        try {
            JSONObject options = new JSONObject();
            options.put("name", getString(R.string.app_name));
            options.put("description", "Monthly Fees");
            options.put("currency", "INR");
            options.put("amount", "50000");
            checkout.open(this, options);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(getApplicationContext(), "Payment Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(), "Payment Error!!", Toast.LENGTH_SHORT).show();
    }
}
