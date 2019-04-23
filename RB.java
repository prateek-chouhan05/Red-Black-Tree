public class RB {
    NodeRB root;

    RB(int val) {
        root = new NodeRB(val);
        root.colour = false;
    }

    void insert(int val) {
        root = Insertelement(root, val);
        root.colour = false;
        // Fixup(root, val);
    }

    NodeRB Insertelement(NodeRB rt, int a) {
        if (rt == null) {
            rt = new NodeRB(a);
        } else if (rt.val < a) {
            rt.right = Insertelement(rt.right, a);
            if (rt.right.left != null) { // case of right left
                if (rt.right.left.colour == true && rt.right.colour == true) {
                    if (rt.left != null && rt.left.colour == true) {
                        rt.colour = true;
                        rt.left.colour = false;
                        rt.right.colour = false;
                    } else {
                        rt = rightleftrotation(rt);
                    }
                }
            } else if (rt.right.right != null) {
                if (rt.right.right.colour == true && rt.right.colour == true) {
                    if (rt.left != null && rt.left.colour == true) {
                        rt.colour = true;
                        rt.left.colour = false;
                        rt.right.colour = false;
                    } else {
                        rt = leftleftrotation(rt);
                    }
                }
            }

        } else if (rt.val > a) {
            rt.left = Insertelement(rt.left, a);
            if (rt.left.left != null) { // case of right left
                if (rt.left.left.colour == true && rt.left.colour == true) {
                    if (rt.right != null && rt.right.colour == true) {
                        rt.colour = true;
                        rt.right.colour = false;
                        rt.left.colour = false;
                    } else {
                        rt = rightrightrotation(rt);
                    }
                }
            } else if (rt.left.right != null) {
                if (rt.left.right.colour == true && rt.left.colour == true) {
                    if (rt.right != null && rt.right.colour == true) {
                        rt.colour = true;
                        rt.left.colour = false;
                        rt.right.colour = false;
                    } else {
                        rt = leftrightrotation(rt);
                    }
                }
            }
        }
        return rt;
    }

    NodeRB rightrightrotation(NodeRB x) {
        NodeRB temp;
        temp = x.left;
        x.left = temp.right;
        temp.right = x;
        x.colour = true;
        temp.colour = false;
        temp.right.colour = true;
        return temp;
    }

    NodeRB leftleftrotation(NodeRB x) {
        NodeRB temp;
        temp = x.right;
        x.right = temp.left;
        temp.left = x;
        x.colour = true;
        temp.colour = false;
        temp.left.colour = true;
        return temp;
    }

    NodeRB leftrightrotation(NodeRB x) {
        NodeRB temp = x.left;
        temp = leftleftrotation(temp);
        return rightleftrotation(x);
    }

    NodeRB rightleftrotation(NodeRB x) {
        NodeRB temp = x.right;
        temp = rightrightrotation(temp);
        return leftleftrotation(x);
    }

    void InOrderTraverse(NodeRB rt) {
        if (rt != null) {
            InOrderTraverse(rt.left);
            System.out.print(rt.val + ", ");
            InOrderTraverse(rt.right);
        }
    }

    public void infixTraverse(NodeRB r) {
        if (r == null)
            return;
        infixTraverse(r.left);
        System.out.print(r.val + "\t");
        infixTraverse(r.right);
    }

    public void infixTraverseColour(NodeRB r) {
        if (r == null)
            return;
        infixTraverseColour(r.left);
        if (r.colour)
            System.out.print("Red\t");
        else
            System.out.print("Black\t");
        infixTraverseColour(r.right);
    }
    public void preTraverse(NodeRB r) {
        if (r == null)
            return;
        System.out.print(r.val + "\t");
        preTraverse(r.left);
        preTraverse(r.right);
    }
    public void preTraverseColour(NodeRB r) {
        if (r == null)
            return;
        if (r.colour)
            System.out.print("Red\t");
        else
            System.out.print("Black\t");
            preTraverseColour(r.left);
            preTraverseColour(r.right);
    }
}