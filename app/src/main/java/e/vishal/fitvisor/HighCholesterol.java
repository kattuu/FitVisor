package e.vishal.fitvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HighCholesterol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_cholesterol);
        TextView textView =(TextView)findViewById(R.id.txt_cholesterol);
        textView.setText(MyStrings.highcholesterol);
    }
}
