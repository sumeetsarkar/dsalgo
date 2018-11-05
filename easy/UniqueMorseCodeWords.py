"""
https://leetcode.com/problems/unique-morse-code-words/

Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".

Note:
    The length of words will be at most 100.
    Each words[i] will have length in range [1, 12].
    words[i] will only consist of lowercase letters.
"""


class Solution:
    morsecodes = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]

    def uniqueMorseRepresentations(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        result = {}
        traverrsed = {}
        for word in words:
            if word not in traverrsed.keys():
                morescode = ''
                for c in word:
                    morescode += Solution.morsecodes[ord(c) - 97]
                result[morescode] = True
                traverrsed[word] = True
        return len(result)


if __name__ == '__main__':
    words = ["gin", "zen", "gig", "msg"]
    ans = Solution().uniqueMorseRepresentations(words)
    print(ans)
