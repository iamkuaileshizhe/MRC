package com.neocom.mobilerefueling.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.MyBaseAdapter;
import com.neocom.mobilerefueling.adapter.SortAdapter;
import com.neocom.mobilerefueling.bean.AddressBean;
import com.neocom.mobilerefueling.bean.SortModel;
import com.neocom.mobilerefueling.utils.CharacterParser;
import com.neocom.mobilerefueling.utils.ClearEditText;
import com.neocom.mobilerefueling.utils.JsonFileReader;
import com.neocom.mobilerefueling.utils.PinyinComparator;
import com.neocom.mobilerefueling.view.SideBar;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 城市选择类
 *
 * @author llbt
 */
public class CitySelecterActivity extends Activity {
    private static final String TAG = "CitySelecterActivity";
    private List<AddressBean> provinces;
    private ListView sortListView;
    private SideBar sideBar;
    private TextView dialog;
    private SortAdapter adapter;
    private ClearEditText mClearEditText;
    private List<AddressBean> mReMenCitys;//热门城市列表
    private MyGridViewAdapter gvAdapter;
    private GridView mGridView;
    private RelativeLayout iv_left;

    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    private List<SortModel> SourceDateList;

    /**
     * 根据拼音来排列ListView里面的数据类
     */
    private PinyinComparator pinyinComparator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_city_selecter);
        initData();
        initViews();
    }

    ArrayList<AddressBean> jsonBean;

    private void initData() {

        String JsonData = JsonFileReader.getJson(this, "myjson.json");
        jsonBean = parseData(JsonData);//用Gson 转成实体

        mReMenCitys = new ArrayList<>();
        provinces = new ArrayList<>();

        for (AddressBean pName : jsonBean) {
            provinces.add(pName);
        }

        mReMenCitys.add(new AddressBean("110000", "北京"));
        mReMenCitys.add(new AddressBean("370000", "山东省"));
        mReMenCitys.add(new AddressBean("630000", "青海省"));


    }

    private void initViews() {
        iv_left = (RelativeLayout) findViewById(R.id.iv_left);
        View view = View.inflate(this, R.layout.head_city_list, null);
        mGridView = (GridView) view.findViewById(R.id.id_gv_remen);
        gvAdapter = new MyGridViewAdapter(this, mReMenCitys);
        mGridView.setAdapter(gvAdapter);
        mGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));

        //实例化汉字转拼音类
        characterParser = CharacterParser.getInstance();

        pinyinComparator = new PinyinComparator();

        sideBar = (SideBar) findViewById(R.id.sidrbar);
        dialog = (TextView) findViewById(R.id.dialog);
        sideBar.setTextView(dialog);

        //设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                if (s.equals("热门")) {
                    sortListView.setSelection(0);
                }
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position);
                }

            }
        });

        sortListView = (ListView) findViewById(R.id.country_lvcountry);
        sortListView.addHeaderView(view);
        sortListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //这里要利用adapter.getItem(position)来获取当前position所对应的对象
//                Toast.makeText(getApplication(), adapter.getItem(position - 1).getName() + ",," + adapter.getItem(position - 1).getId(), Toast.LENGTH_SHORT).show();
//                hideSoftInput(mClearEditText.getWindowToken());
//                Intent data = new Intent();
//                data.putExtra("cityName", ((SortModel) adapter.getItem(position - 1)).getName());
////				setResult(1110, data);
//				CitySelecterActivity.this.finish();

                SortModel item = adapter.getItem(position - 1);

                AddressBean info=new AddressBean(item.getId(),item.getName());

                setBundleValue(info);

            }
        });

//		SourceDateList = filledData(getResources().getStringArray(R.array.date));
//		SourceDateList = filledData(provinceList);
        SourceDateList = filledData(jsonBean);

        // 根据a-z进行排序源数据
        Collections.sort(SourceDateList, pinyinComparator);
        adapter = new SortAdapter(this, SourceDateList);
        sortListView.setAdapter(adapter);


        mClearEditText = (ClearEditText) findViewById(R.id.filter_edit);
        //根据输入框输入值的改变来过滤搜索
        mClearEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        iv_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftInput(mClearEditText.getWindowToken());
                CitySelecterActivity.this.finish();
            }
        });
        mGridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//				String cityName = mReMenCitys.get(position).getName();
