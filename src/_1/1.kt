package _1

import java.io.File

fun main(args: Array<String>) {
    val lineList = mutableListOf<String>()

    File("src/_1/in").useLines { lines -> lines.forEach { lineList.add(it) }}
    lineList.forEach { println(">  " + it) }
}