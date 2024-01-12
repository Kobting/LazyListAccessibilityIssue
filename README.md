# LazyList Accessibility Issue
Lazy lists have an issue where the accessibility screen reader (TalkBack) will randomly jump to the highest UI element on screen when the column/row performs a scroll due to reaching the end of the screen requiring the column/row to scroll to the rest of its content.  

Note: This is very dependent on the display size / density + the compose screen. This example was happening on a Pixel 5a with display size set 1 down from the max.

Video Example:

https://github.com/Kobting/LazyListAccessibilityIssue/assets/40338395/16f41675-7837-4e08-a8dc-12b29ff141cf

