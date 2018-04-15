package com.droidknights.droidtest.step4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.droidknights.droidtest.R
import com.jakewharton.rxbinding2.view.RxView.clicks
import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_calculator.*

class Step4Activity : AppCompatActivity() {

    private val disposable = CompositeDisposable()
    private val input: Relay<String> = PublishRelay.create()
    private val command: Relay<String> = PublishRelay.create()
    private val result: Relay<String> = PublishRelay.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        clicks(calculator_button_0).subscribe { input.accept("0") }
        clicks(calculator_button_1).subscribe { input.accept("1") }
        clicks(calculator_button_2).subscribe { input.accept("2") }
        clicks(calculator_button_3).subscribe { input.accept("3") }
        clicks(calculator_button_4).subscribe { input.accept("4") }
        clicks(calculator_button_5).subscribe { input.accept("5") }
        clicks(calculator_button_6).subscribe { input.accept("6") }
        clicks(calculator_button_7).subscribe { input.accept("7") }
        clicks(calculator_button_8).subscribe { input.accept("8") }
        clicks(calculator_button_9).subscribe { input.accept("9") }

        clicks(calculator_button_plus).subscribe { input.accept("+") }
        clicks(calculator_button_minus).subscribe { input.accept("-") }
        clicks(calculator_button_divide).subscribe { input.accept("/") }
        clicks(calculator_button_multiply).subscribe { input.accept("*") }

        clicks(calculator_button_result).subscribe { command.accept("=") }
    }

    override fun onStart() {
        super.onStart()

        disposable.addAll(
                input.subscribe {
                    calculator_edit_text.append(it.toString())
                },
                command.subscribe {
                    val text = calculator_edit_text.text.toString()

                    val symbol = if (text.contains("+")) {
                        "+"
                    } else if (text.contains("-")) {
                        "-"
                    } else if (text.contains("*")) {
                        "*"
                    } else if (text.contains("/")) {
                        "/"
                    } else {
                        throw RuntimeException("Not supported symbol")
                    }

                    calculate(text, symbol)
                },
                result.subscribe {
                    calculator_edit_text.setText(it)
                }
        )
    }

    private fun calculate(text: String, symbol: String) {
        disposable.add(
                Observable.just(text, symbol)
                        .map {
                            val arguments = text.split(symbol).toList()

                            (arguments[0].toInt() + arguments[1].toInt()).toString()
                        }
                        .subscribe { result.accept(it) }
        )
    }

    override fun onDestroy() {
        disposable.dispose()

        super.onDestroy()
    }
}