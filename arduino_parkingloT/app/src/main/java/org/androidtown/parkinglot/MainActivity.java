package org.androidtown.parkinglot;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //개발자 버튼 클릭시 발생되는 메소드
    public void onDevClicked(View v){
        Intent intent = new Intent(getApplicationContext(), DevActivity.class);
        startActivity(intent);
    }

    //건의사항 클릭시 발생되는 메소드
    public void onListClicked(View v){
        Intent intent = new Intent(getApplicationContext(), listActivity.class);
        startActivity(intent);
    }

    //메뉴 액션바를 위한 설정
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 메뉴를 위한 XML 파일 설정
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //메뉴 액션바를 위한 설정
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();
        switch(curId) {
            case R.id.menu_home:
                Toast.makeText(this, "메인화면으로 갑니다.", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //밑에 sns 링크

    public void onFacebook(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko-kr.facebook.com/"));
        startActivity(myIntent);
    }
    public void onGoogle(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.kr/mobile/"));
        startActivity(myIntent);
    }
    public void onInstagram(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"));
        startActivity(myIntent);
    }
    public void onTwitter(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mobile.twitter.com/"));
        startActivity(myIntent);
    }

}