<h2>  Alien Dictionary</h2><hr><div style="user-select: auto;"><p style="user-select: auto;">There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.</p>

<p style="user-select: auto;">You are given a list of strings <code style="user-select: auto;">words</code> from the alien language's dictionary, where the strings in <code style="user-select: auto;">words</code> are <strong style="user-select: auto;">sorted lexicographically</strong> by the rules of this new language.</p>

<p style="user-select: auto;">Return <em style="user-select: auto;">a string of the unique letters in the new alien language sorted in <strong style="user-select: auto;">lexicographically increasing order</strong> by the new language's rules. If there is no solution, return </em><code style="user-select: auto;">""</code><em style="user-select: auto;">. If there are multiple solutions, return <strong style="user-select: auto;">any of them</strong></em>.</p>

<p style="user-select: auto;">A string <code style="user-select: auto;">s</code> is <strong style="user-select: auto;">lexicographically smaller</strong> than a string <code style="user-select: auto;">t</code> if at the first letter where they differ, the letter in <code style="user-select: auto;">s</code> comes before the letter in <code style="user-select: auto;">t</code> in the alien language. If the first <code style="user-select: auto;">min(s.length, t.length)</code> letters are the same, then <code style="user-select: auto;">s</code> is smaller if and only if <code style="user-select: auto;">s.length &lt; t.length</code>.</p>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> words = ["wrt","wrf","er","ett","rftt"]
<strong style="user-select: auto;">Output:</strong> "wertf"
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> words = ["z","x"]
<strong style="user-select: auto;">Output:</strong> "zx"
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 3:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> words = ["z","x","z"]
<strong style="user-select: auto;">Output:</strong> ""
<strong style="user-select: auto;">Explanation:</strong> The order is invalid, so return <code style="user-select: auto;">""</code>.
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= words.length &lt;= 100</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= words[i].length &lt;= 100</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">words[i]</code> consists of only lowercase English letters.</li>
</ul>
</div>