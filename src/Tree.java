public class Tree<T> {
    Node<T> root;


    public Node<T> insertNode(T data) {
        Node<T> node = new Node<T>(data);

        // If root is null
        if(root == null){
            root = node;
            return node;
        }else if(root.data){
// How to compare generic type
        }
         

    }

}
