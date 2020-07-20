/* 
 * You run an e-commerce website and want to record the last N order ids in a log. 
 * Implement a data structure to accomplish this, with the following API:
 * 
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 */

public class Day16LogDataStructure {

	private int maxSize;
    private int[] circularBuffer;
    private int currIdx;

    public Day16LogDataStructure(int n) {
        this.maxSize = n;
        this.circularBuffer = new int[n];
        this.currIdx = 0;
    }

    public void record(int orderId) {
        circularBuffer[currIdx] = orderId;
        currIdx = (currIdx + 1) % maxSize;
    }

    public int getLast(int i) {
        return circularBuffer[(currIdx - i + maxSize) % maxSize];
    }

}
