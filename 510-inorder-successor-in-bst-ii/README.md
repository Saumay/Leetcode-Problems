<h2><a href="https://leetcode.com/problems/inorder-successor-in-bst-ii/">510. Inorder Successor in BST II</a></h2><h3>Medium</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">Given a <code style="user-select: auto;">node</code> in a binary search tree, return <em style="user-select: auto;">the in-order successor of that node in the BST</em>. If that node has no in-order successor, return <code style="user-select: auto;">null</code>.</p>

<p style="user-select: auto;">The successor of a <code style="user-select: auto;">node</code> is the node with the smallest key greater than <code style="user-select: auto;">node.val</code>.</p>

<p style="user-select: auto;">You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node. Below is the definition for <code style="user-select: auto;">Node</code>:</p>

<pre style="user-select: auto;">class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/23/285_example_1.PNG" style="width: 122px; height: 117px; user-select: auto;">
<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> tree = [2,1,3], node = 1
<strong style="user-select: auto;">Output:</strong> 2
<strong style="user-select: auto;">Explanation:</strong> 1's in-order successor node is 2. Note that both the node and the return value is of Node type.
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/23/285_example_2.PNG" style="width: 246px; height: 229px; user-select: auto;">
<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> tree = [5,3,6,2,4,null,null,1], node = 6
<strong style="user-select: auto;">Output:</strong> null
<strong style="user-select: auto;">Explanation:</strong> There is no in-order successor of the current node, so the answer is null.
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;">The number of nodes in the tree is in the range <code style="user-select: auto;">[1, 10<sup style="user-select: auto;">4</sup>]</code>.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">-10<sup style="user-select: auto;">5</sup> &lt;= Node.val &lt;= 10<sup style="user-select: auto;">5</sup></code></li>
	<li style="user-select: auto;">All Nodes will have unique values.</li>
</ul>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Follow up:</strong> Could you solve it without looking up any of the node's values?</p>
</div>