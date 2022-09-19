<h2><a href="https://leetcode.com/problems/subdomain-visit-count/">811. Subdomain Visit Count</a></h2><h3>Medium</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">A website domain <code style="user-select: auto;">"discuss.leetcode.com"</code> consists of various subdomains. At the top level, we have <code style="user-select: auto;">"com"</code>, at the next level, we have <code style="user-select: auto;">"leetcode.com"</code>&nbsp;and at the lowest level, <code style="user-select: auto;">"discuss.leetcode.com"</code>. When we visit a domain like <code style="user-select: auto;">"discuss.leetcode.com"</code>, we will also visit the parent domains <code style="user-select: auto;">"leetcode.com"</code> and <code style="user-select: auto;">"com"</code> implicitly.</p>

<p style="user-select: auto;">A <strong style="user-select: auto;">count-paired domain</strong> is a domain that has one of the two formats <code style="user-select: auto;">"rep d1.d2.d3"</code> or <code style="user-select: auto;">"rep d1.d2"</code> where <code style="user-select: auto;">rep</code> is the number of visits to the domain and <code style="user-select: auto;">d1.d2.d3</code> is the domain itself.</p>

<ul style="user-select: auto;">
	<li style="user-select: auto;">For example, <code style="user-select: auto;">"9001 discuss.leetcode.com"</code> is a <strong style="user-select: auto;">count-paired domain</strong> that indicates that <code style="user-select: auto;">discuss.leetcode.com</code> was visited <code style="user-select: auto;">9001</code> times.</li>
</ul>

<p style="user-select: auto;">Given an array of <strong style="user-select: auto;">count-paired domains</strong> <code style="user-select: auto;">cpdomains</code>, return <em style="user-select: auto;">an array of the <strong style="user-select: auto;">count-paired domains</strong> of each subdomain in the input</em>. You may return the answer in <strong style="user-select: auto;">any order</strong>.</p>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> cpdomains = ["9001 discuss.leetcode.com"]
<strong style="user-select: auto;">Output:</strong> ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
<strong style="user-select: auto;">Explanation:</strong> We only have one website domain: "discuss.leetcode.com".
As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
<strong style="user-select: auto;">Output:</strong> ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
<strong style="user-select: auto;">Explanation:</strong> We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times.
For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= cpdomain.length &lt;= 100</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= cpdomain[i].length &lt;= 100</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">cpdomain[i]</code> follows either the <code style="user-select: auto;">"rep<sub style="user-select: auto;">i</sub> d1<sub style="user-select: auto;">i</sub>.d2<sub style="user-select: auto;">i</sub>.d3<sub style="user-select: auto;">i</sub>"</code> format or the <code style="user-select: auto;">"rep<sub style="user-select: auto;">i</sub> d1<sub style="user-select: auto;">i</sub>.d2<sub style="user-select: auto;">i</sub>"</code> format.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">rep<sub style="user-select: auto;">i</sub></code> is an integer in the range <code style="user-select: auto;">[1, 10<sup style="user-select: auto;">4</sup>]</code>.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">d1<sub style="user-select: auto;">i</sub></code>, <code style="user-select: auto;">d2<sub style="user-select: auto;">i</sub></code>, and <code style="user-select: auto;">d3<sub style="user-select: auto;">i</sub></code> consist of lowercase English letters.</li>
</ul>
</div>