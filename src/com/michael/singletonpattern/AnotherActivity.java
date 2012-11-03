package com.michael.singletonpattern;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends Activity {

	private TextView tvShowInfo;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        
        tvShowInfo = (TextView)findViewById(R.id.tv_show_info);
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("普通单例:");
        stringBuilder.append(SingletonCommon.getInstance().getSingletonInfo()+'\n');
        stringBuilder.append("同步单例:");
        stringBuilder.append(SingletonSynchronized.getInstance().getSingletonInfo()+'\n');
        stringBuilder.append("急切单例:");
        stringBuilder.append(SingletonEagerly.getInstance().getSingletonInfo()+'\n');
        stringBuilder.append("双重加锁单例:");
        stringBuilder.append(SingletonDoubleLocking.getInstance().getSingletonInfo()+'\n');
        
        tvShowInfo.setText(stringBuilder);
        
    }

    
}
