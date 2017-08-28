/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import java.util.Scanner;

/**
 *
 * @author nicolasbuitrago
 */
public class BST
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Tree tree = new Tree();
        testPrueba(tree);
        System.out.println("Recorrido por niveles: ");
        tree.orderLevel(tree.root);
//        System.out.println("\nRecorrido inroder: ");
//        tree.inOrder(tree.root);
        System.out.println("");
        removeNode(tree);
        System.out.println("");
        System.out.println("Recorrido por niveles: ");
        tree.orderLevel(tree.root);
    }
    
    public static void insertNodes(Tree tree){
        Scanner leer = new Scanner(System.in);
            while (true){                
                System.out.print("Digite el nodo a insertar: ");
                int newKey = leer.nextInt();
                if (newKey == -1){
                    break;
                }
                tree.insert(tree.root, newKey);
            }
    }
    
    public static void removeNode(Tree tree){
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite el nodo que desea eliminar: ");
        int key = leer.nextInt();
        tree.remove(tree.root,null, key);
    }
    
    public static void testPrueba(Tree tree){
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 12);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 15);
        tree.insert(tree.root, 25);
        tree.insert(tree.root, 35);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 14);
        tree.insert(tree.root, 22);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 13);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 36);
        tree.insert(tree.root, 37);
        tree.insert(tree.root, 38);
    }
}
