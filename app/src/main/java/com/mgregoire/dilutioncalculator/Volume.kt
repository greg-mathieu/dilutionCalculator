package com.mgregoire.dilutioncalculator

/**
 * IS unit is meter cubes
 * 1 m3 = 1000 L
 * 1L = 1000 mL
 */
class Volume(val m3: Double) {

    companion object Units {
        val list : List<String> = listOf("L", "mL")
    }

    fun multiplyBy(ratio: Double): Volume {
        return Volume(m3 * ratio)
    }

    fun asmL(): Double {
        return (m3 / 1_000_000)
    }
}

fun Double.L(): Volume {
    return Volume(this / 1_000)
}
fun Double.mL(): Volume {
    return Volume(this / 1_000_000)
}