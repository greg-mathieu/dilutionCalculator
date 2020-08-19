package com.mgregoire.dilutioncalculator

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val calculation = Calculation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCompute.setOnClickListener {
            val requiredDose = editTextRequiredDose.text.toString().toDouble()
            val concentration = editTextConcentration.text.toString().toDouble()
            val totalVolume = editTextTotalVolume.text.toString().toDouble()

            calculation
                .requiredDose(requiredDose)
                .concentration(concentration)
                .totalVolume(totalVolume)
            editTextResult.setText(calculation.compute())

            hideKeyboard()
        }

        editTextRequiredDose.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                calculation.requiredDose(editTextRequiredDose.text.toString().toDouble())
                editTextResult.setText(calculation.compute())
            }
        })

        editTextConcentration.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                calculation.concentration(editTextConcentration.text.toString().toDouble())
                editTextResult.setText(calculation.compute())
            }
        })

        editTextTotalVolume.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                calculation.totalVolume(editTextTotalVolume.text.toString().toDouble())
                editTextResult.setText(calculation.compute())
            }
        })

        buttonClear.setOnClickListener {
            clear(editTextRequiredDose)
            clear(editTextConcentration)
            clear(editTextTotalVolume)
            clear(editTextResult)
        }
    }

    private fun clear (editText: EditText) {
        editText.text.clear()
        editText.clearFocus()
    }

    // find on "http://programminget.blogspot.com/2017/08/how-to-close-android-soft-keyboard.html"
    private fun hideKeyboard() {
        val inputManager:InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)
    }
}