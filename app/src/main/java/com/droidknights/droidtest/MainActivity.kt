package com.droidknights.droidtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()
    private val relay: Relay<Int> = PublishRelay.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RxView.clicks(activity_main_button_0).subscribe { relay.accept(0) }
        RxView.clicks(activity_main_button_1).subscribe { relay.accept(1) }
        RxView.clicks(activity_main_button_2).subscribe { relay.accept(2) }
        RxView.clicks(activity_main_button_3).subscribe { relay.accept(3) }
        RxView.clicks(activity_main_button_4).subscribe { relay.accept(4) }
        RxView.clicks(activity_main_button_5).subscribe { relay.accept(5) }
        RxView.clicks(activity_main_button_6).subscribe { relay.accept(6) }
        RxView.clicks(activity_main_button_7).subscribe { relay.accept(7) }
        RxView.clicks(activity_main_button_8).subscribe { relay.accept(8) }
        RxView.clicks(activity_main_button_9).subscribe { relay.accept(9) }
    }

    override fun onStart() {
        super.onStart()

        disposable.add(
                relay.subscribeBy(
                        onNext = { number ->
                            activity_main_edit_text.append(number.toString())
                        },
                        onError = { err ->

                        }
                )
        )
    }

    override fun onDestroy() {
        disposable.dispose()

        super.onDestroy()
    }
}