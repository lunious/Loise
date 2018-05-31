package com.lunioussky.loise.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.lunioussky.loise.mvp.contract.FindContract;
import com.lunioussky.loise.mvp.model.FindModel;


@Module
public class FindModule {
    private FindContract.View view;

    /**
     * 构建FindModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public FindModule(FindContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    FindContract.View provideFindView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    FindContract.Model provideFindModel(FindModel model) {
        return model;
    }
}