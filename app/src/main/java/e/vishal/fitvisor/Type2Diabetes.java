package e.vishal.fitvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Type2Diabetes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type2_diabetes);
        TextView textView =(TextView)findViewById(R.id.txt_diabetes);
        textView.setText(MyStrings.diabetes);
    }
}
