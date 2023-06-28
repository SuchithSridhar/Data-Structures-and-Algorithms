public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree<String> A = new BinaryTree<String>();
        BinaryTree<String> B = new BinaryTree<String>();
        BinaryTree<String> C = new BinaryTree<String>();
        BinaryTree<String> D = new BinaryTree<String>();
        BinaryTree<String> E = new BinaryTree<String>();
        BinaryTree<String> F = new BinaryTree<String>();
        
        A.makeRoot("A");
        B.makeRoot("B");
        C.makeRoot("C");
        D.makeRoot("D");
        E.makeRoot("E");
        F.makeRoot("F");

        /*
         *        A
         *       / \
         *      B   C
         *     / \
         *    D   E
         *   /
         *  F
         */
        
        A.setLeft(B);
        A.setRight(C);
        B.setLeft(D);
        B.setRight(E);
        D.setLeft(F);
        
        System.out.print("Preorder:\t");
        A.preOrder();
        System.out.println();

        System.out.print("Inorder:\t");
        A.inOrder();
        System.out.println();

        System.out.print("Postorder:\t");
        A.postOrder();
        System.out.println();

        System.out.print("Levelorder:\t");
        A.levelOrder();
        System.out.println();
    }
}

