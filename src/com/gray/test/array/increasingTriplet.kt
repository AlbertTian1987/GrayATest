package com.gray.test.array


/**
 * (中级)
 * 递增的三元子序列
 *
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * 数学表达式如下:
 *      如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 *      使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 *      说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *      输入: [1,2,3,4,5]
 *      输出: true
 *
 * 示例 2:
 *      输入: [5,4,3,2,1]
 *      输出: false
 */
fun increasingTriplet(nums: IntArray): Boolean {
    var a = Int.MAX_VALUE
    var b = Int.MAX_VALUE
    for (i in nums) {
        when {
            i <= a -> a = i
            i <= b -> b = i
            else -> return true
        }
    }
    return false
}

fun main() {
    println(increasingTriplet(intArrayOf(1, 2, 3, 4, 5)))
    println(increasingTriplet(intArrayOf(5, 4, 3, 2, 1)))
    println(increasingTriplet(intArrayOf(5, 4, 3, 2, 1, 3, 2, 5, 3, 2, 3, 1, 1, 7, 10)))
}