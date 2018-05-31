package com.lunioussky.loise.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.lunioussky.loise.mvp.contract.IndexContract;
import com.lunioussky.loise.mvp.model.IndexModel;


@Module
public class IndexModule {
    private IndexContract.View view;

    /**
     * 构建IndexModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public IndexModule(IndexContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    IndexContract.View provideIndexView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    IndexContract.Model provideIndexModel(IndexModel model) {
        return model;
    }
}