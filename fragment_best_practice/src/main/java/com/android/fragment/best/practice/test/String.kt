package com.android.fragment.best.practice.test

/**
 * 获取字符串中的字符长度
 *
 * @param str 字符串
 * @return 返回字符长度
 * @date 2022/6/15 22:04
 */
fun String.lettersCount(str: String) : Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}