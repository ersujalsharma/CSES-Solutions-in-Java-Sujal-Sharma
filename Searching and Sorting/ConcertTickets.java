import java.io.*;
import java.util.*;
 
public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] in_var = bufferedReader.readLine().split(" ");
        String[] ticketPrice = bufferedReader.readLine().split(" ");
        String[] canPay = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(in_var[0]);
        int m = Integer.parseInt(in_var[1]);
        int arr[] = new int[n];
        int consumer[] = new int[m];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(ticketPrice[i]);
        }
        for(int i=0;i<consumer.length;i++){
            consumer[i] = Integer.parseInt(canPay[i]);
        }
        System.out.println( solve(arr,consumer) );
    }
    static String solve(int[] ticket,int consumer[]){
        Arrays.sort(ticket);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<consumer.length;i++){
            int j=ticket.length-1;
            while(j>=0 && (ticket[j]>consumer[i] || ticket[j]==0)){
                j--;
            }
            if(j>=0){
                sb.append(ticket[j]+"\n");
                ticket[j] = 0;
            }
            else sb.append(-1+"\n");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }


    /* 
    // navigable approach
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] in_var = bufferedReader.readLine().split(" ");
        String[] ticketPrice = bufferedReader.readLine().split(" ");
        String[] canPay = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(in_var[0]);
        int m = Integer.parseInt(in_var[1]);
        NavigableMap<Integer,Integer> navMap = new TreeMap<>();
        int consumer[] = new int[m];
        for(int i=0;i<n;i++){
            int val = Integer.parseInt(ticketPrice[i]);
            navMap.put(val,navMap.getOrDefault(val,0)+1);
        }
        for(int i=0;i<consumer.length;i++){
            consumer[i] = Integer.parseInt(canPay[i]);
        }
        System.out.println( solve(navMap,consumer) );
    }
    static String solve(NavigableMap<Integer, Integer> navMap,int consumer[]){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<consumer.length;i++){
            Map.Entry<Integer,Integer> mapped = navMap.floorEntry(consumer[i]);
            if(mapped!=null){
                sb.append(mapped.getKey()+"\n");
                if(mapped.getValue()==1) navMap.remove(mapped.getKey());
                else navMap.put(mapped.getKey(), mapped.getValue()-1);
            }
            else sb.append(-1+"\n");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    */
}

// import java.io.*;
// import java.util.*;

// public class Solution {
// 	// public static void main(String[] args) throws IOException {
// 	// 	Reader io = new Reader();
// 	// 	PrintWriter pw = new PrintWriter(System.out);

// 	// 	int ticketNum = io.nextInt();
// 	// 	int peopleNum = io.nextInt();
// 	// 	// No multiset in java so we'll have to use a TreeMap
// 	// 	NavigableMap<Integer, Integer> ticketMultiset = new TreeMap<>();
// 	// 	Map.Entry<Integer, Integer> val;

// 	// 	for (int i = 0; i < ticketNum; i++) {
// 	// 		int priceOfTicket = io.nextInt();
// 	// 		/*
// 	// 		 * If the set already contains the same key value,
// 	// 		 * create another pair next to it
// 	// 		 */
// 	// 		if (ticketMultiset.containsKey(priceOfTicket)) {
// 	// 			ticketMultiset.put(priceOfTicket,
// 	// 			                   ticketMultiset.get(priceOfTicket) + 1);
// 	// 		} else {
// 	// 			ticketMultiset.put(priceOfTicket, 1);
// 	// 		}
// 	// 	}

// 	// 	for (int i = 0; i < peopleNum; i++) {
// 	// 		int customerMaxPrice = io.nextInt();
// 	// 		/*
// 	// 		 * Get the optimal ticket for this customer
// 	// 		 * We add 1 because lowerEntry returns the highest
// 	// 		 * *strictly* lower entry
// 	// 		 */
// 	// 		val = ticketMultiset.lowerEntry(customerMaxPrice + 1);
// 	// 		// If there are no possible prices, we can exit and return -1
// 	// 		if (val != null) {
// 	// 			pw.println(val.getKey());
// 	// 			/*
// 	// 			 * If there's more than one set with the key value,
// 	// 			 * then replace the current set with
// 	// 			 * the next-lowest set with the same key
// 	// 			 */
// 	// 			if (val.getValue() == 1) {
// 	// 				ticketMultiset.remove(val.getKey());

// 	// 			} else {
// 	// 				ticketMultiset.put(val.getKey(), val.getValue() - 1);
// 	// 			}
// 	// 		} else {
// 	// 			pw.println(-1);
// 	// 		}
// 	// 	}
// 	// 	io.close();
// 	// 	pw.close();
// 	// }
// 	// // Kattio is too slow
// 	// // BeginCodeSnip{Fast Reader}
// 	// static class Reader {
// 	// 	final private int BUFFER_SIZE = 1 << 16;
// 	// 	private DataInputStream din;
// 	// 	private byte[] buffer;
// 	// 	private int bufferPointer, bytesRead;

// 	// 	public Reader() {
// 	// 		din = new DataInputStream(System.in);
// 	// 		buffer = new byte[BUFFER_SIZE];
// 	// 		bufferPointer = bytesRead = 0;
// 	// 	}
// 	// 	private void fillBuffer() throws IOException {
// 	// 		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
// 	// 		if (bytesRead == -1) buffer[0] = -1;
// 	// 	}

// 	// 	private byte read() throws IOException {
// 	// 		if (bufferPointer == bytesRead) fillBuffer();
// 	// 		return buffer[bufferPointer++];
// 	// 	}

// 	// 	public void close() throws IOException {
// 	// 		if (din == null) return;
// 	// 		din.close();
// 	// 	}
// 	// 	public int nextInt() throws IOException {
// 	// 		int ret = 0;
// 	// 		byte c = read();
// 	// 		while (c <= ' ') c = read();
// 	// 		boolean neg = (c == '-');
// 	// 		if (neg) c = read();
// 	// 		do {
// 	// 			ret = ret * 10 + c - '0';
// 	// 		} while ((c = read()) >= '0' && c <= '9');

// 	// 		if (neg) return -ret;
// 	// 		return ret;
// 	// 	}
// 	// }
// 	// EndCodeSnip{}
// }