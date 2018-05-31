package com.lunioussky.loise.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.lunioussky.loise.R;
import com.lunioussky.loise.app.utils.FragmentUtils;
import com.lunioussky.loise.di.component.DaggerMainComponent;
import com.lunioussky.loise.di.module.MainModule;
import com.lunioussky.loise.mvp.contract.MainContract;
import com.lunioussky.loise.mvp.presenter.MainPresenter;
import com.lunioussky.loise.mvp.ui.fragment.FindFragment;
import com.lunioussky.loise.mvp.ui.fragment.IndexFragment;
import com.lunioussky.loise.mvp.ui.fragment.MineFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;

    private List<Fragment> mFragments;
    private int mReplace = 0;
    private ImmersionBar mImmersionBar;


    private OnTabSelectListener onTabSelectListener = new OnTabSelectListener() {
        @Override
        public void onTabSelected(int tabId) {
            switch (tabId) {
                case R.id.tab_home:
                    mReplace = 0;
                    break;
                case R.id.tab_discover:
                    mReplace = 1;
                    break;
                case R.id.tab_mine:
                    mReplace = 2;
                    break;
            }
            FragmentUtils.hideAllShowFragment(mFragments.get(mReplace));
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化，默认透明状态栏和黑色导航栏
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态

    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        IndexFragment indexFragment;
        FindFragment findFragment;
        MineFragment mineFragment;
        if (savedInstanceState == null) {
            indexFragment = IndexFragment.newInstance();
            findFragment = FindFragment.newInstance();
            mineFragment = MineFragment.newInstance();
        } else {
            indexFragment = (IndexFragment) FragmentUtils.findFragment(getSupportFragmentManager(), IndexFragment.class);
            findFragment = (FindFragment) FragmentUtils.findFragment(getSupportFragmentManager(), FindFragment.class);
            mineFragment = (MineFragment) FragmentUtils.findFragment(getSupportFragmentManager(), MineFragment.class);

        }
        if (mFragments == null) {
            mFragments = new ArrayList<>();
            mFragments.add(indexFragment);
            mFragments.add(findFragment);
            mFragments.add(mineFragment);
        }
        FragmentUtils.addFragments(getSupportFragmentManager(), mFragments, R.id.main_frame, 0);
        bottomBar.setOnTabSelectListener(onTabSelectListener);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

}
