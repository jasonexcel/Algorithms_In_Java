package basicAlgorithms;

public class HanoiTower {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =3;
		moveDisks(3, "tower A", "tower B", "tower C");
	}
	
	public static void moveDisks(int n, String from, String to, String buffer) {
		if(n > 0){
			moveDisks(n-1, from, buffer, to);
			System.out.println("move top disk from " + from + " to " + to);
			moveDisks(n-1, buffer, to, from);
		}
	}

}
