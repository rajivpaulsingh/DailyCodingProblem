/*
 * Given a array of numbers representing the stock prices of a company in chronological order, 
 * write a function that calculates the maximum profit you could have made from buying and selling that stock once. 
 * You must buy before you can sell it.
 * 
 * For example, given [9, 11, 8, 5, 7, 10], 
 * you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.
 */
public class Day47BuyStocks {

	public static void main(String[] args) {
		
		int arr[] = {9, 11, 8, 5, 7, 10};
		
		System.out.println("Maximum profist is: " + maxProfit(arr));

	}
	
	private static int maxProfit(int arr[]) {
		
		int n = arr.length;
		if(n < 1) {
			return 0;
		}
		
		int minPrice = arr[0];
		int maxProfit = arr[1] - arr[0];
		for(int i = 1; i < n; i++) {
			int current = arr[i];
			int potentialProfit = current - minPrice;
			
			maxProfit = Math.max(maxProfit, potentialProfit);
			minPrice = Math.min(minPrice, current);
		}
		return maxProfit;
	}

}
