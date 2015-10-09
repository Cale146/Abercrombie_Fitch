package com.example.af_promotion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PromotionActivity extends Activity {
	
	Button buttonTwo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_promotion);
		
		buttonTwo = (Button) findViewById(R.id.button2);

		buttonTwo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

			    Intent intent = new Intent(getBaseContext(), WebViewActivity.class);
                            startActivity(intent);   

			}

		});
		
		
	}
}
