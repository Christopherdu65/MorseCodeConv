
import java.util.ArrayList;

/**
 * @author Monthe Christopher Raoul
 *This is a MorseCodeTree which is specifically used for the conversion of morse code to english
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;

	/**
	 * Default constructor that initialize root and build a tree
	 */
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
		//System.out.println(root.leftC.data);
	}
	@Override
	public TreeNode<String> getRoot(){
		return root;
	}
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String letter) {
		addNode(root, code , letter);
		return this;
	}
	@Override
	public void buildTree() {
		
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}



	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		TreeNode<String> currentRoot = root;
		TreeNode<String> node = new TreeNode(letter);
		//TreeNode<String> newRoot = node;
		if(code.length() == 1) {
			if(code.equals(".")) {
				//System.out.println(node);
				currentRoot.leftC = node;
			}
			else {
				currentRoot.rightC = node;
			}
			return;
		}

		else {
			if(code.charAt(0) == '.') {
				currentRoot = currentRoot.leftC;

			}
			else {
				currentRoot = currentRoot.rightC;
			}
			code = code.substring(1);
			addNode(currentRoot, code, letter);
		}
	}



	@Override
	public String fetch(String code) {
		//root = new TreeNode<String>("");
		//System.out.println(root.leftC.data);
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		//System.out.println(root.leftC.data);
		TreeNode<String> curr = root;
		String temp;
		if(code.length() == 1) {
			if(code.equals(".")) {
				return curr.leftC.data;
			}
			else {
				return curr.rightC.data;
			}
		}

		else {
			if(code.charAt(0) == '.') {

				curr = curr.leftC;
				code = code.substring(1);
				//return result;
			}
			else {
				curr = curr.rightC;
				code = code.substring(1);
			}
			//code = code.substring(1);
			return fetchNode(curr, code);
		}
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {

		return null;
	}


	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> result = new ArrayList<>();
		LNRoutputTraversal(root, result);
		return result;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {

		if(root == null) {
			return;
		}
		LNRoutputTraversal(root.leftC, list);
		list.add(root.data);
		LNRoutputTraversal(root.rightC, list);
	}
}
