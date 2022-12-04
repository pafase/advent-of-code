package day02

import readInput

fun main() {
    fun getStrategies(input: List<String>): ArrayList<List<String>> {
        val strategies = ArrayList<List<String>>()
        for (element in input) {
            strategies.add(element.split(" "))
        }
        return strategies
    }

    fun part1(input: List<String>): Int {
        val strategies = getStrategies(input)
        var totalScore = 0
        // X rock, Y paper, Z scissors
        // A rock, B paper, C scissors
        for (strategy in strategies) {
            if(strategy[1] == "X") {
                totalScore += 1
                if(strategy[0] == "A") {
                    totalScore += 3
                } else if(strategy[0] == "C") {
                    totalScore += 6
                }
            } else if(strategy[1] == "Y") {
                totalScore += 2
                if(strategy[0] == "A") {
                    totalScore += 6
                } else if(strategy[0] == "B") {
                    totalScore += 3
                }
            } else if(strategy[1] == "Z") {
                totalScore += 3
                if(strategy[0] == "C") {
                    totalScore += 3
                } else if(strategy[0] == "B") {
                    totalScore += 6
                }
            }
        }
        return totalScore
    }

    fun part2(input: List<String>): Int {
        val strategies = getStrategies(input)
        var totalScore = 0
        // Rock 1 point, Paper 2 points, Scissors 3 points
        // Lose 0 points, Draw 3 points, Win 6 points
        // X lose, Y draw, Z win
        // A rock, B paper, C scissors
        for (strategy in strategies) {
            if(strategy[1] == "X") {
                totalScore += 0
                totalScore += if(strategy[0] == "A") {
                    3
                } else if(strategy[0] == "B") {
                    1
                } else 2
            } else if(strategy[1] == "Y") {
                totalScore += 3
                totalScore += if(strategy[0] == "A") {
                    1
                } else if(strategy[0] == "B") {
                    2
                } else 3
            } else if(strategy[1] == "Z") {
                totalScore += 6
                totalScore += if(strategy[0] == "A") {
                    2
                } else if(strategy[0] == "B") {
                    3
                } else 1
            }
        }
        return totalScore
    }

    val input = readInput("input", "src/day02")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}