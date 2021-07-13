package ru.androidschool.intensiv.domain.usecase.extensions

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.addSchedulers(): Single<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}

fun Completable.addSchedulersToDB(): Completable{
    return this.subscribeOn(Schedulers.io())
        .subscribeOn(AndroidSchedulers.mainThread())
}