"""
https://leetcode.com/problems/flipping-an-image/

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
"""


class Solution:
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        result = []
        for img in A:
            imgr = reversed(img)
            imgr = [1 if e == 0 else 0 for e in imgr]
            result.append(imgr)
        return result

if __name__ == '__main__':
    ans = Solution().flipAndInvertImage([[1,1,0],[1,0,1],[0,0,0]])
    print(ans)
