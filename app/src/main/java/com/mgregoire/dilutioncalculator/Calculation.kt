package com.mgregoire.dilutioncalculator

class Calculation() {

    private var requiredDose : Double = 0.0
    private var concentration : Double = 0.0
    private var totalVolume : Double = 0.0

    fun compute(): String {
        if (totalVolume == 0.0 && concentration == 0.0 && totalVolume == 0.0 )
            return ((totalVolume * requiredDose) / concentration).toString()
        else
            return "No result"
    }

    fun requiredDose(dose: Double): Calculation {
        requiredDose = dose
        return this
    }

    fun concentration(conc: Double): Calculation {
        concentration = conc
        return this
    }

    fun totalVolume(vol: Double): Calculation {
        totalVolume = vol
        return this
    }



}