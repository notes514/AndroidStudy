package com.android.fragment.best.practice.test

/**
 *
 *
 * @author dhxstart
 * @date 2022/6/15 21:51
 */
class StringUtil {

    // Java编程中标准的实现思维
    fun lettersCount(str: String) : Int {
        var count = 0
        for (char in str) {
            if (char.isLetter()) {
                count++
            }
        }
        return count;
    }
}