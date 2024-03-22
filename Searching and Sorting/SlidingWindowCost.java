import java.io.*;
import java.util.*;
 
public class SlidingWindowCost {
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        FastIO io = new FastIO();
        int n = io.nextInt();
		int k = io.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = io.nextInt();
		}
		// StringBuilder sb = new StringBuilder();
 
        OrderedMultiset<Integer> slidingWindow = new OrderedMultiset<>();
		for (int i = 0; i < k; i++) slidingWindow.insert(arr[i]);
 
		final int medianRank = (int)Math.ceil(k / 2.0f);
		// io.print(slidingWindow.findByOrder(medianRank));
        long sum = 0;
        for(int i=0;i<k;i++){
            sum += Math.abs(slidingWindow.findByOrder(medianRank)-arr[i]);
        }
        io.print(sum);
        int i2 = 1;
		for (int i = k; i < n; i++) {
			slidingWindow.erase(arr[i - k]);
			slidingWindow.insert(arr[i]);
 
			// io.print(" " + slidingWindow.findByOrder(medianRank));
            sum = 0;
            for(int j=i2;j<i2+k;j++){
                sum += Math.abs(slidingWindow.findByOrder(medianRank)-arr[j]);
            }
            io.print(" "+sum);
            i2++;
		}
 
		io.close();
    }
 
    static class OrderedMultiset<K extends Comparable<K>> {
		private class RBNode {
			K key;
			int count;
			RBNode left, right;
			RBNode parent;
			boolean color;
			int size;
 
			static final boolean RED = true;
			static final boolean BLACK = false;
		}
 
		private final RBNode nil = new RBNode();
		private RBNode root = this.nil;
 
		public void insert(final K k) { RB_INSERT(k, 1); }
 
		public void erase(final K k) {
			final RBNode found = TREE_SEARCH(this.root, k);
			if (found != null) RB_DELETE(found, 1);
		}
 
		public K findByOrder(final int rank) {
			return OS_SELECT(this.root, rank).key;
		}
 
		private RBNode TREE_SEARCH(final RBNode x, final K k) {
			if (x == this.nil) return null;
			if (x.key.equals(k)) return x;
			if (x.key.compareTo(k) < 0) return TREE_SEARCH(x.right, k);
 
			return TREE_SEARCH(x.left, k);
		}
 
		private RBNode TREE_MINIMUM(RBNode x) {
			while (x.left != this.nil) x = x.left;
 
			return x;
		}
 
		private void RB_INSERT(final K k, final int cnt) {
			final RBNode z = new RBNode();
			z.key = k;
			z.count = cnt;
			z.size = cnt;
 
			RBNode x = this.root;
			RBNode y = this.nil;
			while (x != this.nil) {
				x.size += cnt;
				y = x;
				if (x.key.compareTo(z.key) < 0) x = x.right;
				else if (x.key.compareTo(z.key) > 0) x = x.left;
				else {
					x.count += cnt;
					return;
				}
			}
 
			z.parent = y;
			if (y == this.nil) this.root = z;  // tree was empty
			else if (y.key.compareTo(z.key) < 0) y.right = z;
			else y.left = z;
 
			z.left = z.right = this.nil;
			z.color = RBNode.RED;
			RB_INSERT_FIXUP(z);
		}
 
		private void RB_INSERT_FIXUP(RBNode z) {
			while (z.parent.color == RBNode.RED) {
				if (z.parent == z.parent.parent.left) {
					final RBNode y = z.parent.parent.right;
					if (y.color == RBNode.RED) {
						z.parent.color = RBNode.BLACK;
						y.color = RBNode.BLACK;
						z.parent.parent.color = RBNode.RED;
						z = z.parent.parent;
					} else {
						if (z == z.parent.right) {
							z = z.parent;
							LEFT_ROTATE(z);
						}
						z.parent.color = RBNode.BLACK;
						z.parent.parent.color = RBNode.RED;
						RIGHT_ROTATE(z.parent.parent);
					}
				} else {
					final RBNode y = z.parent.parent.left;
					if (y.color == RBNode.RED) {
						z.parent.color = RBNode.BLACK;
						y.color = RBNode.BLACK;
						z.parent.parent.color = RBNode.RED;
						z = z.parent.parent;
					} else {
						if (z == z.parent.left) {
							z = z.parent;
							RIGHT_ROTATE(z);
						}
						z.parent.color = RBNode.BLACK;
						z.parent.parent.color = RBNode.RED;
						LEFT_ROTATE(z.parent.parent);
					}
				}
			}
			this.root.color = RBNode.BLACK;
		}
 
		private void RB_TRANSPLANT(final RBNode u, final RBNode v) {
			if (u.parent == this.nil) this.root = v;
			else if (u == u.parent.left) u.parent.left = v;
			else u.parent.right = v;
 
			v.parent = u.parent;
		}
 
		private void RB_DELETE(final RBNode z, final int cnt) {
			if (z.count > cnt) {
				z.count -= cnt;
				RBNode tmp = z;
				while (tmp != this.nil) {
					tmp.size -= cnt;
					tmp = tmp.parent;
				}
				return;
			}
 
			RBNode x;
			RBNode y = z;
			boolean yOriginalColor = y.color;
			if (z.left == this.nil) {
				x = z.right;
				RB_TRANSPLANT(z, z.right);  // Figure 12.4 (a)
			} else if (z.right == this.nil) {
				x = z.left;
				RB_TRANSPLANT(z, z.left);  // Figure 12.4 (b)
			} else {
				y = TREE_MINIMUM(z.right);
				yOriginalColor = y.color;
				x = y.right;
				if (y.parent == z) {
					x.parent = y;
				} else {  // Figure 12.4 (d)
					RB_TRANSPLANT(y, y.right);
					y.right = z.right;
					y.right.parent = y;
				}
				RB_TRANSPLANT(z, y);  // Figure 12.4 (c)
				y.size = z.size;
				y.left = z.left;
				y.left.parent = y;
				y.color = z.color;
			}
 
			RBNode tmp = x.parent;
			while (tmp != this.nil) {
				tmp.size -= cnt;
				tmp = tmp.parent;
			}
 
			if (yOriginalColor == RBNode.BLACK) RB_DELETE_FIXUP(x);
		}
 
		private void RB_DELETE_FIXUP(RBNode x) {
			while (x != this.root && x.color == RBNode.BLACK) {
				if (x == x.parent.left) {
					// ***** x is a left child ******
					RBNode w = x.parent.right;
					if (w.color == RBNode.RED) {
						x.parent.color = RBNode.RED;
						w.color = RBNode.BLACK;
						LEFT_ROTATE(x.parent);
						w = x.parent.right;
					}
 
					if (w.left.color == RBNode.BLACK &&
					    w.right.color == RBNode.BLACK) {
						w.color = RBNode.RED;
						x = x.parent;
					} else {
						if (w.right.color == RBNode.BLACK) {
							w.left.color = RBNode.BLACK;
							w.color = RBNode.RED;
							RIGHT_ROTATE(w);
							w = x.parent.right;
						}
						w.color = x.parent.color;
						x.parent.color = RBNode.BLACK;
						w.right.color = RBNode.BLACK;
						LEFT_ROTATE(x.parent);
						x = this.root;
					}
				} else {
					// ***** x is a right child ******
					RBNode w = x.parent.left;
					if (w.color == RBNode.RED) {
						x.parent.color = RBNode.RED;
						w.color = RBNode.BLACK;
						RIGHT_ROTATE(x.parent);
						w = x.parent.left;
					}
 
					if (w.left.color == RBNode.BLACK &&
					    w.right.color == RBNode.BLACK) {
						w.color = RBNode.RED;
						x = x.parent;
					} else {
						if (w.left.color == RBNode.BLACK) {
							w.right.color = RBNode.BLACK;
							w.color = RBNode.RED;
							LEFT_ROTATE(w);
							w = x.parent.left;
						}
						w.color = x.parent.color;
						x.parent.color = RBNode.BLACK;
						w.left.color = RBNode.BLACK;
						RIGHT_ROTATE(x.parent);
						x = this.root;
					}
				}
			}
			x.color = RBNode.BLACK;
		}
 
		private void LEFT_ROTATE(final RBNode x) {
			final RBNode y = x.right;
			x.right = y.left;
			if (y.left != this.nil) y.left.parent = x;
 
			y.parent = x.parent;
 
			if (x.parent == this.nil) this.root = y;
			else if (x == x.parent.left) x.parent.left = y;
			else x.parent.right = y;
 
			y.left = x;
			x.parent = y;
 
			y.size = x.size;
			x.size = x.left.size + x.right.size + x.count;
		}
 
		private void RIGHT_ROTATE(final RBNode x) {
			final RBNode y = x.left;
			x.left = y.right;
			if (y.right != this.nil) y.right.parent = x;
 
			y.parent = x.parent;
 
			if (x.parent == this.nil) this.root = y;
			else if (x == x.parent.left) x.parent.left = y;
			else x.parent.right = y;
 
			y.right = x;
			x.parent = y;
 
			y.size = x.size;
			x.size = x.left.size + x.right.size + x.count;
		}
 
		private RBNode OS_SELECT(final RBNode x, final int i) {
			if (i < x.left.size + 1) return OS_SELECT(x.left, i);
			else if (i > x.left.size + x.count)
				return OS_SELECT(x.right, i - x.left.size - x.count);
			else return x;
		}
 
		private int OS_RANK(final RBNode x) {
			int rank = x.left.size + 1;
			RBNode y = x;
			while (y != this.root) {
				if (y == y.parent.right)
					rank += y.parent.left.size + y.parent.count;
 
				y = y.parent;
			}
 
			return rank;
		}
	}
 
    static class FastIO extends PrintWriter {
		private InputStream stream;
		private byte[] buf = new byte[1 << 16];
		private int curChar, numChars;
 
		// standard input
		public FastIO() { this(System.in, System.out); }
		public FastIO(InputStream i, OutputStream o) {
			super(o);
			stream = i;
		}
		// file input
		public FastIO(String i, String o) throws IOException {
			super(new FileWriter(o));
			stream = new FileInputStream(i);
		}
 
		// throws InputMismatchException() if previously detected end of file
		private int nextByte() {
			if (numChars == -1) throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) { throw new InputMismatchException(); }
				if (numChars == -1) return -1;  // end of file
			}
			return buf[curChar++];
		}
 
		// to read in entire lines, replace c <= ' '
		// with a function that checks whether c is a line break
		public String next() {
			int c;
			do { c = nextByte(); } while (c <= ' ');
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = nextByte();
			} while (c > ' ');
			return res.toString();
		}
		public int nextInt() {  // nextLong() would be implemented similarly
			int c;
			do { c = nextByte(); } while (c <= ' ');
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = nextByte();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') throw new InputMismatchException();
				res = 10 * res + c - '0';
				c = nextByte();
			} while (c > ' ');
			return res * sgn;
		}
		public double nextDouble() { return Double.parseDouble(next()); }
	}
 
}
