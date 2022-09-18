<h2>  Graph Valid Tree</h2><hr><div style="user-select: auto;"><p style="user-select: auto;">You have a graph of <code style="user-select: auto;">n</code> nodes labeled from <code style="user-select: auto;">0</code> to <code style="user-select: auto;">n - 1</code>. You are given an integer n and a list of <code style="user-select: auto;">edges</code> where <code style="user-select: auto;">edges[i] = [a<sub style="user-select: auto;">i</sub>, b<sub style="user-select: auto;">i</sub>]</code> indicates that there is an undirected edge between nodes <code style="user-select: auto;">a<sub style="user-select: auto;">i</sub></code> and <code style="user-select: auto;">b<sub style="user-select: auto;">i</sub></code> in the graph.</p>

<p style="user-select: auto;">Return <code style="user-select: auto;">true</code> <em style="user-select: auto;">if the edges of the given graph make up a valid tree, and</em> <code style="user-select: auto;">false</code> <em style="user-select: auto;">otherwise</em>.</p>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/12/tree1-graph.jpg" style="width: 222px; height: 302px; user-select: auto;">
<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
<strong style="user-select: auto;">Output:</strong> true
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/12/tree2-graph.jpg" style="width: 382px; height: 222px; user-select: auto;">
<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
<strong style="user-select: auto;">Output:</strong> false
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= n &lt;= 2000</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">0 &lt;= edges.length &lt;= 5000</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">edges[i].length == 2</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">0 &lt;= a<sub style="user-select: auto;">i</sub>, b<sub style="user-select: auto;">i</sub> &lt; n</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">a<sub style="user-select: auto;">i</sub> != b<sub style="user-select: auto;">i</sub></code></li>
	<li style="user-select: auto;">There are no self-loops or repeated edges.</li>
</ul>
</div>