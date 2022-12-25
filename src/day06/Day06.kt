package day06

import readInput

fun main() {
    fun isStartOfPacket(input: String, position: Int): Boolean {
        var res = false
        if (position > 3) {
            val packet = input.substring(position - 3, position + 1)
            res = packet.toSet().size == packet.length
        }
        return res
    }
    fun isStartOfMessage(input: String, position: Int): Boolean {
        var res = false
        if (position > 13) {
            val message = input.substring(position - 13, position + 1)
            res = message.toSet().size == message.length
        }
        return res
    }

    fun part1(input: List<String>): Int {
        for(i in input[0].indices) {
            if (isStartOfPacket(input[0], i)) {
                return i + 1
            }
        }
        return 0
    }

    fun part2(input: List<String>): Int {
        for(i in input[0].indices) {
            if (isStartOfMessage(input[0], i)) {
                return i + 1
            }
        }
        return 0
    }

    val input = readInput("input", "src/day06")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}