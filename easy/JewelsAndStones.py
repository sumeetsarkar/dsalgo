"""
https://leetcode.com/problems/jewels-and-stones/
"""

class Solution:
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        if S is None or J is None or len(S) == 0 or len(J) == 0:
            return 0
        count = 0
        for i in S:
            if i in J:
                count += 1
        return count


if __name__ == '__main__':
    ans = Solution().numJewelsInStones('aA', 'aAAbbbb')
    print(ans)
