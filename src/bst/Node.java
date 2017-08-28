/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author nicolasbuitrago
 */
public class Node
{
    int key;
    Node left;
    Node right;

    public Node(int key)
    {
        this.key = key;
    }

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
    }

    public Node getLeft()
    {
        return left;
    }

    public void setLeft(Node left)
    {
        this.left = left;
    }

    public Node getRight()
    {
        return right;
    }

    public void setRight(Node right)
    {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Nod.key = " + key + "\n node.left = "+this.left.key+"\n node.right = "+this.right.key;
    }
     
}
