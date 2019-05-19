package com.gray.test.array

import kotlin.math.pow

/***
 * 970. 强整数
 * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 *
 * 示例 1：
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 *
 * 示例 2：
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 *
 * 提示：
 * 1 <= x <= 100
 * 1 <= y <= 100
 * 0 <= bound <= 10^6
 */
fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
    val ret = hashSetOf<Int>()
    val small = if (x < y) x.toDouble() else y.toDouble()
    val big = if (x < y) y.toDouble() else x.toDouble()
    val maxI = if (small == 1.0) 0 else Math.floor(Math.log(bound.toDouble()) / Math.log(small)).toInt()
    val maxJ = if (big == 1.0) 0 else Math.floor(Math.log(bound.toDouble()) / Math.log(big)).toInt()
    for (j in 0..maxJ) {
        val base = big.pow(j)
        for (i in 0..maxI) {
            val num = base + small.pow(i)
            if (num > bound) {
                break
            }
            ret.add(num.toInt())
        }
    }
    return ret.toList()
}

fun main() {
    powerfulIntegers(2, 3, 10)
}