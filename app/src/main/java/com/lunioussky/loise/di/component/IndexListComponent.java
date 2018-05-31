package com.lunioussky.loise.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.lunioussky.loise.di.module.IndexListModule;

import com.jess.arms.di.scope.FragmentScope;
import com.lunioussky.loise.mvp.ui.fragment.IndexListFragment;

@FragmentScope
@Component(modules = IndexListModule.class, dependencies = AppComponent.class)
public interface IndexListComponent {
    void inject(IndexListFragment fragment);
}