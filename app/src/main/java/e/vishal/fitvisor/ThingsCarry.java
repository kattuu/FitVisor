package e.vishal.fitvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ThingsCarry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_carry);
        TextView textView =(TextView)findViewById(R.id.txt_things_carry);
        textView.setText(MyStrings.Thingscarry);
    }
}
