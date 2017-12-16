package com.example.linwe.h2_layout2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView mListView;
    private List<Map<String,Object>> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取数据
        List<Map<String,Object>> mData = getData();

        //准备构造SimpleAdapter的参数
        String[] from = new String[]{"pic","text"};
        int[] to = new int[]{R.id.Img, R.id.Text};

        //1.新建数据适配器  // 2.添加数据源到适配器
        SimpleAdapter adapter = new SimpleAdapter(this, mData,R.layout.item, from, to);

        //3.视图加载适配器
        mListView = (ListView) findViewById(R.id.ListView);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }

    public List<Map<String,Object>> getData(){
        mData = new ArrayList<Map<String,Object>>();
        Map<String,Object> itemData;

        itemData = new HashMap<String,Object>();
        itemData.put("pic", R.drawable.cat);
        itemData.put("text", "Cat");
        mData.add(itemData);

        itemData = new HashMap<String,Object>();
        itemData.put("pic", R.drawable.dog);
        itemData.put("text", "Dog");
        mData.add(itemData);

        itemData = new HashMap<String,Object>();
        itemData.put("pic", R.drawable.elephant);
        itemData.put("text", "Elephant");
        mData.add(itemData);

        itemData = new HashMap<String,Object>();
        itemData.put("pic", R.drawable.lion);
        itemData.put("text", "Lion");
        mData.add(itemData);

        itemData = new HashMap<String,Object>();
        itemData.put("pic", R.drawable.monkey);
        itemData.put("text", "Monkey");
        mData.add(itemData);

        itemData = new HashMap<String,Object>();
        itemData.put("pic", R.drawable.tiger);
        itemData.put("text", "Tiger");
        mData.add(itemData);

        return mData;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView text = (TextView) view.findViewById(R.id.Text);
        String name = text.getText().toString();
        Toast.makeText(this,name, Toast.LENGTH_SHORT).show();//吐司1代表long 0代表short
    }

//    public void AlertDialog(View view){
//        LayoutInflater inflater = LayoutInflater.from(this);
//        final View textEntryView = inflater.inflate(
//                R.layout.alert, null);
//        final EditText edtInput=(EditText)textEntryView.findViewById(R.id.edtInput);
//        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setCancelable(false);
//        builder.setIcon(R.drawable.icon);
//        builder.setTitle("Title");
//        builder.setView(textEntryView);
//        builder.setPositiveButton("确认",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        setTitle(edtInput.getText());
//                    }
//                });
//        builder.setNegativeButton("取消",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        setTitle("");
//                    }
//                });
//        builder.show();
//    }
}
