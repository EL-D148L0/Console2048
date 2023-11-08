package max.sander;

import java.security.PublicKey;
import java.util.LinkedList;

public class Solver {
    public static int searchDepth = 6;
    Node start;
    public Solver(Board board) {
        int freeSpace = board.countFreeTiles();
        if (freeSpace < 3) {
            searchDepth = 9;
        } else if (freeSpace < 6) {
            searchDepth = 7;
        } else if (freeSpace < 12) {
            searchDepth = 6;
        } else {
            searchDepth = 4;
        }
        start = new Node(board);
    }
    public int next() {
        int out = Constants.DIR_NONE;
        double weight = -10000;
        LinkedList<Thread> threadList = new LinkedList<>();
        class ComputeTask implements Runnable {
            private Node node;
            public ComputeTask (Node node) {
                this.node = node;
            }

            @Override
            public void run() {
                node.expectimaxSave();
            }
        }
        for (Node node :
                start.moves()) {
            threadList.add(new Thread(new ComputeTask(node)));

        }
        threadList.forEach(Thread::start);
        try {
        for (Thread thread : threadList) {
                thread.join();
        }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Node node :
                start.moves()) {
            if (weight < node.expectimaxResult) {
                weight =  node.expectimaxResult;
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
