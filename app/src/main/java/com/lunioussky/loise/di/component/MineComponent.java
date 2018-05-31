package com.lunioussky.loise.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.lunioussky.loise.di.module.MineModule;

import com.jess.arms.di.scope.FragmentScope;
import com.lunioussky.loise.mvp.ui.fragment.MineFragment;

@FragmentScope
@Component(modules = MineModule.class, dependencies = AppComponent.class)
public interface MineComponent {
    void inject(MineFragment fragment);
}