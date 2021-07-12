package ru.androidschool.intensiv.domain.extensions

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.addSchedulers(): Observable<T>{
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}

fun Completable.addSchedulersToDB(): Completable{
    return this.subscribeOn(Schedulers.io())
        .subscribeOn(AndroidSchedulers.mainThread())
}