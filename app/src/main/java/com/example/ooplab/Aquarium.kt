package com.example.ooplab

import java.lang.Math.PI

open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    //we can remove the declaration if it is declared when calling Aquarium
    //var width: Int = width
    //var height: Int = height
    //var length: Int = length

    open var volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 l
        /* private */ set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "Rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")

        // 1 l = 1000 cm^3
        println("Volume: $volume l Water: $water l (${water/volume*100.0}% full)")
        println("$shape")
    }

    init {
        println("aquarium initializing")
    }
    /* init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} l")
    } */

    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1

        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

}

// Task 6:

class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
        // ellipse area = π * r1 * r2
        get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
        }

    override var water = volume * 0.8
    override val shape = "cylinder"
}
