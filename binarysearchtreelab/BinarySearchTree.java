package binarysearchtreelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    Node root;
    public BinarySearchTree() {
        root=null;
    }
    public void deleteByMerging(int deletedValue){
        Node p = root, prev=null;
        while (p!=null && p.info!=deletedValue){
            prev = p;
            if(deletedValue >= p.info){
                p = p.right;
            }else {
                p=p.left;
            }
        }
        Node nodeForPrevToPointTo=p;
        if (p != null&&p.info == deletedValue) {
            if (p.right == null){
                nodeForPrevToPointTo = p.left;
            }else if(p.left == null){
                nodeForPrevToPointTo = p.right;
            }else {
                Node temp = nodeForPrevToPointTo.left;
                while (temp.right!=null){
                    temp = temp.right;
                }
                temp.right = p.right;
                nodeForPrevToPointTo = p.left;
            }
            if (p == root) {
                root = nodeForPrevToPointTo;
            }else if (p == prev.left){
                prev.left = nodeForPrevToPointTo;
            }else {
                prev.right = nodeForPrevToPointTo;
            }
        }
    }

    public void inorderTraversalRecursion(Node p) {
        if (p != null) {
            inorderTraversalRecursion(p.left);
            System.out.print(p.info+" ");
            inorderTraversalRecursion(p.right);
        }
    }
    public void preorderTraversalRecursion(Node p) {
        if (p != null) {
            System.out.print(p.info+" ");
            preorderTraversalRecursion(p.left);
            preorderTraversalRecursion(p.right);
        }
    }
    public void postorderTraversalRecursion(Node p) {
        if (p != null) {
            postorderTraversalRecursion(p.left);
            postorderTraversalRecursion(p.right);
            System.out.print(p.info+" ");
        }
    }
    public void breadthFirstTraversal(){
        Node p = root;
        Queue<Node> q = new LinkedList<>();
        if (p != null) {
            q.add(p);
            while (!q.isEmpty()){
                p = q.remove();
                System.out.print(p.info+" ");
                if (p.left!=null){
                    q.add(p.left);
                }if (p.right!=null){
                    q.add(p.right);
                }
            }
        }

    }
    public void perorderTraversal(){
        Node p= root;
        Stack<Node> stack = new Stack<>();
        if (p!=null){
            stack.push(p);
            while (!stack.isEmpty()){
                p = stack.pop();
                System.out.print(p.info+" ");
                if (p.right!=null){ stack.push(p.right); }
                if (p.left!=null){ stack.push(p.left); }
            }
        }
    }
    public void insert(int newInfo){
        if (root == null){
            root = new Node(newInfo);
            return;
        }
        Node p = root;
        while (p!=null){
            if (newInfo<p.info){
                if (p.left != null) {
                    p=p.left;
                }else {
                    p.left = new Node(newInfo); return;
                }
            }else {
                if (p.right != null){
                    p=p.right;
                }else {
                    p.right = new Node(newInfo);return;
                }
            }
        }
    }
    public Node search(int el){
        Node p = root;
        while (p!=null){
            if (el == p.info) {
                System.out.println(" We Found That ");
                return p;
            }else if (el < p.info){
                p = p.left;
            }else {
                p = p.right;
            }
        }
        System.out.println("c4NnOt F1nD "+el);
        return null;
    }
}
