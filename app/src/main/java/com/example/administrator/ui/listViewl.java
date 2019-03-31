package com.example.administrator.ui;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listViewl extends AppCompatActivity implements AdapterView.OnItemClickListener{
//public class listViewl extends Activity {
    private String[] names = new String[]
            {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] imageIds = new int[]
            {R.drawable.lion, R.drawable.tiger
                    , R.drawable.monkey, R.drawable.dog, R.drawable.cat
                    , R.drawable.elephant};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final int color1 = 0xFFC5B5FF;
        final int color2 = 0xFFFFFFFF;
        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", names[i]);
            listItem.put("images", imageIds[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.active_listview,
                new String[]{"header", "images"},
                new int[]{R.id.header, R.id.images});
        android.widget.ListView list = (android.widget.ListView) findViewById(R.id.mylist);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);

        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int flag = 0;
                //  System.out.println(names[position]
                //         + "被单击了");
                switch (flag) {
                    case 0:
                        view.setSelected(true);
                        CharSequence text = names[position];
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(listViewl.this, text, duration);
                        toast.show();
                        flag = 1;
                        break;
                    case 1:
                        view.setSelected(false);
                        CharSequence text1 = names[position];
                        int duration1 = Toast.LENGTH_LONG;
                        Toast toast1 = Toast.makeText(listViewl.this, text1, duration1);
                        toast1.show();
                        flag = 1;
                        break;
                }
            }
        });
    }

    @Override

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

}

