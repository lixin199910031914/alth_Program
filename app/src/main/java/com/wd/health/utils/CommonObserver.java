package com.wd.health.utils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class CommonObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }
}
