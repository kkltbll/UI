# UI
@[TOC](UI组件)UI组件

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190331224310428.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNTg1ODAx,size_16,color_FFFFFF,t_70)
# 一、Android ListView的用法

    // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.active_listview,
                new String[]{"header", "images"},
                new int[]{R.id.header, R.id.images});
        android.widget.ListView list = (android.widget.ListView) findViewById(R.id.mylist);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190331224341584.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNTg1ODAx,size_16,color_FFFFFF,t_70)
#二创建自定义布局的AlertDialog


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view2 = View.inflate(alertDialog.this, R.layout.activity_alert_dialog, null);
        final EditText username = (EditText) view2.findViewById(R.id.username);
        final EditText password = (EditText) view2.findViewById(R.id.password);
        final Button button = (Button) view2.findViewById(R.id. btn_login);
        final Button button1 = (Button) view2.findViewById(R.id.btn_cancel);
        builder.setTitle("Android App").setIcon(R.drawable.header_logo).setView(view2);
        /*TextView title = new TextView(this);
        title.setPadding(10, 10, 10, 10);//边距
        title.setTextColor(Color.parseColor("#FFE4C4"));//字体的颜色
        title.setTextSize(23);//字体的大小
        builder.setTitle("Android App").setView(view2);*/
        final AlertDialog alertDialog1 = builder.create();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString().trim();
                String psd = password.getText().toString().trim();
                int duration1 = Toast.LENGTH_LONG;
                if(uname.equals("lqh") && psd.equals("123")){
                    Toast toast=Toast.makeText(alertDialog.this,"登录成功!" , duration1);
                    toast.show();
                }
                Toast toast=Toast.makeText(alertDialog.this,"登录失败!" , duration1);
                toast.show();
                alertDialog1.dismiss();
            }
        });
        alertDialog1.show();

    }

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190331224504119.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNTg1ODAx,size_16,color_FFFFFF,t_70)


#三、使用XML定义菜单 
public boolean onCreateOptionsMenu(Menu menu)//开发选项菜单重写的方法
    {
        MenuInflater inflater = new MenuInflater(this);//菜单动态加载类
        inflater.inflate(R.menu.menu,menu);//调用inflate方法解析菜单文件
        super.onCreateOptionsMenu(menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem mi){
        txt = (TextView)findViewById(R.id.txt);
        switch (mi.getItemId()){
            case R.id.font_10:
                txt.setTextSize(20);
                break;
            case R.id.font_16:
                txt.setTextSize(32);
                break;
            case R.id.font_20:
                txt.setTextSize(40);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                break;
            case R.id.black_font:
                txt.setTextColor(Color.BLACK);
                break;
            case R.id.plain_item:
                Toast toast =Toast.makeText(menu.this,"这是普通单击项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190331224619895.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNTg1ODAx,size_16,color_FFFFFF,t_70)


#四、创建上下文操作模式(ActionMode)的上下文菜单

 protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.actionmode);

        listView=(ListView)findViewById(R.id.lv);

        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.actionmode1,new String[]{"pic","text"},new int[]{R.id.iv,R.id.tv});

        listView.setAdapter(simpleAdapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {



            @Override

            public void onItemCheckedStateChanged(ActionMode mode, int position,

                                                  long id, boolean checked) {

                // Here you can do something when items are selected/de-selected,

                // such as update the title in the CAB

                mode.setTitle(listView.getCheckedItemCount()+" selected");



            }



            @Override

            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                // Respond to clicks on the actions in the CAB

                switch (item.getItemId()) {

                    case R.id.i1:





                        //deleteSelectedItems();

                        mode.finish(); // Action picked, so close the CAB



                        return true;

                    default:

                        return false;

                }

            }



            @Override

            public boolean onCreateActionMode(ActionMode mode, Menu menu) {

                // Inflate the menu for the CAB

                MenuInflater inflater = mode.getMenuInflater();

                inflater.inflate(R.menu.mode, menu);





                return true;

            }



            @Override

            public void onDestroyActionMode(ActionMode mode) {

                // Here you can make any necessary updates to the activity when

                // the CAB is removed. By default, selected items are deselected/unchecked.

            }



            @Override

            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

                // Here you can perform updates to the CAB due to

                // an invalidate() request

                return false;

            }

        });



    }

    private List<Map<String,Object>> getData(){

        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();

        Map<String,Object> map=new HashMap<String, Object>() ;

        map.put("pic",R.mipmap.ic_launcher_round);

        map.put("text","One");

        list.add(map);

        map=new HashMap<String, Object>();

        map.put("pic",R.mipmap.ic_launcher_round);

        map.put("text","Two");

        list.add(map);

        map=new HashMap<String, Object>();

        map.put("pic",R.mipmap.ic_launcher_round);

        map.put("text","Three");

        list.add(map);

        map=new HashMap<String, Object>();

        map.put("pic",R.mipmap.ic_launcher_round);

        map.put("text","Four");

        list.add(map);

        map=new HashMap<String, Object>();

        map.put("pic",R.mipmap.ic_launcher_round);

        map.put("text","Five");

        list.add(map);

        return list;

    }


![在这里插入图片描述](https://img-blog.csdnimg.cn/2019033122475878.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNTg1ODAx,size_16,color_FFFFFF,t_70)
