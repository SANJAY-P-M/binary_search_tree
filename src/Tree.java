public class Tree<T extends Comparable<T>> {
    Node<T> root;


    public void insertNode(T data) {
        root = insertHelper(root,data);
    }


    private Node<T> insertHelper(Node<T> root,T data){
        if(root == null){
            root = new Node<T>(data);
        }
        else if(root.data.compareTo(data) < 0){
            // data is greater that root data insert
            root.right = insertHelper(root.right, data);
        }
        else if(root.data.compareTo(data) > 0){
            // data is lesser than root insert in left subtree
            root.left = insertHelper(root.left, data);
        }
        return root;
    }


    public void inOrder(){
        inOrderHelper(root);    
    }

    private void inOrderHelper(Node<T> root){
        if (root == null) {
            return;
        }
        inOrderHelper(root.left);
        System.out.print(root.data+" ");
        inOrderHelper(root.right);
    }
    
}
