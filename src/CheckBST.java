import java.util.*;

public class CheckBST {

    List<Node> treeElement = new ArrayList();
    boolean flag = false;

    public boolean checkBST(Node root,Integer data,String dir) {
        if(!flag){
            flag = true;
            if(findDuplicates(root)) return false;
        }
        if(root == null) return true;
        if(root.left != null && root.right != null)
            if(root.data > root.left.data && root.data <= root.right.data){
                if(data!=null && root.left.data < data && root.right.data > data) return false;
                checkBST(root.left,root.data,"left");
                checkBST(root.right,root.data,"right");
                return true;
            } else return false;
        else if(root.right != null && root.left == null)
            return (root.right.data >= root.data && root.right.data > data) ? checkBST(root.right,root.data,"right") : false;
        else if(root.left != null && root.right == null)
            return (root.left.data < root.data && root.left.data < data) ? checkBST(root.left,root.data,"left") : false;
        else
            return true;
    }
    public static void main(String[] args) {
        //System.out.println("before");
        Node node = new Node(3);
        node.left = new Node(2);
        node.right = new Node(6);
        node.left.left = new Node(1);
        node.left.right = new Node(4);
        node.right.left = new Node(5);
        node.right.right = new Node(7);
        //node.right.right.right.right = new Node(10);
        CheckBST checkBST = new CheckBST();
        System.out.println(checkBST.checkBST(node,null,null));
    }

    public void traverseTree(Node root){
        if(root != null){
            traverseTree(root.left);
            this.treeElement.add(root);
            traverseTree(root.right);
        }
    }

    public boolean findDuplicates(Node root){
        traverseTree(root);
        Set<Integer> set = new HashSet<Integer>();
        for(Node element : this.treeElement)
            if (!set.add(element.data))
                return true;
        return false;
    }
}

class Node {
    int data=0;
    Node left = null;
    Node right = null;
    public Node(int data){
        this.data = data;
    }
}
