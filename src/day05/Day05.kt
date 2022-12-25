package day05

import readInput

fun main() {
    fun getNumberOfStacks(input: List<String>): Int {
        var numberOfStacks = 0;
        input.filter { it.contains("^[\\d\\s]+$".toRegex()) }.forEach { it ->
            it.split("\\s".toRegex()).filter { it.isNotBlank() }.forEach {
                numberOfStacks = it.toInt()
            }
        }
        return numberOfStacks
    }

    fun populateStacks(input: List<String>, stacks: List<ArrayDeque<String>>) {
        input.filter { it.contains('[') }.forEach { line ->
            line.mapIndexed { index, char ->
                if (char.isLetter()) {
                    stacks[index / 4].addLast(char.toString())
                }
            }

        }
    }

    fun move(quantity: Int, from: ArrayDeque<String>, to: ArrayDeque<String>) {
        for (i in 0 until quantity) {
            from.removeFirst().let { to.addFirst(it) }
        }
    }

    fun executeAllMoves(input: List<String>, stacks: MutableList<ArrayDeque<String>>) {
        val moves = input.filter { it.startsWith("move") }
        moves.forEach { move ->
            val moveParts = move.filter { !it.isLetter() }
                .split("\\s".toRegex())
                .filter { it.isNotBlank() }
            val quantity = moveParts[0].toInt()
            val from = stacks[moveParts[1].toInt() - 1]
            val to = stacks[moveParts[2].toInt() - 1]
            move(quantity, from, to)
        }
    }

    fun topCrates(stacks: MutableList<ArrayDeque<String>>): String {
        var res = ""
        for (i in stacks.indices) {
            if (!stacks[i].isEmpty()) {
                res += stacks[i].first()
            }
        }
        return res
    }

    fun part1(input: List<String>): String {
        val numberOfStacks = getNumberOfStacks(input)
        val stacks = MutableList<ArrayDeque<String>>(numberOfStacks) { ArrayDeque() }
        populateStacks(input, stacks)
        executeAllMoves(input, stacks)
        return topCrates(stacks)
    }

    fun part2(input: List<String>): Int {
        return 0;
    }

    val input = readInput("input", "src/day05")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}