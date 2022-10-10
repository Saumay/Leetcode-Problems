<h2><a href="https://leetcode.com/problems/missing-ranges/">163. Missing Ranges</a></h2><h3>Easy</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">You are given an inclusive range <code style="user-select: auto;">[lower, upper]</code> and a <strong style="user-select: auto;">sorted unique</strong> integer array <code style="user-select: auto;">nums</code>, where all elements are in the inclusive range.</p>

<p style="user-select: auto;">A number <code style="user-select: auto;">x</code> is considered <strong style="user-select: auto;">missing</strong> if <code style="user-select: auto;">x</code> is in the range <code style="user-select: auto;">[lower, upper]</code> and <code style="user-select: auto;">x</code> is not in <code style="user-select: auto;">nums</code>.</p>

<p style="user-select: auto;">Return <em style="user-select: auto;">the <strong style="user-select: auto;">smallest sorted</strong> list of ranges that <strong style="user-select: auto;">cover every missing number exactly</strong></em>. That is, no element of <code style="user-select: auto;">nums</code> is in any of the ranges, and each missing number is in one of the ranges.</p>

<p style="user-select: auto;">Each range <code style="user-select: auto;">[a,b]</code> in the list should be output as:</p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">"a-&gt;b"</code> if <code style="user-select: auto;">a != b</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">"a"</code> if <code style="user-select: auto;">a == b</code></li>
</ul>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong class="example" style="user-select: auto;">Example 1:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> nums = [0,1,3,50,75], lower = 0, upper = 99
<strong style="user-select: auto;">Output:</strong> ["2","4-&gt;49","51-&gt;74","76-&gt;99"]
<strong style="user-select: auto;">Explanation:</strong> The ranges are:
[2,2] --&gt; "2"
[4,49] --&gt; "4-&gt;49"
[51,74] --&gt; "51-&gt;74"
[76,99] --&gt; "76-&gt;99"
</pre>

<p style="user-select: auto;"><strong class="example" style="user-select: auto;">Example 2:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> nums = [-1], lower = -1, upper = -1
<strong style="user-select: auto;">Output:</strong> []
<strong style="user-select: auto;">Explanation:</strong> There are no missing ranges since there are no missing numbers.
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">-10<sup style="user-select: auto;">9</sup> &lt;= lower &lt;= upper &lt;= 10<sup style="user-select: auto;">9</sup></code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">0 &lt;= nums.length &lt;= 100</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">lower &lt;= nums[i] &lt;= upper</code></li>
	<li style="user-select: auto;">All the values of <code style="user-select: auto;">nums</code> are <strong style="user-select: auto;">unique</strong>.</li>
</ul>
</div>