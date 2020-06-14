package com.tv.gallery;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;

//更多TV项目资源(如桌面，直播点播，教育，应用市场，文件管理器，设置，酒店应用等)，添加微信：qiupansi
//If you want more TV project resources,such as TvLauncher,TvLive,TvAppStore,TvSettings,TvFileManager,TvEducation,TvHotel,TvMusic,TvRemote and so on，Add me wechat：qiupansi
public class MainActivity extends Activity {

    private CustomHeadersFragment headersFragment;
    private CustomRowsFragment rowsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        headersFragment = new CustomHeadersFragment();
        rowsFragment = new CustomRowsFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction
                .replace(R.id.header_container, headersFragment, "CustomHeadersFragment")
                .replace(R.id.rows_container, rowsFragment, "CustomRowsFragment");
        transaction.commit();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT)
            headersFragment.handleDPadrightAction();
        return true;
    }

    public Fragment getRowFragment() {
        return rowsFragment;
    }

}
