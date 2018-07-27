package e.vishal.fitvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SmokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoke);
        TextView textView = (TextView)findViewById(R.id.txt_smoke);
        textView.setText(MyStrings.Smoke);
        //textView.setTypeface(null, Typeface.BOLD);
    }
}
