package com.lunioussky.loise.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.lunioussky.loise.mvp.contract.IndexListContract;
import com.lunioussky.loise.mvp.model.IndexListModel;


@Module
public class IndexListModule {
    private IndexListContract.View view;

    /**
     * 构建IndexListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public IndexListModule(IndexListContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    IndexListContract.View provideIndexListView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    IndexListContract.Model provideIndexListModel(IndexListModel model) {
        return model;
    }
}