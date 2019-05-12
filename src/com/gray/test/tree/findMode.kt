package com.gray.test.tree

/**
 * 501. 二叉搜索树中的众数
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *  结点左子树中所含结点的值小于等于当前结点的值
 *  结点右子树中所含结点的值大于等于当前结点的值
 *  左子树和右子树都是二叉搜索树
 *
 * 例如：
 *  给定 BST [1,null,2,2],
 *  1
 *   \
 *    2
 *  /
 *  2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * */

fun findMode(root: TreeNode?): IntArray {
    if (root == null) {
        return intArrayOf()
    }
    val ret = arrayListOf<Int>()
    var flag = false
    var value = 0
    var count = 0
    var max = 0
    fun dfs(root: TreeNode?) {
        if (root == null) {
            return
        }
        dfs(root.left)
        if (!flag) {
            flag = true
            value = root.`val`
            count = 1
        } else if (value == root.`val`) {
            count++
        } else {
            if (count > max) {
                max = count
                ret.clear()
                ret.add(value)
            } else if (count == max) {
                ret.add(value)
            }
            count = 1
            value = root.`val`
        }
        dfs(root.right)
    }
    dfs(root)
    if (count > max) {
        max = count
        ret.clear()
        ret.add(value)
    } else if (count == max) {
        ret.add(value)
    }
    return ret.toIntArray()
}