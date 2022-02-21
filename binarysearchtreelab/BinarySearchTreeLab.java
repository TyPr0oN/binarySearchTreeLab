package binarysearchtreelab;
/* Thanyapoj Trikasemsak
 * 62130500214
 */
public class BinarySearchTreeLab {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(25); tree.insert(100); tree.insert(35); tree.insert(35);
        tree.insert(93); tree.insert(11); tree.insert(99); tree.insert(65);
        System.out.println(tree.root.right.left.right.right.info);
        System.out.println(tree.root.left.info);
        tree.insert(24); tree.insert(20); tree.insert(15); tree.insert(10);
        tree.search(93); tree.search(110); tree.search(35);
        tree.insert(200);
        System.out.println(tree.root.right.right.info);
        System.out.print("Inorder: "); tree.inorderTraversalRecursion(tree.root);
        System.out.print("\nPreorder: ");tree.preorderTraversalRecursion(tree.root);
        System.out.print("\nPostorder: ");tree.postorderTraversalRecursion(tree.root);
        System.out.print("\nbreadth-first Traversal: ");tree.breadthFirstTraversal();
        System.out.print("\npreorder depth-first Traversal w/o recursion: ");tree.perorderTraversal();System.out.println();
        tree.perorderTraversal();
        System.out.println("\nbefore delete 100: "+tree.root.right.info);tree.deleteByMerging(100);
        System.out.println("after delete 100: "+tree.root.right.info);
        System.out.println(tree.root.right.right.right.right.right.info);
    }
}
