public class Main {
    public static void main(String[] args){
        Tree<Integer> tree = new Tree<Integer>();
        int[] numbers = {50,20,60,66,2,8,88,81,93};
        for(int i:numbers) 
            tree.insertNode(i);

        // It must print array in ascending
        // 2 8 20 50 60 66 81 88 93
        tree.inOrder();
        System.out.println();

        tree.deleteNode(60);

        tree.inOrder();
        System.out.println();

        
        System.out.println(tree.search(88));

        System.out.println(tree.search(60));
    }
}
