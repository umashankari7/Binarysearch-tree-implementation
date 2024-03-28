import java.util.*;

class Tree{
  int data;
  Tree left;
  Tree right;
  Tree(int data){
    this.data=data;
  }
}
  class Btree{
    Tree root;
    
    int sizeouter(){
      return(size(root));
    }
    int size(Tree node){
      if(node==null){
        return 0;
      }
      return size(node.left)+size(node.right)+1;
    }
    int heightouter(){
      return(height(root));
    }
    int height(Tree node){
      if(node==null){
        return-1;
      }
      return Math.max(height(node.left),height(node.right))+1;
    }
    void addouter(int data){
      root=add(root,data);
    }
   Tree add(Tree node,int data){
    if(node==null){
      return new Tree(data);
    }
    if(data>node.data){
      node.right=add(node.right,data);
    }
    if(data<node.data){
      node.left=add(node.left,data);
    }
    return node;
   }
   Tree delete(Tree node,int data){
   if(node==null){
    return node;
   }
   if(node.data>data){
    node.left=delete(node.left,data);
    return node;
   }
   if(node.data<data){
    node.right=delete(node.right,data);
    return node;
   }
   if(node.left==null){
    return node.right;
   }
   if(node.right==null){
    return node.left;
   }
    node.data= minimumfind(node.right);
    node.right=delete(node.right, node.data);
    return node;
   }
    int minimumfind(Tree node){
      if(node==null){
        return -1;
      }
      while(node.left!=null){
        node=node.left;
      }
      return node.data;
    }
   Tree lca(Tree root, int p,int q){
     if(p>root.data&&q>root.data){
      return lca(root.right,p,q);
     }
     else if(p<root.data&&q<root.data){
      return lca(root.left,p,q);
     }
     else{
      return root;
     }
    }
    void deleteleafOuter(){
      root= removeLeafNodes(root);
    }
    public Tree removeLeafNodes(Tree root) {
      if (root == null) {
          return null;
      }
      if (root.left == null && root.right == null) {
          return null;
      }
      root.left = removeLeafNodes(root.left);
      root.right = removeLeafNodes(root.right);
      return root;
  }
  int shortdistouter(){
    return shortdist(root, 10, 17);
  }
  int shortdist(Tree node,int a,int b){
    if(node==null){
      return 0;
    }
    Tree res=lca(node,a,b);
    return distance(res,a)+distance(res, b);
  }
  int distance(Tree node,int a){
    if(node.data==a||node==null){
      return 0;
    }
    if(node.data>a){
      return 1+distance(node.left,a);
    }
     return 1+distance(node.right, a);
  }
   void display(){
    inorder(root);
    System.out.println(" ");
    preorder(root);
    System.out.println(" ");
    postorder(root);
    System.out.println(" ");
    levelorder(root);
    System.out.println(" ");
   }
   void inorder(Tree node){  //DFS
    if(node!=null){
      inorder(node.left);
      System.out.print(node.data+" ");
      inorder(node.right);
    }
   }
   void preorder(Tree node){
    if(node!=null){
      System.out.print(node.data+" ");
       preorder(node.left);
      preorder(node.right);
    }
    }
    void postorder(Tree node){
      if(node!=null){
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
      }
   }
     
   void levelorder(Tree node){  // BFS
    if(node==null){
      return;
    }
    Queue <Tree>q=new LinkedList<>();//upcast
     q.add(node);
     while(!q.isEmpty()){
      Tree n=q.remove();
      System.out.print(n.data+" ");
      if(n.left!=null){
        q.add(n.left);
      }
      if(n.right!=null){
        q.add(n.right);
      }
     }
   }
   boolean searchouter(int data){
    return search(root,data);
   }
    boolean search(Tree node,int data){
     if(node==null){
      return false;
     }
     if(node.data==data){
      return true;
     }
     return(data>node.data)?search(node.right,data):search(node.left,data);
    }
    void deleteouter(int data){
      root=delete(root, data);
    }
  }
public class Binarysearchtree {
  public static void main(String[] args) {
    Btree b=new Btree();
    b.addouter(1);
    b.addouter(2);
    b.addouter(3);
    b.addouter(4);
    b.addouter(5);
   // b.addouter(15);
   // b.addouter(12);
   // b.addouter(3);
    //b.deleteouter(11);
    b.display();
    System.out.println(b.searchouter(3));
    System.out.println(b.searchouter(7));
    System.out.println(b.sizeouter());
    System.out.println(b.heightouter());
   int p=11;
   int q=17;
   Tree t=b.lca(b.root,p,q);
   System.out.println("LCA of"+ p+ "and"+q+"is:"+t.data);
  // b.deleteleafOuter();
   //b.display();
   b.shortdistouter();
   b.display();


    
  }
}
