package com.lunioussky.loise.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.lunioussky.loise.di.module.IndexModule;

import com.jess.arms.di.scope.FragmentScope;
import com.lunioussky.loise.mvp.ui.fragment.IndexFragment;

@FragmentScope
@Component(modules = IndexModule.class, dependencies = AppComponent.class)
public interface IndexComponent {
    void inject(IndexFragment fragment);
}