<h2><a href="https://leetcode.com/problems/cherry-pickup-ii/">1463. Cherry Pickup II</a></h2><h3>Hard</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">You are given a <code style="user-select: auto;">rows x cols</code> matrix <code style="user-select: auto;">grid</code> representing a field of cherries where <code style="user-select: auto;">grid[i][j]</code> represents the number of cherries that you can collect from the <code style="user-select: auto;">(i, j)</code> cell.</p>

<p style="user-select: auto;">You have two robots that can collect cherries for you:</p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><strong style="user-select: auto;">Robot #1</strong> is located at the <strong style="user-select: auto;">top-left corner</strong> <code style="user-select: auto;">(0, 0)</code>, and</li>
	<li style="user-select: auto;"><strong style="user-select: auto;">Robot #2</strong> is located at the <strong style="user-select: auto;">top-right corner</strong> <code style="user-select: auto;">(0, cols - 1)</code>.</li>
</ul>

<p style="user-select: auto;">Return <em style="user-select: auto;">the maximum number of cherries collection using both robots by following the rules below</em>:</p>

<ul style="user-select: auto;">
	<li style="user-select: auto;">From a cell <code style="user-select: auto;">(i, j)</code>, robots can move to cell <code style="user-select: auto;">(i + 1, j - 1)</code>, <code style="user-select: auto;">(i + 1, j)</code>, or <code style="user-select: auto;">(i + 1, j + 1)</code>.</li>
	<li style="user-select: auto;">When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.</li>
	<li style="user-select: auto;">When both robots stay in the same cell, only one takes the cherries.</li>
	<li style="user-select: auto;">Both robots cannot move outside of the grid at any moment.</li>
	<li style="user-select: auto;">Both robots should reach the bottom row in <code style="user-select: auto;">grid</code>.</li>
</ul>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong class="example" style="user-select: auto;">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/04/29/sample_1_1802.png" style="width: 374px; height: 501px; user-select: auto;">
<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
<strong style="user-select: auto;">Output:</strong> 24
<strong style="user-select: auto;">Explanation:</strong> Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.
</pre>

<p style="user-select: auto;"><strong class="example" style="user-select: auto;">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/04/23/sample_2_1802.png" style="width: 500px; height: 452px; user-select: auto;">
<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
<strong style="user-select: auto;">Output:</strong> 28
<strong style="user-select: auto;">Explanation:</strong> Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">rows == grid.length</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">cols == grid[i].length</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">2 &lt;= rows, cols &lt;= 70</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">0 &lt;= grid[i][j] &lt;= 100</code></li>
</ul>
</div>