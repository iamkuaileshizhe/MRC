package com.neocom.mobilerefueling.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.TimeBean;

public class TimeAdapter extends BaseAdapter {
	private Context context;
	private List<TimeBean> list;
	public TimeAdapter(Context context, List<TimeBean> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		if (list == null) {
			return 0;
		}
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		if (list == null) {
			return null;
		}
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_time_line, parent, false);
			holder.date = (TextView) convertView
					.findViewById(R.id.txt_date_time);
			holder.ll_ex = (LinearLayout) convertView.findViewById(R.id.ll_ex);
			holder.content = (TextView) convertView
					.findViewById(R.id.txt_date_content);
			holder.img_arrow = (ImageView) convertView
					.findViewById(R.id.img_arrow);
			holder.flag = true;
			holder.img_arrow.setBackgroundResource(R.drawable.arrow_right);
			holder.line = (View) convertView.findViewById(R.id.v_line);
			holder.title = (RelativeLayout) convertView
					.findViewById(R.id.rl_title);
			holder.ll_ex.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					if (holder.flag) {
						holder.img_arrow
								.setBackgroundResource(R.drawable.arrow_down);
						holder.flag = false;
					} else {
						holder.img_arrow
								.setBackgroundResource(R.drawable.arrow_right);
						holder.flag = true;
					}
				}
			});
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		// 时间轴竖线的layout
		LayoutParams params = (LayoutParams) holder.line.getLayoutParams();
		// 第一条数据，肯定显示时间标题
		if (position == 0) {
			holder.title.setVisibility(View.VISIBLE);
			holder.date.setText(format("yyyy-MM-dd",
					list.get(position).getDate()));
			params.addRule(RelativeLayout.ALIGN_TOP, R.id.imageView1);
			params.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.ll_ex);
		} else { // 不是第一条数据
			// 本条数据和上一条数据的时间戳相同，时间标题不显示
			if (list.get(position).getDate()
					.equals(list.get(position - 1).getDate())) {
				holder.title.setVisibility(View.GONE);
				params.addRule(RelativeLayout.ALIGN_TOP, R.id.imageView1);
				params.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.ll_ex);
			} else {
				// 本条数据和上一条的数据的时间戳不同的时候，显示数据
				holder.title.setVisibility(View.VISIBLE);
				holder.date.setText(format("yyyy-MM-dd",
						list.get(position).getDate()));
				params.addRule(RelativeLayout.ALIGN_TOP, R.id.imageView1);
				params.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.ll_ex);
			}
		}
		holder.line.setLayoutParams(params);
		holder.content.setText(list.get(position).getText());
		return convertView;
	}

	public static class ViewHolder {
		RelativeLayout title;
		View line;
		ImageView img_arrow;
		TextView date;
		TextView content;
		TextView button;
		LinearLayout ll_ex;
		boolean flag;
	}
	@SuppressLint("SimpleDateFormat")
	public static String format(String format, String time) {
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = df.parse(time);
			SimpleDateFormat df1 = new SimpleDateFormat(format);
			result = df1.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
}
