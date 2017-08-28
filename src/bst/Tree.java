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
    
    public void preOrder(Node root){
        if (root!=null) {
            System.out.print(root.getKey());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    
    public void inOrder(Node root){
        if (root!=null) {
            inOrder(root.getLeft());
            System.out.print(Integer.toString(root.getKey())+"  ");
            inOrder(root.getRight());
        }
    }
    
    public void postOrder(Node root){
        if (root!=null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getKey());
        }
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
    
    //El mio
    public void removeN(Node root, int key){
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {            
            Node temp = queue.poll();
            
            if (temp.left!=null) {
//                if(temp.left.right)
            }
            if (temp.right!=null) {
                queue.add(temp.right);
            }
        }
    }
    
    public void buscar(int key, Node p, Node pad,boolean sw){
        if (p!=null && sw){
            if (p.key<key){
                buscar(key,p.right,p,sw);
            }else if(p.key>key){
                buscar(key,p.left,p,sw);
            }else{
                sw = false;
            }
        }
    }
    
    public void menorDeMayores(Node root) {//Funciona bien
        Node father = null;
        Node node = root.right;
        while (node.left != null) {
            father = node;
            node = node.left;
        }
        if(father!=null) father.setLeft(null);
        else{root.setRight(node.getRight());}
        root.setKey(node.getKey()); 
    }

    public void mayorDeMenores(Node root) {
        Node father = null;
        Node node = root.left;
        while (node.right != null) {
            father = node;
            node = node.right;
        } 
        if(father!=null) father.setRight(null);
        else{root.setLeft(node.getLeft());}
        root.setKey(node.getKey()); 
    }
    
//    public void delete(Node node){
//        if (node.left == null && node.right != null) {
//            menorDeMayores(node);
//        }
//        if (node.right == null && node.left != null) {
//            mayorDeMenores(node);
//        }
//        if (node.right != null && node.left != null) {
//            menorDeMayores(node);
//        }
//        if (node.right == null && node.left == null) {
//            node = null;
//        }
//    }

    public void remove(Node root, Node father, int key) {
        if (root.getKey() != key) {
            if (key < root.getKey()) {
                remove(root.left, root, key);
            }else{
                remove(root.right, root, key);
            }
        } else {
            if (root.left == null && root.right != null) {
                menorDeMayores(root);
            }
            if (root.right == null && root.left != null) {
                mayorDeMenores(root); //Funciona Perfecto
            }
            if (root.right != null && root.left != null) {
                menorDeMayores(root);
            }
            if (root.right == null && root.left == null) {
                if(father.left.key == root.key) father.setLeft(null);
                else father.setRight(null);
            }
        }
    }
    
    //El de la profe
    public void remove(Node root,int key, int opc){
        Node p = root,pad = null,ant,t;
        buscar(key,p,pad,true);
        if (p!=null){
            if(p.left==null && p.right == null){
                if(pad == null){
                    this.root = null;
                }else{
                    if(pad.left == p)
                        pad.left=null;
                    else
                        pad.right = null;
                }
            }else{
                if(p.left!=null && p.right!=null){
                    ant = p;
                    t = p.left;
                    while(t.right!=null){
                        ant = t;
                        t = t.right;
                    }
                    p.key = t.key;
                    if(ant.key == p.key){
                        ant.left = t.left;
                    }else{
                        ant.right = t.left;
                    }
                    p = t;
                    p.left = null;
                }else{
                    if(p.left != null){
                        if(pad == null){
                            root = p.left;
                        }else{
                            if(pad.right.equals(p)){
                                pad.right = p.left;
                            }else{
                                pad.left = p.left;
                            }
                        }
                        p.left = null;
                    }else{
                        if(pad == null){
                            root = p.right;
                        }else{
                            if(p.right.equals(p)){
                                pad.right = p.right;
                            }else{
                                pad.left = p.right;
                            }
                        }
                        p.right = null;
                    }
                }
                p = null;
            }
            System.out.println("Nodo eliminado.");
        }
    }
}
