package com.lunioussky.loise.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.lunioussky.loise.di.module.MainModule;

import com.jess.arms.di.scope.ActivityScope;
import com.lunioussky.loise.mvp.ui.activity.MainActivity;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}