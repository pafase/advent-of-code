package day03

import readInput

fun main() {
    fun findRepeatedChar(input: String): Char {
        val chars = input.toCharArray()
        val firstHalf = chars.copyOfRange(0, chars.size / 2)
        val secondHalf = chars.copyOfRange(chars.size / 2, chars.size)
        firstHalf.toSet().intersect(secondHalf.toSet()).forEach { return it }
        return ' '
    }


    fun findRepeatedChar(firstElf: String, secondElf: String, thirdElf: String): Char {
        firstElf.toSet().intersect(secondElf.toSet()).intersect(thirdElf.toSet()).forEach { return it }
        return ' '
    }

    fun getCharPriority(letter: Char): Int {
        return if (letter.isUpperCase()) letter - 'A' + 27
        else letter - 'a' + 1
    }

    fun part1(input: List<String>): Int {
        var totalScore = 0
        for (element in input) {
            val repeatedChar = findRepeatedChar(element)
            totalScore += getCharPriority(repeatedChar)
        }
        return totalScore
    }

    fun part2(input: List<String>): Int {
        val groupedIn3 = input.chunked(3)
        var totalScore = 0
        for (element in groupedIn3) {
            val repeatedChar = findRepeatedChar(element[0], element[1], element[2])
            totalScore += getCharPriority(repeatedChar)
        }
        return totalScore
    }

    val input = readInput("input", "src/day03")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}