import java.util.*;

public class FindRoad {
    cTree tree;
    List<nodedata> nd;
    int[][] table;
    int ret1Index;
    int ret2Index;
    int[][] answer;

    public int[][] solution(int[][] nodeinfo) {
        nd = new ArrayList<>();
        table = nodeinfo;
        ret1Index = ret2Index = 0;
        answer = new int[2][nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            nd.add(new nodedata(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(nd, (nodedata o1, nodedata o2) -> {
            if (o1.y == o2.y)
                return o1.x - o2.x;
            return o2.y - o1.y;
        });


        tree = new cTree(nd.get(0));

        for (int i = 1; i < nodeinfo.length; i++) {
            find(tree, i);
        }

        preorder(tree);
        postorder(tree);

        return answer;
    }

    public void find(cTree tree, int index) {
        cTree temp = tree;
        while (true) {
            if (temp.data.x < nd.get(index).x) {
                if (temp.right == null) {
                    temp.right = new cTree(nd.get(index));
                    break;
                }
                temp = temp.right;
            } else {
                if (temp.left == null) {
                    temp.left = new cTree(nd.get(index));
                    break;
                }
                temp = temp.left;
            }
        }
    }

    public void preorder(cTree tree) {
        if (tree == null)
            return;

        answer[0][ret1Index++] = tree.data.value;
        preorder(tree.left);
        preorder(tree.right);
    }

    public void postorder(cTree tree) {
        if (tree == null)
            return;

        postorder(tree.left);
        postorder(tree.right);
        answer[1][ret2Index++] = tree.data.value;
    }
}

class nodedata  {
    int x;
    int y;
    int value;

    public nodedata(int value, int x, int y) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

class cTree {
    cTree left;
    cTree right;

    nodedata data;

    public cTree(nodedata data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
