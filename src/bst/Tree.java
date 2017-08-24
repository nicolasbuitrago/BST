/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author nicolasbuitrago
 */
public class Tree
{
    Node root;
    
    public Tree(){
    }
    
    public void insert(Node root, int newKey){
        if (root==null){
            this.root = new Node(newKey);
        }else{
            if(newKey<root.getKey()){
                if (root.left != null){
                    insert(root.left,newKey);
                }else{
                    root.setLeft(new Node(newKey));
                }
            }
            if (newKey>root.getKey()){
                if (root.right != null){
                    insert(root.right,newKey);
                }else{
                    root.setRight(new Node(newKey));
                }
            }
            if(newKey==root.getKey()){
                System.out.println("El nodo ya existe.");
            }
        }
    }
    
    public void orderLevel(Node root){
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {            
            Node temp = queue.poll();
            System.out.print(temp.key+"  ");
            if (temp.left!=null) {
                queue.add(temp.left);
            }
            if (temp.right!=null) {
                queue.add(temp.right);
            }
        }
    }
    
    
    
}
