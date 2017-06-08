package com.why.project.datetimehelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.why.project.datetimehelperdemo.utils.DateTimeHelper;

import java.text.ParseException;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initDatas();
	}

	private void initDatas(){
		try {
			Date data1 = DateTimeHelper.parseStringToDate("20170521");
			Date data2 = DateTimeHelper.parseStringToDate("2017/05/21");
			Date data3 = DateTimeHelper.parseStringToDate("2017-05-21");
			Log.w(TAG,"将20170521转换成日期类型="+data1);
			Log.w(TAG,"将2017/05/21转换成日期类型="+data2);
			Log.w(TAG,"将2017-05-21转换成日期类型="+data3);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String formatToString1 = DateTimeHelper.formatToString(new Date(),DateTimeHelper.FORMAT_DAY);
		Log.w(TAG,"将日期Date以指定格式(yyyy-MM-dd)输出="+formatToString1);
		String formatToString2 = DateTimeHelper.formatToString("2017/05/21",DateTimeHelper.FORMAT_DAY);
		Log.w(TAG,"将2017/05/21以指定格式(yyyy-MM-dd)输出="+formatToString2);

		String getStrTime1 = DateTimeHelper.getStrTime(new Date().getTime()+"");
		Log.w(TAG,"将时间戳转化为固定格式的日期(yyyy-MM-dd HH:mm:ss)字符串="+getStrTime1);
		String getStrTime2 = DateTimeHelper.getStrTime(new Date().getTime()+"",DateTimeHelper.FORMAT_TEXT_24);
		Log.w(TAG,"将时间戳转化为指定格式日期(yyyy年MM月dd日 HH时mm分ss秒)的字符串="+getStrTime2);

		String getPerMonthDate = DateTimeHelper.getPerMonthDate();
		Log.w(TAG,"当前时间(2017-05-21)的上一个月="+getPerMonthDate);

		String getLastMonthDate = DateTimeHelper.getLastMonthDate();
		Log.w(TAG,"当前时间(2017-05-21)的下一个月="+getLastMonthDate);

		String getTimeDifferenceDate = DateTimeHelper.getTimeDifferenceDate("2015-11-23","2015-12-20");
		Log.w(TAG,"2015-11-23和2015-12-20相差："+getTimeDifferenceDate+"天");

		try {
			String twoDateDistance = DateTimeHelper.twoDateDistance(DateTimeHelper.parseStringToDate("2015-11-23"),DateTimeHelper.parseStringToDate("2015-12-20"));
			Log.w(TAG,"2015-11-23在2015-12-20："+twoDateDistance);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		boolean compare_date = DateTimeHelper.compare_date("2015-11-23","2015-12-20");
		Log.w(TAG,"2015-11-23比2015-12-20小："+compare_date);

		Date parseFormatTimeToDate = DateTimeHelper.parseFormatTimeToDate("1462772155198");
		Log.w(TAG,"将时间戳字符串(1462772155198)转化为Date对象："+parseFormatTimeToDate);

		long getParseDateTime = DateTimeHelper.getParseDateTime("2015-11-23");
		Log.w(TAG,"将2015-11-23转换成时间戳字符串："+getParseDateTime);

		String getLastWeekDate = DateTimeHelper.getLastWeekDate("2017-05-21");
		Log.w(TAG,"当前时间(2017-05-21)延后一个星期："+getLastWeekDate);

		try {
			boolean isSameDay = DateTimeHelper.isSameDay(new Date(),DateTimeHelper.parseStringToDate("2015-12-20"));
			Log.w(TAG,"2015-12-20是今天吗？isSameDay："+isSameDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
