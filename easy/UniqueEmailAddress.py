"""
https://leetcode.com/problems/unique-email-addresses/

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
"""


class Solution:
    def numUniqueEmails(self, emails):
        """
        :type emails: List[str]
        :rtype: int
        """
        count = 0
        dictofemails = {}
        for email in emails:
            resolved_email = ''
            localname, domain = email.split('@')
            resolved_email += self.resolve_component(localname)
            resolved_email += '@'
            resolved_email += domain
            dictofemails[resolved_email] = True
        return len(dictofemails)
    
    def resolve_component(self, str):
        resolved_str = ''
        for c in str:
            if c == '.':
                continue
            if c == '+':
                break
            resolved_str += c
        return resolved_str


if __name__ == '__main__':
    emails = [
        'test.email+alex@leetcode.com',
        'test.e.mail+bob.cathy@leetcode.com',
        'testemail+david@lee.tcode.com',
    ]
    ans = Solution().numUniqueEmails(emails)
    print(ans)
