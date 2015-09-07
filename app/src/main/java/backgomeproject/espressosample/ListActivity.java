package backgomeproject.espressosample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListActivity extends Activity {

    @Bind(R.id.listview)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        List<String> itemList = initData();
        ListAdapter adapter = new ListAdapter(this, itemList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), position + "클릭 이벤트", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private List<String> initData() {

        List<String> dataList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            dataList.add(String.valueOf(i));
        }

        return dataList;
    }


}
