package max.sander;

import java.util.LinkedList;

public class Node {
    Board state;
    int depth;
    boolean playerTurn;
    double chance;

    int playerMove;
    Boolean canMove;

    double expectimaxResult;
    public Node(Board state) {
        this.state = state;
        this.playerTurn = true;
        depth = 1;
    }
    private Node(Board state, int depth, boolean playerTurn, int playerMove) {
        this.state = state;
        this.depth = depth;
        this.playerTurn = playerTurn;
        this.playerMove = playerMove;
    }
    public void expectimaxSave() {
        expectimaxResult = expectimax();
    }
    private Node(Board state, int depth, boolean playerTurn, double chance) {
        this.state = state;
        this.depth = depth;
        this.playerTurn = playerTurn;
        this.chance = chance;
    }


    public double expectimax() {
        if (terminal()) return utility();
        if (playerTurn) return expectimaxPlayer();
        else return expectimaxRandom();
    }
    private double expectimaxRandom() {
        double out = 0;
        for (Node child :
                moves()) {
            out += child.chance * child.expectimax();
        }
        return out;
    }
    private double expectimaxPlayer() {
        double out = -10000;
        for (Node child :
                moves()) {
            out = Math.max(out, child.expectimax());


        }

        return out;
    }
    public LinkedList<Node> moves() {
        return createMoves();
    }
    private LinkedList<Node> createMoves() {
        LinkedList<Node> children = new LinkedList<>();
        if (playerTurn) {
            for (int dir : Constants.DIRECTIONS) {
                Board move = state.move(dir);
                if (!move.equals(state)) {
                    Node child = new Node(move, depth+1, false, dir);
                    children.add(child);
                }
            }
        } else {

            LinkedList<BoardPosition> freePositions = state.getFreePositions();
            for (BoardPosition bp :
                    freePositions) {
                bp.setValue(2);
                Node child = new Node(state.setTile(bp), depth+1, true, (1.0/freePositions.size())*Constants.CHANCE_FOR_2);
                children.add(child);
                bp.setValue(4);
                Node child2 = new Node(state.setTile(bp), depth+1, true, (1.0/freePositions.size())*Constants.CHANCE_FOR_4);
                children.add(child2);
            }
        }
        return children;
    }
    public double utility() {
        if (!lazyGetCanMove()) return -1000;
        return state.score;
    }
    public boolean terminal() {
        return depth >= Solver.searchDepth || !lazyGetCanMove();
    }
    private boolean lazyGetCanMove() {
        if (canMove == null) {
            canMove = state.canMove();
        }
        return canMove;
    }

}
