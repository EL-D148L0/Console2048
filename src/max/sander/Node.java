package max.sander;

import java.util.LinkedList;

public class Node {
    Board state;
    Node parent;
    boolean playerTurn;
    double chance;
    LinkedList<Node> children;
    int playerMove;
    Boolean canMove;

    double expectimaxResult;
    public Node(Board state) {
        this.state = state;
        this.playerTurn = true;
    }
    private Node(Board state, Node parent, boolean playerTurn, int playerMove) {
        this.state = state;
        this.parent = parent;
        this.playerTurn = playerTurn;
        this.playerMove = playerMove;
    }
    public void expectimaxSave() {
        expectimaxResult = expectimax();
    }
    private Node(Board state, Node parent, boolean playerTurn, double chance) {
        this.state = state;
        this.parent = parent;
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
        if (out == -10000){
            System.out.println("BOINGSAWDAD");
            System.out.println(this);
            System.out.println(moves().size());
            System.out.println(state.canMove());
            System.out.println(terminal());
            //System.out.println(state);
        }

        return out;
    }
    public LinkedList<Node> moves() {
        if (children == null) {
            children = new LinkedList<>();
            createMoves();
        }
        return children;
    }
    private void createMoves() {
        if (playerTurn) {
            for (int dir : Constants.DIRECTIONS) {
                Board move = state.move(dir);
                if (!move.equals(state)) {
                    Node child = new Node(move, this, false, dir);
                    children.add(child);
                }
            }
        } else {

            LinkedList<BoardPosition> freePositions = state.getFreePositions();
            for (BoardPosition bp :
                    freePositions) {
                bp.setValue(2);
                Node child = new Node(state.setTile(bp), this, true, (1.0/freePositions.size())*Constants.CHANCE_FOR_2);
                children.add(child);
                bp.setValue(4);
                Node child2 = new Node(state.setTile(bp), this, true, (1.0/freePositions.size())*Constants.CHANCE_FOR_4);
                children.add(child2);
            }
        }
    }
    public double utility() {
        if (!lazyGetCanMove()) return -1000;
        return state.score;
    }
    public boolean terminal() {
        return depth() >= Solver.searchDepth || !lazyGetCanMove();
    }
    private boolean lazyGetCanMove() {
        if (canMove == null) {
            canMove = state.canMove();
        }
        return canMove;
    }
    public int depth() {
        if (parent == null) {
            return 0;
        }
        return parent.depth() + 1;
    }
    public void destroy() {
        if (parent != null) {
            parent.children.remove(this);
        }
        children.forEach(child -> {child.parent = null;});
        children.clear();
    }
    public void destroyThisAndAllChildren() {
        parent = null;
        if (children != null) {
            children.forEach(child -> {child.parent = null;});
            children.forEach(Node::destroyThisAndAllChildren);
            children.clear();
        }
    }

}
