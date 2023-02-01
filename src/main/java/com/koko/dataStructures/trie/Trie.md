## Use cases

1. To insert words and save.
2. To search a word among saved words.
3. To search all words starting from a certain Prefix.
4. To count words equal to given word.
5. To count words starting with a given Prefix.
6. To delete word from saved words.
7. To calculate **Nbr of distinct substrings in a string**
8. To find **Maximum XOR between number array and given number**
9. **Autocomplete, Spell checker, IP routing(Longest Prefix matching)
    T9 Predictive text, Word games solving**

## Structure

```
trie{
  trie a[26];
  boolean flag;
}
```

1. **Insert functionality**
2. For every char in the word, add another Node trie and place its reference in array a.
2. Once you reach the last char, and have added its reference.
3. Mark the flag as true in the reference.
4. This signifies that word ends here.

5. **Search function**
6. Traverse through the nodes as per chars, and find the flag at last ref.
7. If flag is true, word is present.

8. **Starts With Function**
9. If you find a null reference after last char-> No such words with this prefix.

10. **For counts**
```
trie{
  trie a[26];
  countEndsWith = 0;
  countPrefix = 0;
}
```

11. **Complete String**
    1. A complete string is in which every prefix of this string is also present in the List.




