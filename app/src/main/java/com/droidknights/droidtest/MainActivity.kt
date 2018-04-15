package com.droidknights.droidtest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.droidknights.droidtest.step1.Step1Activity
import com.droidknights.droidtest.step2.Step2Activity
import com.droidknights.droidtest.step3.Step3Activity
import com.droidknights.droidtest.step4.Step4Activity
import com.droidknights.droidtest.step5.Step5Activity
import com.jakewharton.rxbinding2.view.RxView.clicks
import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()
    private val buttonRelay: Relay<View> = PublishRelay.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clicks(activity_main_step_1).subscribe { buttonRelay.accept(activity_main_step_1) }
        clicks(activity_main_step_2).subscribe { buttonRelay.accept(activity_main_step_2) }
        clicks(activity_main_step_3).subscribe { buttonRelay.accept(activity_main_step_3) }
        clicks(activity_main_step_4).subscribe { buttonRelay.accept(activity_main_step_4) }
        clicks(activity_main_step_5).subscribe { buttonRelay.accept(activity_main_step_5) }

        disposable.add(
                buttonRelay.throttleFirst(500, TimeUnit.MILLISECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            val activity = when (it.id) {
                                R.id.activity_main_step_1 -> Intent(this, Step1Activity::class.java)
                                R.id.activity_main_step_2 -> Intent(this, Step2Activity::class.java)
                                R.id.activity_main_step_3 -> Intent(this, Step3Activity::class.java)
                                R.id.activity_main_step_4 -> Intent(this, Step4Activity::class.java)
                                R.id.activity_main_step_5 -> Intent(this, Step5Activity::class.java)
                                else -> throw RuntimeException("The button id \"${it.id}\" is not supported.")
                            }

                            startActivity(activity)
                        }
        )
    }

    override fun onDestroy() {
        disposable.dispose()

        super.onDestroy()
    }
}