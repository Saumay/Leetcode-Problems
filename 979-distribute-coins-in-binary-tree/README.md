<h2><a href="https://leetcode.com/problems/distribute-coins-in-binary-tree/">979. Distribute Coins in Binary Tree</a></h2><h3>Medium</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">You are given the <code style="user-select: auto;">root</code> of a binary tree with <code style="user-select: auto;">n</code> nodes where each <code style="user-select: auto;">node</code> in the tree has <code style="user-select: auto;">node.val</code> coins. There are <code style="user-select: auto;">n</code> coins in total throughout the whole tree.</p>

<p style="user-select: auto;">In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.</p>

<p style="user-select: auto;">Return <em style="user-select: auto;">the <strong style="user-select: auto;">minimum</strong> number of moves required to make every node have <strong style="user-select: auto;">exactly</strong> one coin</em>.</p>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/18/tree1.png" style="width: 250px; height: 236px; user-select: auto;">
<pre style="position: relative; user-select: auto;"><strong style="user-select: auto;">Input:</strong> root = [3,0,0]
<strong style="user-select: auto;">Output:</strong> 2
<strong style="user-select: auto;">Explanation: </strong>From the root of the tree, we move one coin to its left child, and one coin to its right child.
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper" style="user-select: auto;"></div></pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/18/tree2.png" style="width: 250px; height: 236px; user-select: auto;">
<pre style="position: relative; user-select: auto;"><strong style="user-select: auto;">Input:</strong> root = [0,3,0]
<strong style="user-select: auto;">Output:</strong> 3
<strong style="user-select: auto;">Explanation: </strong>From the left child of the root, we move two coins to the root [taking two moves]. Then, we move one coin from the root of the tree to the right child.
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper" style="user-select: auto;"></div></pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;">The number of nodes in the tree is <code style="user-select: auto;">n</code>.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= n &lt;= 100</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">0 &lt;= Node.val &lt;= n</code></li>
	<li style="user-select: auto;">The sum of all <code style="user-select: auto;">Node.val</code> is <code style="user-select: auto;">n</code>.</li>
</ul>
</div>