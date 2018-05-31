package com.lunioussky.loise.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.lunioussky.loise.di.module.FindModule;

import com.jess.arms.di.scope.FragmentScope;
import com.lunioussky.loise.mvp.ui.fragment.FindFragment;

@FragmentScope
@Component(modules = FindModule.class, dependencies = AppComponent.class)
public interface FindComponent {
    void inject(FindFragment fragment);
}