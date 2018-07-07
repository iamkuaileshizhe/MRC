package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.LevelListViewAdapter;
import com.neocom.mobilerefueling.bean.AddressBean;
import com.neocom.mobilerefueling.utils.JsonFileReader;
import com.neocom.mobilerefueling.view.TopTitleBar;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/10/10.
 */

public class SelectAddRessActivity extends BaseActivity implements View.OnClickListener {

    private ListView lv_continent;//洲
    private ListView lv_country;//国
    private ListView lv_province;//省
    private ListView lv_city;//市
    private TextView tvShow;

    private LevelListViewAdapter continentAdapter;
    private LevelListViewAdapter countryAdapter;
    private LevelListViewAdapter provinceAdapter;
    private LevelListViewAdapter cityAdapter;

    private List<AddressBean> continentValues = new ArrayList<>();
    private List<AddressBean> countryValues = new ArrayList<>();
    private List<AddressBean> provinceValues = new ArrayList<>();
    private List<AddressBean> cityValues;


    private int continentPosition = 0;
    private int countryPosition = 0;
    private int provincePosition = 0;
    private int cityPosition = 0;

    private int countryNumber = -1;
    private int provinceNumber = -1;

    private long countryTime = 0;
    private long provinceTime = 0;


    @Override
    public void initContentView() {
        setContentView(R.layout.select_address_layout);
    }

