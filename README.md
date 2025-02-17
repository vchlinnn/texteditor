# CSC 207: Text Editor

**Author**: Linh Vu

## Resources Used

- IDE: VSCode
- Java version 23.0.2
- Project's instruction: https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html
- Jqwik User guide: https://jqwik.net/docs/current/user-guide.html

## Changelog

_(TODO: fill me in with a log of your committed changes)_

## Runtime analysis

**SimpleStringBuffer's insert method:**

- Input: character ch to be inserted at the cursor position
- Critical operation: substring and concatenation. The method's runtime is dependent on the length of the current string, which we will call n.
  - The substring operation: since Java strings are immutable, substring() does not slice the original string but creates a new substring. The cursor can be anywhere in the string including at the beginning or at the end, meaning we have to traverse through the whole string once at worst case. This results in a run time of n for each call of substring().
  - The concatenation operation: since Java strings are immutable, the concatenation method does not modify the original string but creates a new string. This requires traversing through the whole string once to copy all characters at worst case. This results in a run time of n for each use of concatenation.
  - Incrementing the cursor takes a constant run time of 1.
- Mathematical function: 3n + 1
- Insert is O(n)
