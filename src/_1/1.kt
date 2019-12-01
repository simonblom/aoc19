package _1

import java.io.File

fun calculateFuelRequirement(mass: Double): Double {
    return kotlin.math.floor(mass / 3) - 2
}

fun main(args: Array<String>) {
    val path = System.getProperty("user.dir")
    val lineList = mutableListOf<String>()
    File(path + "/src/_1/in").useLines { lines -> lines.forEach { lineList.add(it) }}

    var sum : Double = 0.0
    for(line in lineList) {
        sum += calculateFuelRequirement(line.toDouble())
    }
    println("Part 1: "+sum.toInt())

    sum = 0.0
    var fuelRequirement: Double
    for(line in lineList) {
        fuelRequirement = calculateFuelRequirement(line.toDouble())
        while(fuelRequirement > 0.0) {
            sum += fuelRequirement
            fuelRequirement = calculateFuelRequirement(fuelRequirement)
        }
    }
    println("Part 2: "+sum.toInt())
}