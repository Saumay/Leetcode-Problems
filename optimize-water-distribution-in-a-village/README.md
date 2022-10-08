<h2>  Optimize Water Distribution in a Village</h2><hr><div style="user-select: auto;"><p style="user-select: auto;">There are <code style="user-select: auto;">n</code> houses in a village. We want to supply water for all the houses by building wells and laying pipes.</p>

<p style="user-select: auto;">For each house <code style="user-select: auto;">i</code>, we can either build a well inside it directly with cost <code style="user-select: auto;">wells[i - 1]</code> (note the <code style="user-select: auto;">-1</code> due to <strong style="user-select: auto;">0-indexing</strong>), or pipe in water from another well to it. The costs to lay pipes between houses are given by the array <code style="user-select: auto;">pipes</code> where each <code style="user-select: auto;">pipes[j] = [house1<sub style="user-select: auto;">j</sub>, house2<sub style="user-select: auto;">j</sub>, cost<sub style="user-select: auto;">j</sub>]</code> represents the cost to connect <code style="user-select: auto;">house1<sub style="user-select: auto;">j</sub></code> and <code style="user-select: auto;">house2<sub style="user-select: auto;">j</sub></code> together using a pipe. Connections are bidirectional, and there could be multiple valid connections between the same two houses with different costs.</p>

<p style="user-select: auto;">Return <em style="user-select: auto;">the minimum total cost to supply water to all houses</em>.</p>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/05/22/1359_ex1.png" style="width: 189px; height: 196px; user-select: auto;">
<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
<strong style="user-select: auto;">Output:</strong> 3
<strong style="user-select: auto;">Explanation:</strong> The image shows the costs of connecting houses using pipes.
The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so the total cost is 3.
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> n = 2, wells = [1,1], pipes = [[1,2,1],[1,2,2]]
<strong style="user-select: auto;">Output:</strong> 2
<strong style="user-select: auto;">Explanation:</strong> We can supply water with cost two using one of the three options:
Option 1:
  - Build a well inside house 1 with cost 1.
  - Build a well inside house 2 with cost 1.
The total cost will be 2.
Option 2:
  - Build a well inside house 1 with cost 1.
  - Connect house 2 with house 1 with cost 1.
The total cost will be 2.
Option 3:
  - Build a well inside house 2 with cost 1.
  - Connect house 1 with house 2 with cost 1.
The total cost will be 2.
Note that we can connect houses 1 and 2 with cost 1 or with cost 2 but we will always choose <strong style="user-select: auto;">the cheapest option</strong>. 
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">2 &lt;= n &lt;= 10<sup style="user-select: auto;">4</sup></code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">wells.length == n</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">0 &lt;= wells[i] &lt;= 10<sup style="user-select: auto;">5</sup></code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= pipes.length &lt;= 10<sup style="user-select: auto;">4</sup></code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">pipes[j].length == 3</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= house1<sub style="user-select: auto;">j</sub>, house2<sub style="user-select: auto;">j</sub> &lt;= n</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">0 &lt;= cost<sub style="user-select: auto;">j</sub> &lt;= 10<sup style="user-select: auto;">5</sup></code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">house1<sub style="user-select: auto;">j</sub> != house2<sub style="user-select: auto;">j</sub></code></li>
</ul>
</div>