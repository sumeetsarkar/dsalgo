"""
https://leetcode.com/problems/remove-element/
"""


class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        N = len(nums)
        if N == 0:
            return 0
        indexlist = []
        for i in range(N):
            if nums[i] == val:
                indexlist.append(i)
        j = 0
        M = len(indexlist)
        if M == 0:
            return N
        for i in reversed(range(N)):
            if nums[i] != val:
                nums[i], nums[indexlist[j]] = nums[indexlist[j]], nums[i]
                j += 1
            if i + M == N:
                break
        return N - M


if __name__ == '__main__':
    ans = Solution().removeElement([0,1,2,2,3,0,4,2], 2)
    print(ans)
    ans = Solution().removeElement([2], 3)

"""
[0, 1, 2, 2, 3, 0, 4, 2]
[0, 1, 4, 2, 3, 0, 2, 2]
[0, 1, 4, 0, 3, 2, 2, 2]
"""