"""
https://leetcode.com/problems/hamming-distance/

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
"""


class Solution:
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        result = x ^ y
        count = 0
        for bit in str(bin(result)):
            if bit == '1':
                count += 1
        return count

if __name__ == '__main__':
    ans = Solution().hammingDistance(1, 4)
    print(ans)
