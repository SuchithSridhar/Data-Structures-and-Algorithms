class BinaryTreeNode:
    left = None
    right = None

    def __init__(self, data) -> None:
        self.data = data

class BinaryTree:
    root = None
    height = -1

    def __init__(self) -> None:
        self.root = None

    def add_node(self, node: BinaryTreeNode) -> None:
        if self.root is None:
            self.root = node
            self.height = 0
            return
        
        cur_root = self.root
        cur_side = 0 # 0 is left and 1 is right
        for i in range()
