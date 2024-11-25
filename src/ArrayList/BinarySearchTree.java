package ArrayList;

public class BinarySearchTree {

    Node root;

    public void insert(Node node) {
        root = insertHelper(root,node);
    }
    private Node insertHelper(Node root,Node node){
        int data = node.data;

        if(root == null){
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left,node);
        }else{
            root.right = insertHelper(root.right,node);
        }

        return root;
    }
    public void display() {
        displayHelper(root);
    }
    private void displayHelper(Node root) {
        if(root != null){
            displayHelper(root.left);
            System.out.print(root.data + " ");
            displayHelper(root.right);

        }
    }
    public boolean search(int data) {
        return searchHelper(root,data);
    }
    private boolean searchHelper(Node root,int data) {
        if(root == null){
            return false;
        }else if(data == root.data){
            return true;
        }else if(data < root.data){
            return searchHelper(root.left,data);
        }else{
            return searchHelper(root.right,data);
        }
    }
    public void remove(int data) {
        if(search(data)){
            System.out.println(data + " is removed");
            removeHelper(root,data);
        }else{
            System.out.println(data + " not found");
        }
    }
    private Node removeHelper(Node root,int data) {
        if (root == null) {
            return root;
        } else if (data < root.data) {
            root.left = removeHelper(root.left,data);
        }else if( data > root.data){
            root.right = removeHelper(root.right,data);
        }else{
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.right != null){
                root.data = successor(root);
                root.right = removeHelper(root.right , root.data);

            }else{
                root.data = predecessor(root);
                root.left = removeHelper(root.left,root.data);
            }
        }
        return root;
    }
    private int successor(Node root) {
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
    private int predecessor(Node root) {
        root = root.left;
        while (root.right != null){
            root = root.right;
        }

        return root.data;
    }

}