//				hideSoftInput(mClearEditText.getWindowToken());
//				Intent data = new Intent();
//			    data.putExtra("cityName", cityName);
//				setResult(1110, data);
//				CitySelecterActivity.this.finish();
            }
        });
    }


    public void setBundleValue(AddressBean bundleValue) {

        if (bundleValue == null) {
            return;
        }

        Intent intent = getIntent();
        Gson gson = new Gson();
        String cityBean = gson.toJson(bundleValue);
        intent.putExtra("cityBean", cityBean);
        setResult(106, intent);
        finish();
    }

    /**
     * 为ListView填充数据
     *
     * @param date
     * @return
     */
    private List<SortModel> filledData(List<AddressBean> date) {
        List<SortModel> mSortList = new ArrayList<SortModel>();

        for (int i = 0; i < date.size(); i++) {
            SortModel sortModel = new SortModel();
            sortModel.setName(date.get(i).getTypeName());
            sortModel.setId(date.get(i).getID());
            //汉字转换成拼音
            String pinyin = characterParser.getSelling(date.get(i).getTypeName());
            String sortString = pinyin.substring(0, 1).toUpperCase();

            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }

            mSortList.add(sortModel);
        }
        return mSortList;

    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<SortModel> filterDateList = new ArrayList<SortModel>();

        if (TextUtils.isEmpty(filterStr)) {
            filterDateList = SourceDateList;
        } else {
            if (!provinces.contains(filterStr)) {
                filterDateList.clear();
                for (SortModel sortModel : SourceDateList) {
                    String name = sortModel.getName();
                    if (name.indexOf(filterStr.toString()) != -1 || characterParser.getSelling(name).startsWith(filterStr.toString())) {
                        filterDateList.add(sortModel);
                    }
                }
            } else {
                filterDateList.clear();
                for (int i = 0; i < jsonBean.size(); i++) {
                    AddressBean name = jsonBean.get(i);
                    if (name.equals(filterStr)) {
                        filterDateList.addAll(filledData(jsonBean));
                    }
                }
            }
        }

        // 根据a-z进行排序
        Collections.sort(filterDateList, pinyinComparator);
        adapter.updateListView(filterDateList);
    }

    private class MyGridViewAdapter extends MyBaseAdapter<AddressBean, GridView> {
        private LayoutInflater inflater;

        public MyGridViewAdapter(Context ct, List<AddressBean> list) {
            super(ct, list);
            inflater = LayoutInflater.from(ct);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.item_remen_city, null);
                holder.id_tv_cityname = (TextView) convertView.findViewById(R.id.id_tv_cityname);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            final AddressBean info = mReMenCitys.get(position);
            holder.id_tv_cityname.setText(info.getTypeName());

            holder.id_tv_cityname.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

//                    Toast.makeText(CitySelecterActivity.this, "=" + info.getTypeName() + "," + info.getID(), Toast.LENGTH_SHORT).show();
                    setBundleValue(info);
                }
            });

            return convertView;
        }

        class ViewHolder {
            TextView id_tv_cityname;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 多种隐藏软件盘方法的其中一种
     *
     * @param token
     */
    protected void hideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token,
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    public static ArrayList<AddressBean> parseData(String result) {
        ArrayList<AddressBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Log.i(TAG, "parseData: ----****-----------------------------------------------****---------------");
//            for (int i = 0; i < data.length(); i++) {
//                Log.i(TAG, "parseData===================: " + data.get(i).toString());
//            }
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                AddressBean entity = gson.fromJson(data.get(i).toString(), AddressBean.class);
                Log.i(TAG, "parseData: ==========================================");
                Log.i(TAG, "parseData: " + new Gson().toJson(entity));

                Log.i(TAG, "parseData:==>>> " + entity.getID() + entity.getTypeName());

                Log.i(TAG, "parseData: ==========================================");

                detail.add(entity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }


}
