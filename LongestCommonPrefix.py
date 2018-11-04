class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0:
            return ''
        # Break the list to first word and list of remaining strings
        first_word, remaining = strs[0], strs[1:len(strs)]
        didBreak = False
        count = 0
        for i in range(len(first_word)):
            for j in range(len(remaining)):
                # Condition for index sanity && char match
                if i < len(remaining[j]) and first_word[i] == remaining[j][i]:
                    continue
                else:
                    didBreak = True
                    break
            if didBreak:
                break
            count += 1
        return first_word[0: count]


if __name__ == '__main__':
    ans = Solution().longestCommonPrefix(['flower','flow','flight'])
    print(ans)
