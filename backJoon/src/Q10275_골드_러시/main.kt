package Q10275_골드_러시

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val t = bf.readLine().toInt()
    val answer = StringBuilder()

    for (i in 0 until t) {
        val (n, a, b) = bf.readLine().split(" ").map { it.toLong() }
        var gold: Long = 1
        for (j in 0 until n) {
            gold *= 2
        }

        if (a % 2 == 1L) {
            answer.append("$n\n")
            continue
        } else {
            var target = min(a, b)
            var cut = 0

            while (target != 0L) {
                if (gold > target) {
                    gold /= 2
                    cut++
                } else {
                    target -= gold
                }
            }

            answer.append("$cut\n")
        }
    }

    print(answer)
}