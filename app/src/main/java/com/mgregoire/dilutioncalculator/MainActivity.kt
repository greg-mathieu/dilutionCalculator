package com.mgregoire.dilutioncalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCompute.setOnClickListener(View.OnClickListener {
            val requiredDose = editTextRequiredDose.text.toString().toDouble()
            val concentration = editTextConcentration.text.toString().toDouble()
            val totalVolume = editTextTotalVolume.text.toString().toDouble()

            val result = (totalVolume * requiredDose) / concentration
            textViewResult.text = result.toString()
        })
    }
}