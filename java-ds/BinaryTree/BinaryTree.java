public class BinaryTree<T> {
    private T data; 
    private BinaryTree<T> parent; 
    private BinaryTree<T> left; 
    private BinaryTree<T> right; 

    public BinaryTree() { 
        parent = left = right = null; 
        data = null; 
    } 

    public boolean isEmpty() { 
        return data == null; 
    } 

    public void clear() { 
        left = right = parent = null; 
        data = null; 
    } 

    public void makeRoot(T data) { 
        if (!isEmpty()) { 
            System.out.println("Can't make root. Already exists"); 
        } else {
            this.data = data; 
        }
    } 

    public void setData(T data) { 
        this.data = data; 
    } 

    public void setLeft(BinaryTree<T> tree) { 
        left = tree; 
    } 

    public void setRight(BinaryTree<T> tree) { 
        right = tree; 
    } 

    public void setParent(BinaryTree<T> tree) { 
        parent = tree; 
    } 

    public T getData() { 
        return data; 
    } 

    public BinaryTree<T> getLeft() { 
        return left; 
    } 

    public BinaryTree<T> getRight() { 
        return right; 
    } 

    public BinaryTree<T> getParent() { 
        return parent; 
    } 

    public BinaryTree<T> root() {
        BinaryTree<T> currentNode = this;

        while (currentNode.getParent() != null) {
            currentNode = currentNode.getParent();
        }

        return currentNode;
    }

    public void preOrder() {
        System.out.print(this.getData() + " "); // visit the node

        if(this.getLeft() != null) { // traverse the left subtree
            this.getLeft().preOrder();
        }

        if(this.getRight() != null) { // traverse the right subtree
            this.getRight().preOrder();
        }
    }

    public void inOrder() {
        if(this.getLeft() != null) { // traverse the left subtree
            this.getLeft().inOrder();
        }

        System.out.print(this.getData() + " "); // visit the node

        if(this.getRight() != null) { // traverse the right subtree
            this.getRight().inOrder();
        }
    }

    public void postOrder() {
        if(this.getLeft() != null) { // traverse the left subtree
            this.getLeft().postOrder();
        }

        if(this.getRight() != null) { // traverse the right subtree
            this.getRight().postOrder();
        }

        System.out.print(this.getData() + " "); // visit the node
    }
}

