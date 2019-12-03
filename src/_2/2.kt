package _2

import java.io.File

fun intCode(lines:IntArray, noun: Int, verb: Int): Int {
    lines[1] = noun
    lines[2] = verb

    var i = 0
    var output = -1

    while(i < lines.size) {
        if(lines[i].equals(1)) {
            lines[lines[i+3]] = lines[lines[i+1]] + lines[lines[i+2]]
        }
        else if(lines[i].equals(2)) {
            lines[lines[i+3]] = lines[lines[i+1]] * lines[lines[i+2]]
        }
        else if(lines[i].equals(99)) {
            output = lines[0]
            break
        }
        else {
            throw Exception("Incorrect input")
        }
        i += 4
    }
    return output
}

fun main(args: Array<String>) {
    val lineList = mutableListOf<String>()
    File("src/_2/in").useLines { lines -> lines.forEach { lineList.add(it) }}
    val strings = lineList.get(0).split(",").toMutableList()
    var lines = strings.map { it.toInt() }.toIntArray()

    println("Part 1: " + intCode(lines, 12, 2))

    lines = strings.map { it.toInt() }.toIntArray()

    var output = 0

    for(noun in 0..98) {
        for (verb in noun+1..99) {
            lines = strings.map { it.toInt() }.toIntArray()
            output = intCode(lines, noun, verb)
            if(output == 19690720) {
                println("Part 2: " + ((100 * noun) + verb))
                System.exit(0)
            }
        }
    }
}