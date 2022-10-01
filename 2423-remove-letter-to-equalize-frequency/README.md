<h2><a href="https://leetcode.com/problems/remove-letter-to-equalize-frequency/">2423. Remove Letter To Equalize Frequency</a></h2><h3>Easy</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">You are given a <strong style="user-select: auto;">0-indexed</strong> string <code style="user-select: auto;">word</code>, consisting of lowercase English letters. You need to select <strong style="user-select: auto;">one</strong> index and <strong style="user-select: auto;">remove</strong> the letter at that index from <code style="user-select: auto;">word</code> so that the <strong style="user-select: auto;">frequency</strong> of every letter present in <code style="user-select: auto;">word</code> is equal.</p>

<p style="user-select: auto;">Return<em style="user-select: auto;"> </em><code style="user-select: auto;">true</code><em style="user-select: auto;"> if it is possible to remove one letter so that the frequency of all letters in </em><code style="user-select: auto;">word</code><em style="user-select: auto;"> are equal, and </em><code style="user-select: auto;">false</code><em style="user-select: auto;"> otherwise</em>.</p>

<p style="user-select: auto;"><strong style="user-select: auto;">Note:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;">The <b style="user-select: auto;">frequency</b> of a letter <code style="user-select: auto;">x</code> is the number of times it occurs in the string.</li>
	<li style="user-select: auto;">You <strong style="user-select: auto;">must</strong> remove exactly one letter and cannot chose to do nothing.</li>
</ul>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> word = "abcc"
<strong style="user-select: auto;">Output:</strong> true
<strong style="user-select: auto;">Explanation:</strong> Select index 3 and delete it: word becomes "abc" and each character has a frequency of 1.
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> word = "aazz"
<strong style="user-select: auto;">Output:</strong> false
<strong style="user-select: auto;">Explanation:</strong> We must delete a character, so either the frequency of "a" is 1 and the frequency of "z" is 2, or vice versa. It is impossible to make all present letters have equal frequency.
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">2 &lt;= word.length &lt;= 100</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">word</code> consists of lowercase English letters only.</li>
</ul>
</div>