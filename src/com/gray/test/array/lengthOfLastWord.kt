package com.gray.test.array

/**
 * 58. 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *  输入: "Hello World"
 *  输出: 5
 * */

fun lengthOfLastWord(s: String): Int {
    var count = 0
    var startCount = false
    for (i in s.length - 1 downTo 0) {
        if (s[i] != ' ') {
            count++
            startCount = true
        } else {
            if (startCount) {
                return count
            }
        }
    }
    return count
}

fun main() {

}