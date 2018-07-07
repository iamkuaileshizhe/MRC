package com.neocom.mobilerefueling.utils;

import com.neocom.mobilerefueling.bean.TimeBean;

import java.util.Comparator;

public class TimeComparator implements Comparator<TimeBean> {

	@Override
	public int compare(TimeBean lhs, TimeBean rhs) {
		return rhs.getDate().compareTo(lhs.getDate());
	}
}
