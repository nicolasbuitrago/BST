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
        insertNodes(tree);
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
    
}
