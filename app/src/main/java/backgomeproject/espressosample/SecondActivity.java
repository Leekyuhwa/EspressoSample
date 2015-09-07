package backgomeproject.espressosample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SecondActivity extends Activity {

    private static final String INTENT_KEY = "input";

    @Bind(R.id.resultView)
    protected TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);
        processIntent(getIntent());

    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            CharSequence input = getIntent().getCharSequenceExtra(INTENT_KEY);
            textView.setText(input);
        }
    }
}
