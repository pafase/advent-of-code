package day01

import readInput

fun main() {
    fun getElves(input: List<String>): ArrayList<ArrayList<Long>> {
        val elves = ArrayList<ArrayList<Long>>();
        var elf = ArrayList<Long>();
        for (element in input) {
            if (element == "") {
                elves.add(elf.clone() as ArrayList<Long>)
                elf = ArrayList();
            } else {
                elf.add(element.toLong())
            }
        }
        return elves
    }

    fun getElfWithMostCalories(elves: ArrayList<ArrayList<Long>>): ArrayList<Long> {
        return elves.stream().max(Comparator.comparingLong { elf -> elf.stream().mapToLong { it }.sum() }).get()
    }

    fun part1(input: List<String>): Int {
        val elves = getElves(input)
        return getElfWithMostCalories(elves).stream()
            .mapToLong { it }.sum().toInt()
    }

    fun part2(input: List<String>): Int {
        val elves = getElves(input)
        var totalCalories = 0
        for(i in 0..2) {
            val elfWithMostCalories = getElfWithMostCalories(elves)
            totalCalories += elfWithMostCalories.stream().mapToLong { it }.sum().toInt()
            elves.remove(elfWithMostCalories)
        }
        return totalCalories
    }

    val input = readInput("input", "src/day01")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
