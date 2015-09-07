package backgomeproject.espressosample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends Activity {

    private static final String INTENT_KEY = "input";

    @Bind(R.id.inputField)
    protected EditText inputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.changeText:
                inputField.setText("LALALA");
                break;
            case R.id.switchActivity:
                intent = new Intent(this, SecondActivity.class);
                intent.putExtra(INTENT_KEY, inputField.getText());
                startActivity(intent);
                break;
            case R.id.switchListActivity :
                intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
        }

    }

}
