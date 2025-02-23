# CSC 207: Text Editor

**Author**: Linh Vu

## Resources Used

- IDE: VSCode
- Java version 23.0.2
- Project's instruction: https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html
- Jqwik User guide: https://jqwik.net/docs/current/user-guide.html

## Changelog

- Implement SimpleStringBuffer with constructor and basic methods
- Add unit tests and a property test for SimpleStringBuffer
- Add SimpleStringBuffer's insert runtime analysis
- Implement GapBuffer with constructor and basic methods
- Refactor direct property access to use getter methods for both buffers
- Add GapBuffer's unit tests and property test based on SimpleStringBuffer
- Debug failed GapBuffer's unit tests by fixing out of bound errors and add edge cases
- Add expandBuffer method for GapBuffer
- Create screen object in TextEditor
- Implement drawBuffer function and KeyStroke cases in TextEditor
- Implement File Input/Output in TextEditor
- Fix format for good styling
- Debug failed Gradescope test cases in GapBuffer by changing endGap index
- Update README with changelog

## Runtime analysis

**SimpleStringBuffer's insert method:**

- Input: character ch to be inserted at the cursor position
- Critical operation: substring and concatenation. The method's runtime is dependent on the length of the current string, which we will call n.
  - The substring operation: since Java strings are immutable, substring() does not slice the original string but creates a new substring. The cursor can be anywhere in the string including at the beginning or at the end, meaning we have to traverse through the whole string once at worst case. This results in a run time of n for each call of substring().
  - The concatenation operation: since Java strings are immutable, the concatenation method does not modify the original string but creates a new string. This requires traversing through the whole string once to copy all characters at worst case. This results in a run time of n for each use of concatenation.
  - Incrementing the cursor takes a constant run time of 1.
- Mathematical function: T(n) = 3n + 1
- Insert is O(n)
