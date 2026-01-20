package leetcode

fun main() {
    val nums = intArrayOf(0,2,3,4,5,2,4,5,2,2,2,35,6,7);
    val `val` = 2;

    val k = removeElement(nums, `val`);
    printArray(nums)
    println(k)
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var k = nums.size
    var i = 0;

    while(i < k) {
        if(nums[i] == `val`) {
            nums[i] = nums[k-1]
            k--;
        } else {
            i++
        }
    }
    return k;
}

fun removeElementOrder(nums: IntArray, `val`: Int): Int {
    var write = 0

    for (read in nums.indices) {
        if (nums[read] != `val`) {
            nums[write] = nums[read]
            write++
        }
    }

    return write
}