package com.qq.activity;

import com.qq.MainActivity;
import com.qq.R;
import com.qq.view.TextURLView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LoginActivity extends Activity {

	private Context mContext;
	private RelativeLayout rl_user;
	private Button mLogin;
	private Button register;
	private TextURLView mTextViewURL;
	private ImageView login_picture;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mContext=this;
		findView();
		initTvUrl();
		init();
	}
	
	private void findView(){
		rl_user=(RelativeLayout) findViewById(R.id.rl_user);
		mLogin=(Button) findViewById(R.id.login);
		register=(Button) findViewById(R.id.register);
		mTextViewURL=(TextURLView) findViewById(R.id.tv_forget_password);
		login_picture = (ImageView) findViewById(R.id.login_picture);
	}

	private void init(){
		Animation anim=AnimationUtils.loadAnimation(mContext, R.anim.login_anim);
		anim.setFillAfter(true);
		rl_user.startAnimation(anim);
		
		Animation anim2=AnimationUtils.loadAnimation(mContext, R.anim.login_head_anim);
		anim2.setFillAfter(true);
		login_picture.startAnimation(anim2);
		
		mLogin.setOnClickListener(loginOnClickListener);
		register.setOnClickListener(registerOnClickListener);
	}
	
	private void initTvUrl(){
		mTextViewURL.setText(R.string.forget_password);
	}
	
	private OnClickListener loginOnClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent=new Intent(mContext,MainActivity.class);
			startActivity(intent);
			finish();
			
		}
	};
	
	private OnClickListener registerOnClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent=new Intent(mContext, RegisterPhoneActivity.class);
			startActivity(intent);
			
		}
	};
}
