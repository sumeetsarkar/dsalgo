"""
This problem was asked by Google.

The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return

{{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
"""


def powerset(list):
    set_size = len(list)
    possible_sets = 2 ** set_size
    for counter in range(possible_sets):
        for i in range(set_size):
            if (counter & 1 << i) > 0:
                print(list[i])
        print('\n')


def main():
    list = [1, 2, 3]
    powerset(list)


main()
