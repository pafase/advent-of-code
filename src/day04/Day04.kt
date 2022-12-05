package day04

import readInput

fun main() {
    fun getRanges(input: String): List<Int> {
        val ranges = ArrayList<Int>()
        val split = input.split("-", ",")
        for (number in split) {
            ranges.add(number.toInt())
        }
        return ranges
    }

    fun part1(input: List<String>): Int {
        var totalScore = 0
        for (element in input) {
            val elementNumbers = getRanges(element)
            val range1 = elementNumbers[0]..elementNumbers[1]
            val range2 = elementNumbers[2]..elementNumbers[3]
            val intersect = range1.intersect(range2)
            if (intersect.isNotEmpty() && (intersect == range1.toSet() || intersect == range2.toSet())) {
                totalScore++
            }
        }
        return totalScore
    }

    fun part2(input: List<String>): Int {
        var totalScore = 0
        for (element in input) {
            val elementNumbers = getRanges(element)
            val range1 = elementNumbers[0]..elementNumbers[1]
            val range2 = elementNumbers[2]..elementNumbers[3]
            val intersect = range1.intersect(range2)
            if (intersect.isNotEmpty()) {
                totalScore++
            }
        }
        return totalScore
    }

    val input = readInput("input", "src/day04")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}