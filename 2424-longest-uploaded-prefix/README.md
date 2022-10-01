<h2><a href="https://leetcode.com/problems/longest-uploaded-prefix/">2424. Longest Uploaded Prefix</a></h2><h3>Medium</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">You are given a stream of <code style="user-select: auto;">n</code> videos, each represented by a <strong style="user-select: auto;">distinct</strong> number from <code style="user-select: auto;">1</code> to <code style="user-select: auto;">n</code> that you need to "upload" to a server. You need to implement a data structure that calculates the length of the <strong style="user-select: auto;">longest uploaded prefix</strong> at various points in the upload process.</p>

<p style="user-select: auto;">We consider <code style="user-select: auto;">i</code> to be an uploaded prefix if all videos in the range <code style="user-select: auto;">1</code> to <code style="user-select: auto;">i</code> (<strong style="user-select: auto;">inclusive</strong>) have been uploaded to the server. The longest uploaded prefix is the <strong style="user-select: auto;">maximum </strong>value of <code style="user-select: auto;">i</code> that satisfies this definition.<br style="user-select: auto;">
<br style="user-select: auto;">
Implement the <code style="user-select: auto;">LUPrefix </code>class:</p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">LUPrefix(int n)</code> Initializes the object for a stream of <code style="user-select: auto;">n</code> videos.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">void upload(int video)</code> Uploads <code style="user-select: auto;">video</code> to the server.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">int longest()</code> Returns the length of the <strong style="user-select: auto;">longest uploaded prefix</strong> defined above.</li>
</ul>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input</strong>
["LUPrefix", "upload", "longest", "upload", "longest", "upload", "longest"]
[[4], [3], [], [1], [], [2], []]
<strong style="user-select: auto;">Output</strong>
[null, null, 0, null, 1, null, 3]

<strong style="user-select: auto;">Explanation</strong>
LUPrefix server = new LUPrefix(4);   // Initialize a stream of 4 videos.
server.upload(3);                    // Upload video 3.
server.longest();                    // Since video 1 has not been uploaded yet, there is no prefix.
                                     // So, we return 0.
server.upload(1);                    // Upload video 1.
server.longest();                    // The prefix [1] is the longest uploaded prefix, so we return 1.
server.upload(2);                    // Upload video 2.
server.longest();                    // The prefix [1,2,3] is the longest uploaded prefix, so we return 3.
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= n &lt;= 10<sup style="user-select: auto;">5</sup></code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= video &lt;= 10<sup style="user-select: auto;">5</sup></code></li>
	<li style="user-select: auto;">All values of <code style="user-select: auto;">video</code> are <strong style="user-select: auto;">distinct</strong>.</li>
	<li style="user-select: auto;">At most <code style="user-select: auto;">2 * 10<sup style="user-select: auto;">5</sup></code> calls <strong style="user-select: auto;">in total</strong> will be made to <code style="user-select: auto;">upload</code> and <code style="user-select: auto;">longest</code>.</li>
	<li style="user-select: auto;">At least one call will be made to <code style="user-select: auto;">longest</code>.</li>
</ul>
</div>