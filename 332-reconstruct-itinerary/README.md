<h2><a href="https://leetcode.com/problems/reconstruct-itinerary/">332. Reconstruct Itinerary</a></h2><h3>Hard</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">You are given a list of airline <code style="user-select: auto;">tickets</code> where <code style="user-select: auto;">tickets[i] = [from<sub style="user-select: auto;">i</sub>, to<sub style="user-select: auto;">i</sub>]</code> represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.</p>

<p style="user-select: auto;">All of the tickets belong to a man who departs from <code style="user-select: auto;">"JFK"</code>, thus, the itinerary must begin with <code style="user-select: auto;">"JFK"</code>. If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.</p>

<ul style="user-select: auto;">
	<li style="user-select: auto;">For example, the itinerary <code style="user-select: auto;">["JFK", "LGA"]</code> has a smaller lexical order than <code style="user-select: auto;">["JFK", "LGB"]</code>.</li>
</ul>

<p style="user-select: auto;">You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.</p>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/itinerary1-graph.jpg" style="width: 382px; height: 222px; user-select: auto;">
<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
<strong style="user-select: auto;">Output:</strong> ["JFK","MUC","LHR","SFO","SJC"]
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/itinerary2-graph.jpg" style="width: 222px; height: 230px; user-select: auto;">
<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
<strong style="user-select: auto;">Output:</strong> ["JFK","ATL","JFK","SFO","ATL","SFO"]
<strong style="user-select: auto;">Explanation:</strong> Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= tickets.length &lt;= 300</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">tickets[i].length == 2</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">from<sub style="user-select: auto;">i</sub>.length == 3</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">to<sub style="user-select: auto;">i</sub>.length == 3</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">from<sub style="user-select: auto;">i</sub></code> and <code style="user-select: auto;">to<sub style="user-select: auto;">i</sub></code> consist of uppercase English letters.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">from<sub style="user-select: auto;">i</sub> != to<sub style="user-select: auto;">i</sub></code></li>
</ul>
</div>