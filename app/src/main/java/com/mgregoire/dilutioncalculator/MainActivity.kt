package com.mgregoire.dilutioncalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCompute.setOnClickListener(View.OnClickListener {
            val requiredDose = editTextRequiredDose.text.toString().toDouble()
            val concentration = editTextConcentration.text.toString().toDouble()
            val totalVolume = editTextTotalVolume.toString().toDouble()

            val result = (totalVolume * requiredDose) / concentration
            editTextResult.setText(result.toString())

            hideKeyboard()
        })

        buttonClear.setOnClickListener(View.OnClickListener {
            clear(editTextRequiredDose)
            clear(editTextConcentration)
            clear(editTextTotalVolume)
            clear(editTextResult)
        })
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