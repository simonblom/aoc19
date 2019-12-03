package _3

import java.io.File

fun parsePath(path: String, prevNode: Pair<Int, Int>): Pair<Int, Int> {
    val direction = path.substring(0, 1)
    val distance = path.substring(startIndex = 1).toInt()

    var x = 0
    var y = 0

    if(direction.equals("R")) {
        return Pair<Int, Int>(prevNode.first + distance, prevNode.second)
    }
    else if(direction.equals("L")) {
        return Pair<Int, Int>(prevNode.first - distance, prevNode.second)
    }
    else if(direction.equals("U")) {
        return Pair<Int, Int>(prevNode.first, prevNode.second + distance)
    }
    else if(direction.equals("D")) {
        return Pair<Int, Int>(prevNode.first, prevNode.second - distance)
    }
    else {
        throw Exception("Incorrect input")
    }
}

fun main(args: Array<String>) {
    val path = System.getProperty("user.dir")
    val lineList = mutableListOf<String>()
    File(path + "/src/_3/in").useLines { lines -> lines.forEach { lineList.add(it) }}

    val strings1 = lineList.get(0).split(",").toMutableList()
    val strings2 = lineList.get(1).split(",").toMutableList()

    var wire1 = mutableSetOf<Pair<Int, Int>>()
    var wire2 = mutableSetOf<Pair<Int, Int>>()

    var prevNode = Pair(0,0)
    wire1.add(prevNode)
    var currentNode: Pair<Int, Int>
    for(s in strings1) {
        currentNode = parsePath(s, prevNode)
        wire1.add(parsePath(s, prevNode))
        prevNode = currentNode
    }

    prevNode = Pair(0,0)
    wire2.add(prevNode)
    for(s in strings2) {
        currentNode = parsePath(s, prevNode)
        wire2.add(currentNode)
        prevNode = currentNode
    }

    var wirepath1 = mutableMapOf<Pair<Int, Int>, Int>()

    println(wire1.intersect(wire2))

    var all = wire1.addAll(wire2)

    for(n1 in wire1) {
        for(n2 in wire2) {
            if(n1.first == n2.first) {

            }
        }
    }





    println("Part 1: ")

    //println("Part 2: ")
}