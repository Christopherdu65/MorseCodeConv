
/**
 *TreeNode class that will have the object used for conversion
 * @param <T>
 */
public class TreeNode<T> {
	
	protected T data;
	protected TreeNode<T> leftC;
	protected TreeNode<T> rightC;
	
	/**
	 * @param dataNode the data that will be atributed to this node
	 */
	public TreeNode(T dataNode) {
		leftC = rightC = null;
		data = dataNode;
	}
	
	/**
	 * @param node the node that is being copied
	 */
	public TreeNode(TreeNode<T> node) {
		this.leftC = new TreeNode(node.leftC);
		this.rightC = new TreeNode(node.rightC);
		
	}
	
	/**
	 * @return data of the element
	 */
	public T getData() {
		return data;
	}
}
