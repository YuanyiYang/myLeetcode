package first;

import java.util.LinkedList;

public class PopulateRightPointerOne {
	
	 public class TreeLinkNode {
		 int val;
		 TreeLinkNode left, right, next;
		 TreeLinkNode(int x) { val = x; }
	 }
	 
	 public void connect(TreeLinkNode root) {
	        if(root==null) return;
	        TreeLinkNode parent = root;
	        TreeLinkNode child = root.left;
	        TreeLinkNode firstchild = root.left;
	        while(firstchild!=null){
	            child.next = parent.right;
	            child = child.next;
	            parent = parent.next;
	            while(parent!=null){
	                child.next = parent.left;
	                child = child.next;
	                child.next = parent.right;
	                child = child.next;
	                parent = parent.next;
	            }
	            parent = firstchild;
	            firstchild = parent.left;
	            child = parent.left;
	        }
	 }
	 
	 public void connectGeneral(TreeLinkNode root){
		 LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
	        if(root==null) return;
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int i=0;i<size;i++){
	                TreeLinkNode current = queue.poll();
	                if(current.left!=null) queue.offer(current.left);
	                if(current.right!=null) queue.offer(current.right);
	                if(i!=size-1) current.next = queue.peek();
	            }
	        }
	 }
}
