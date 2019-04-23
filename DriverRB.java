class DriverRB{

    public static void main(String agr[]){
        RB obj = new RB(50);
        obj.insert(40);
        obj.insert(30);
        obj.insert(20);
        obj.insert(10);
        obj.insert(60);
        obj.insert(160);
        obj.insert(11);
        obj.insert(49);
        System.out.println("\n\nPreOrder Traversal\n");
        obj.preTraverse(obj.root);
        System.out.print("\n");    
        obj.preTraverseColour(obj.root);
        System.out.println("\n\nInOrder Traversal\n");     
        obj.infixTraverse(obj.root);
        System.out.print("\n");    
        obj.infixTraverseColour(obj.root);
        
        

    }
}