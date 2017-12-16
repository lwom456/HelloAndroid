package com.example.linwe.h2_layout2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener,ListView.OnItemSelectedListener {
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView text = (TextView) view.findViewById(R.id.Text);
        String name = text.getText().toString();
        Toast.makeText(this,name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView text = (TextView) view.findViewById(R.id.Text);
        String name = text.getText().toString();
        Toast.makeText(this,name, Toast.LENGTH_SHORT).show();
    }

    //取得数据
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







    //自定义布局的AlertDialog
    public void AlertDialog(View view){
        LayoutInflater inflater = LayoutInflater.from(this);
        final View textEntryView = inflater.inflate(
                R.layout.alert, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("ANDROID APP(AlertDialog)");
        builder.setView(textEntryView);
        builder.setPositiveButton("确认",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        builder.show();


//        测试（不使用布局）
//        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//        builder.setTitle("Title");
//        builder.setMessage("Message");
//        builder.setPositiveButton("Button1",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        setTitle("点击了对话框上的Button1");
//                    }
//                });
//        builder.setNeutralButton("Button2",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        setTitle("点击了对话框上的Button2");
//                    }
//                });
//        builder.setNegativeButton("Button3",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        setTitle("点击了对话框上的Button3");
//                    }
//                });
//        builder.show();


//
//        LayoutInflater inflater = LayoutInflater.from(this);
//        final View textEntryView = inflater.inflate(
//                R.layout.dialoglayout, null);
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
    }


    //重写onCreateOptionMenu(Menu menu)方法，当菜单第一次被加载时调用
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // 填充选项菜单（读取XML文件、解析、加载到Menu组件上）
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //重写OptionsItemSelected(MenuItem item)来响应菜单项(MenuItem)的点击事件（根据id来区分是哪个item）
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.m_font:
                // 创建数据
                final String[] item1 = new String[] { "小", "中", "大" };
                // 创建对话框构建器
                final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                // 设置参数
                builder1.setTitle("字体大小")
                        .setSingleChoiceItems(item1, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText test = (EditText) findViewById(R.id.testText);
                                if(which == 0) test.setTextSize(10);
                                if(which == 1) test.setTextSize(16);
                                if(which == 2) test.setTextSize(20);
                            }
                        });
                builder1.create().show();
                break;
            case R.id.m_normal:
                Toast.makeText(this, "这是普通菜单项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_color:
                // 创建数据
                final String[] item3 = new String[] { "红色", "黑色"};
                // 创建对话框构建器
                final AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                // 设置参数
                builder3.setTitle("字体大小")
                        .setSingleChoiceItems(item3, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText test = (EditText) findViewById(R.id.testText);
                                if(which == 0) test.setTextColor(Color.parseColor("#FF0000"));
                                if(which == 1) test.setTextColor(Color.parseColor("#000000"));
                            }
                        });
                builder3.create().show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
