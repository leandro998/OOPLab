package com.example.ooplab
/*
abstract class AquariumFish {
    abstract val color: String
} */

interface FishColor {
    val color: String
}

interface FishAction  {
    fun eat()
}

class Shark: FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

/*
class Plecostomus(fishColor: FishColor = GoldColor):  FishAction, FishColor by fishColor {
    //override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
} */

class Plecostomus (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

object GoldColor : FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}