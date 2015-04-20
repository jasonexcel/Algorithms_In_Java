package basicAlgorithms;

import java.util.Random;

public class RandomShuffle {

	public RandomShuffle() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomShuffle rs = new RandomShuffle();
		int[] cards = {1, 2, 3, 4, 5, 6};
		rs.randomShuffle(cards);
		for(int elem : cards) {
			System.out.print(elem + ", ");
		}
	}
	public void randomShuffle(int[] cards) {
		if(cards == null) {
			return;
		}
		Random random = new Random();
		int len = cards.length;
		// from index len-1 to 1, don't consider last element at index 0
		for(int i=len-1; i>=1; i--) {
			// random Integer from [0, i - 1]
			int randomIdx = random.nextInt(i);
			//swap the cards[randomIdx] with cards[lastUnstuck]
			int temp = cards[i];
			cards[i] = cards[randomIdx];
			cards[randomIdx] = temp;			
		}
		return;
	}

}
