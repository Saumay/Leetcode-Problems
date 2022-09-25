<h2><a href="https://leetcode.com/problems/design-circular-queue/">622. Design Circular Queue</a></h2><h3>Medium</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".</p>

<p style="user-select: auto;">One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.</p>

<p style="user-select: auto;">Implementation the <code style="user-select: auto;">MyCircularQueue</code> class:</p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">MyCircularQueue(k)</code> Initializes the object with the size of the queue to be <code style="user-select: auto;">k</code>.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">int Front()</code> Gets the front item from the queue. If the queue is empty, return <code style="user-select: auto;">-1</code>.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">int Rear()</code> Gets the last item from the queue. If the queue is empty, return <code style="user-select: auto;">-1</code>.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">boolean enQueue(int value)</code> Inserts an element into the circular queue. Return <code style="user-select: auto;">true</code> if the operation is successful.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">boolean deQueue()</code> Deletes an element from the circular queue. Return <code style="user-select: auto;">true</code> if the operation is successful.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">boolean isEmpty()</code> Checks whether the circular queue is empty or not.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">boolean isFull()</code> Checks whether the circular queue is full or not.</li>
</ul>

<p style="user-select: auto;">You must solve the problem without using the built-in queue data structure in your programming language.&nbsp;</p>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input</strong>
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
<strong style="user-select: auto;">Output</strong>
[null, true, true, true, false, 3, true, true, true, 4]

<strong style="user-select: auto;">Explanation</strong>
MyCircularQueue myCircularQueue = new MyCircularQueue(3);
myCircularQueue.enQueue(1); // return True
myCircularQueue.enQueue(2); // return True
myCircularQueue.enQueue(3); // return True
myCircularQueue.enQueue(4); // return False
myCircularQueue.Rear();     // return 3
myCircularQueue.isFull();   // return True
myCircularQueue.deQueue();  // return True
myCircularQueue.enQueue(4); // return True
myCircularQueue.Rear();     // return 4
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= k &lt;= 1000</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">0 &lt;= value &lt;= 1000</code></li>
	<li style="user-select: auto;">At most <code style="user-select: auto;">3000</code> calls will be made to&nbsp;<code style="user-select: auto;">enQueue</code>, <code style="user-select: auto;">deQueue</code>,&nbsp;<code style="user-select: auto;">Front</code>,&nbsp;<code style="user-select: auto;">Rear</code>,&nbsp;<code style="user-select: auto;">isEmpty</code>, and&nbsp;<code style="user-select: auto;">isFull</code>.</li>
</ul>
</div>