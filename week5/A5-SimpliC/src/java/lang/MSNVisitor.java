package lang;

import lang.ast.*;

/**
 * Checks maximum depth of blocks in a SimpliC Program'
 */
public class MSNVisitor extends TraversingVisitor {
	public static int result(ASTNode n) {
		MSNVisitor v = new MSNVisitor();
		n.accept(v, null);
		return v.maxdepth;
	}

    private int depth = 0;
    private int maxdepth = 0;

	public Object visit(Block node, Object data) {
        depth++;
        //We are only interested in the maximum depth
        if (maxdepth < depth) {
            maxdepth = depth;
        }
        Object traverseToChild = super.visitChildren(node, data);
        //If we have more blocks we need to minus as we traverse back up the tree.
        depth--;
		return traverseToChild;
	}
}
