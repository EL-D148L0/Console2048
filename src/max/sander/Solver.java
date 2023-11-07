package max.sander;

import java.security.PublicKey;
import java.util.LinkedList;

public class Solver {
    public static int searchDepth = 6;
    Node start;
    public Solver(Board board) {
        start = new Node(board);
    }
    public int next() {
        int out = Constants.DIR_NONE;
        double weight = -10000;
        LinkedList<Thread> ThreadList = new LinkedList<>();
        for (Node node :
                start.moves()) {
            double expectimax = node.expectimax();
            if (weight < expectimax) {
                weight = expectimax;
                out = node.playerMove;
            }

        }
        return out;
    }
    public void destroyTree() {
        start.destroyThisAndAllChildren();
        start = null;
    }

}
