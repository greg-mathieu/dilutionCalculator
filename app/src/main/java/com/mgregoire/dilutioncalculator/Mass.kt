package com.mgregoire.dilutioncalculator

class Mass(val gram: Double) {

    fun divideBy(mass: Mass): Double {
        return gram / mass.gram;
    }

}

fun Double.g(): Mass {
    return Mass(this)
}

fun Double.mg(): Mass {
    return Mass(this / 1000)
}

