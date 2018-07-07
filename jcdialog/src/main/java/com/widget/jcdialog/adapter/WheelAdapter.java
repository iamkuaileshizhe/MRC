package com.widget.jcdialog.adapter;

/**
 * 类名称：WheelAdapter
 * 创建者：Create by liujc
 * 创建时间：Create on 2016/12/26 16:24
 * 描述：自定义wheel适配器
 */
public interface WheelAdapter {
	/**
	 * Gets items count
	 * @return the count of wheel items
	 */
	public int getItemsCount();
	
	/**
	 * Gets a wheel item by index.
	 * 
	 * @param index the item index
	 * @return the wheel item text or null
	 */
	public String getItem(int index);
	
	/**
	 * Gets maximum item length. It is used to determine the wheel width. 
	 * If -1 is returned there will be used the default wheel width.
	 * 
	 * @return the maximum item length or -1
	 */
	public int getMaximumLength();
	
	public String getCurrentId(int index);
}
