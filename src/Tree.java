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
    
    public void deleteNode(T value){
        root = deleteHelper(root,value);
    }

    private Node<T> deleteHelper(Node<T> root,T value){


        if(root.data.equals(value)){
            
            // Node with no child
            if(root.left == null && root.right == null){
                return null;
            }
    
            // Node with one child
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
    
            /*
            * Node with two child
            * Replace node with inOrder successor 
            * 
            *  Which left most node in right sub tree
            *  
            */
    
            
            // Step 1 : replace in order successor
            Node<T> node = leftMostNode(root.right);
    
    
            // Step 2: Delete that node from the tree
            deleteNode(node.data);

            // Step 3 : replace root with node
            root.data = node.data;
        } else if(root.data.compareTo(value) > 0){
            root.left = deleteHelper(root.left, value);
        } else if(root.data.compareTo(value) < 0){
            root.right = deleteHelper(root.right, value);
        }
        return root;
    }


    private Node<T> leftMostNode(Node<T> node) {
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public boolean search(T value){
        return searchHelper(root,value);
    }


    private boolean searchHelper(Node<T> root, T value) {
        if(root == null) return false;

        // Data is lesser than root search in left subtree
        if( root.data.compareTo(value)  > 0 ){
            return searchHelper(root.left, value);
        }


        // Data is greater than root value search in right subtree
        if(root.data.compareTo(value) < 0){
            return searchHelper(root.right,value);
        }

        return true;
    }
}
