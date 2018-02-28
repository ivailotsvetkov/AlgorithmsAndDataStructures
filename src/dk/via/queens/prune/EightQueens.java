package dk.via.queens.prune;

public class EightQueens {
	private static boolean collides(QueenPositions p, int i, int j) {
		int p_i = p.getPosition(i);
		int p_j = p.getPosition(j);
		return p_i == p_j || Math.abs(i - j) == Math.abs(p_i - p_j);
	}
	
	private static boolean hasCollisions(QueenPositions p) {
		for(int i = 0; i < p.getSize(); i++) {
			for(int j = i + 1; j < p.getSize(); j++) {
				if (collides(p, i, j)) return true;
			}
		}
		return false;
	}
	
	private static String eightQueens(int size) {
		QueenPositions p = new QueenPositions(0, size);
		return String.valueOf(queens(p, size));
	}

	private static QueenPositions queens(QueenPositions p, int targetSize) {
		if (hasCollisions(p)) return null;
		if (p.getSize() == targetSize) return p;
		QueenPositions ext = p.extend();
		while(ext.hasMore()) {
			QueenPositions solution = queens(ext, targetSize);
			if (solution != null) 
				return solution;
			ext.next();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(eightQueens(20));
	}
}
