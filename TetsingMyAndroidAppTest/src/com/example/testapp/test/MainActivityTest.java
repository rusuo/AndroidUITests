package com.example.testapp.test;

import com.example.testapp.MainActivity;
import android.annotation.SuppressLint;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mainActivity;
	private TextView textView;
	private Button button;
	private String textToEnter = "test text";
	
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	public void testAndroidApp() throws Exception{
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		mainActivity = getActivity();

		textView = (TextView) mainActivity.findViewById(com.example.testapp.R.id.edit_message);
		button = (Button) mainActivity.findViewById(com.example.testapp.R.id.button);
		
	    assertTrue("mainACtivity is null",mainActivity != null);

	    mainActivity.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				textView.requestFocus();
				textView.setText(textToEnter);
			}
		});
	    
	    Thread.sleep(3000);
	    
	    button.callOnClick();
	    
	    assertEquals("The displayed text is not correct", textToEnter,textView.getText().toString());
	    
	}
}
