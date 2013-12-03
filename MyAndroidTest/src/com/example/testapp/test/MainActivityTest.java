package com.example.testapp.test;

import com.example.testapp.MainActivity;
import com.example.testapp.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{
	
	private MainActivity mainActivity;
	private TextView textView;	
	private Button sendButton;

	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	 @Override
	 protected void setUp() throws Exception {
	     super.setUp();
	     mainActivity = getActivity();
	     
	     textView = (TextView) mainActivity.findViewById(R.id.edit_message);	     
	     sendButton = (Button) mainActivity.findViewById(R.id.button);
	 }

	 public void testPreconditions() {
		 assertNotNull("mainActivity is null", mainActivity);
		 assertNotNull("textView is null", textView);
		 assertNotNull("button is null", sendButton);
	 }
	 
	 public void testTextView_labelText() {
		 final String expectedText = mainActivity.getString(R.string.edit_message);
		 final String actual = textView.getHint().toString();
		 assertEquals(expectedText, actual);
	 }	 
	 
	 public void testButtonText_labelText(){
		 final String expectedButtonText = mainActivity.getString(R.string.button_send);
		 final String actualButtonText = sendButton.getText().toString();
		 assertEquals(expectedButtonText, actualButtonText);
	 }

}
