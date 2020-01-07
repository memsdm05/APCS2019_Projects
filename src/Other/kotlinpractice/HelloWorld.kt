package Other.kotlinpractice

import kotlin.random.Random

val lineDist: ArrayList<Int> = arrayListOf();
val lineWait: ArrayList<Int> = arrayListOf();

fun smoothArrayGen(arr: ArrayList<Int>, n: Int, rep: Int, max: Int) {
    for (i in 0..n - 1) {
        arr.add(Random.nextInt(0, max));
    }

    for (r in 1..rep) {
        for (d in 1..n - 2) {
            arr.set(d, (arr.get(d - 1) + arr.get(d) + arr.get(d + 1)) / 3)
        }
    }
}



fun main(args: Array<String>) {
    smoothArrayGen(lineDist,20,1, 15)
    println("Loading...")
    for (i in 0..lineDist.size-1) {
        for (char in 1..lineDist.get(i))
            print("*")
        println()
    }
}
