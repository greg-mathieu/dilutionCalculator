package com.mgregoire.dilutioncalculator

class Calculation(
    //val callback: Consumer<String>
) {

    private var requiredDose : Double = 0.0 // mass
    private var concentration : Double = 0.0 // mass dans le totalVolume
    private var totalVolume : Double = 0.0 // volume

    fun compute(): String {
        if (concentration == 0.0)
            return "No result"
        val mass = Mass(requiredDose)
        val mass1 = Mass(concentration)
        val vol = Volume(totalVolume)

        val result : Volume = vol.multiplyBy(mass.divideBy(mass1))

        return result.asmL().toString()
    }

    fun requiredDose(dose: Double): Calculation {
        requiredDose = dose
        //callback.accept(compute())
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