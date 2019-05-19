package com.gray.test.math

/***
 * 868. 二进制间距
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 * 如果没有两个连续的 1，返回 0 。
 *
 * 示例 1：
 * 输入：22
 * 输出：2
 * 解释：
 * 22 的二进制是 0b10110 。
 * 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
 * 第一对连续的 1 中，两个 1 之间的距离为 2 。
 * 第二对连续的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 *
 * 示例 2：
 * 输入：5
 * 输出：2
 * 解释：
 * 5 的二进制是 0b101 。
 *
 * 示例 3：
 * 输入：6
 * 输出：1
 * 解释：
 * 6 的二进制是 0b110 。
 *
 * 示例 4：
 * 输入：8
 * 输出：0
 * 解释：
 * 8 的二进制是 0b1000 。
 * 在 8 的二进制表示中没有连续的 1，所以返回 0 。
 *
 * 提示：
 * 1 <= N <= 10^9
 */
fun binaryGap(N: Int): Int {
    var p = N
    var lastIndex = -1
    var digit = 0
    var ret = 0
    while (p > 0) {
        val t = p % 2
        p /= 2
        if (t == 1) {
            if (lastIndex == -1) {
                lastIndex = digit
            } else {
                val gap = digit - lastIndex
                lastIndex = digit
                if (gap > ret) {
                    ret = gap
                }

            }
        }
        digit++
    }
    return ret
}