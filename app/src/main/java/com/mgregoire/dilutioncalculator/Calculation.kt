package com.mgregoire.dilutioncalculator

class Calculation() {

    var requiredDose : Double = 0.0
    var concentration : Double = 0.0
    var totalVolume : Double = 0.0

    fun compute(): Double {
        return (totalVolume * requiredDose) / concentration
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