    @Override
    public void initView() {
        lv_continent = (ListView) findViewById(R.id.lv_continent);
        lv_country = (ListView) findViewById(R.id.lv_country);
        lv_province = (ListView) findViewById(R.id.lv_province);
        lv_city = (ListView) findViewById(R.id.lv_city);
        tvShow = (TextView) findViewById(R.id.tv_show);

        TopTitleBar titleBar = (TopTitleBar) findViewById(R.id.add_address_top);
        initJsonData();
        titleBar.setTitleText("请选择地址");
        tvShow.setOnClickListener(this);
        titleBar.getFinishLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        titleBar.getOKLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(UIUtils.getContext(), "选好了", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();

                intent.putExtra("continent", continentAdapter.ItemSelected().getTypeName());
                intent.putExtra("continentId", continentAdapter.ItemSelected().getID());
                intent.putExtra("country", countryAdapter.ItemSelected().getTypeName());
                intent.putExtra("countryId", countryAdapter.ItemSelected().getID());
                intent.putExtra("province", provinceAdapter.ItemSelected().getTypeName());
                intent.putExtra("provinceId", provinceAdapter.ItemSelected().getID());
                intent.putExtra("city", cityAdapter.ItemSelected().getTypeName());
                intent.putExtra("cityId", cityAdapter.ItemSelected().getID());

                setResult(201, intent);
                finish();


            }
        });


    }

    public String beanToString(AddressBean addressBean) {
        if (addressBean == null) {
            return "";
        } else {
            Gson gson = new Gson();
            String toJson = gson.toJson(addressBean);
            return toJson;
        }
    }

    @Override
    public void initData() {

    }

    private void initJsonData() {
        String JsonData = JsonFileReader.getJson(this, "myjson.json");
        ArrayList<AddressBean> jsonBean = parseData(JsonData);//用Gson 转成实体
//        for (int i = 0; i < jsonBean.size(); i++) {
//            Log.i(TAG, "initJsonData:遍历：**********>> " + ";第;" + i + ":个:" + jsonBean.get(i).toString());
//        }
        setContinent(jsonBean);
    }


    public void setContinent(final ArrayList<AddressBean> jsonBean) {
        continentValues = jsonBean;

        if (!(continentValues.isEmpty())) {
            continentAdapter = new LevelListViewAdapter(this, continentValues);
            continentAdapter.setSelectedPositionNoNotify(continentPosition, continentValues);
            lv_continent.setAdapter(continentAdapter);

            countryAdapter = new LevelListViewAdapter(SelectAddRessActivity.this);
            provinceAdapter = new LevelListViewAdapter(SelectAddRessActivity.this);
            cityAdapter = new LevelListViewAdapter(SelectAddRessActivity.this);
            continentAdapter.setOnItemClickListener(new LevelListViewAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                    Log.i(TAG, "onItemClick:==> " + continentAdapter.getItem(position).getChildren().toString());

                    if (!(continentValues.isEmpty())) {

                        final List<AddressBean> country = continentAdapter.getItem(position).getChildren();
                        countryAdapter = new LevelListViewAdapter(SelectAddRessActivity.this, country);

                        countryAdapter.notifyDataSetChanged();
                        countryAdapter.setSelectedPositionNoNotify(0, country);
                        lv_country.setAdapter(countryAdapter);
                        lv_country.smoothScrollToPosition(0);

                        makeProvinceClear();
                        makeCityClear();

                        countryAdapter.setOnItemClickListener(new LevelListViewAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int pos) {

                                if (!(country.isEmpty())) {
                                    final List<AddressBean> province = countryAdapter.getItem(pos).getChildren();

                                    provinceAdapter = new LevelListViewAdapter(SelectAddRessActivity.this, province);

                                    provinceAdapter.notifyDataSetChanged();
                                    provinceAdapter.setSelectedPositionNoNotify(0, province);
                                    lv_province.setAdapter(provinceAdapter);
                                    lv_province.smoothScrollToPosition(0);

                                    makeCityClear();

                                    provinceAdapter.setOnItemClickListener(new LevelListViewAdapter.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(View view, int po) {

                                            if (!(province.isEmpty())) {

                                                List<AddressBean> city = provinceAdapter.getItem(po).getChildren();
                                                if (!(city.isEmpty())) {
                                                    cityAdapter = new LevelListViewAdapter(SelectAddRessActivity.this, city);
                                                    cityAdapter.setSelectedPositionNoNotify(0, city);
                                                    lv_city.setAdapter(cityAdapter);

                                                    cityAdapter.setOnItemClickListener(new LevelListViewAdapter.OnItemClickListener() {
                                                        @Override
                                                        public void onItemClick(View view, int p) {
                                                            Toast.makeText(SelectAddRessActivity.this, "=选择的是：" + cityAdapter.getItem(p).getTypeName().toString(), Toast.LENGTH_SHORT).show();

                                                        }
                                                    });

                                                } else {
                                                    Log.i(TAG, "onItemClick: ----0.0----置空城市-----------0.0--");
                                                    city.clear();
                                                    cityAdapter = new LevelListViewAdapter(SelectAddRessActivity.this, city);
                                                    lv_city.setAdapter(cityAdapter);
                                                    cityAdapter.notifyDataSetChanged();
//                                                    cityBeanSelected = EqNull();
                                                }

                                            } else {
                                                cityAdapter.notifyDataSetChanged();
                                                Log.i(TAG, "onItemClick: 置空xxxxxx");
                                            }


                                        }
                                    });


                                } else {

                                    provinceAdapter.notifyDataSetChanged();

                                    Log.i(TAG, "onItemClick: --0.0--置空--省-----");
                                }


                            }
                        });

                    } else {
                        countryAdapter.notifyDataSetChanged();
                        Log.i(TAG, "onItemClick: ---置空---国-------");
                    }

                }
            });
        }

    }


    @Override
    public void onClick(View view) {

        Log.i(TAG, "onClick: =>" + continentAdapter.ItemSelected().getTypeName() + "," + countryAdapter.ItemSelected().getTypeName() + "," + provinceAdapter.ItemSelected().getTypeName() + "," + cityAdapter.ItemSelected().getTypeName());

        Toast.makeText(this, continentAdapter.ItemSelected().getTypeName() + "," + countryAdapter.ItemSelected().getTypeName() + "," + provinceAdapter.ItemSelected().getTypeName() + "," + cityAdapter.ItemSelected().getTypeName(), Toast.LENGTH_SHORT).show();

        tvShow.setText("选择:" + continentAdapter.ItemSelected().getTypeName() + "," + countryAdapter.ItemSelected().getTypeName() + "," + provinceAdapter.ItemSelected().getTypeName() + "," + cityAdapter.ItemSelected().getTypeName());
    }

    public ArrayList<AddressBean> parseData(String result) {
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
                detail.add(entity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

    public void makeCityClear() {

        cityAdapter = new LevelListViewAdapter(SelectAddRessActivity.this);
        cityAdapter.notifyDataSetChanged();
        lv_city.setAdapter(cityAdapter);

    }

    public void makeProvinceClear() {

        provinceAdapter = new LevelListViewAdapter(SelectAddRessActivity.this, null);
        provinceAdapter.notifyDataSetChanged();
        lv_province.setAdapter(provinceAdapter);

    }

}
