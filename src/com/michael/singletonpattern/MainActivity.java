package com.michael.singletonpattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tvShowInfo;
	private Button btnIntent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvShowInfo = (TextView)findViewById(R.id.tv_show_info);
        btnIntent = (Button)findViewById(R.id.btn_to_another_activity);
        
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
        
        btnIntent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClass(MainActivity.this, AnotherActivity.class);
				startActivity(intent);
			}
		});
    }

    
}
