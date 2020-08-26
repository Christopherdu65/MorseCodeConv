import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterTest {
	File inputFile;
	MorseCodeConverter m;

	@Before
	public void setUp() throws Exception {
		m = new MorseCodeConverter();
	}

	@After
	public void tearDown() throws Exception {
		m = null;
	}

	@Test
	public void testPrintTree()
	{
		//Note the extra space between j and b - that is because there is an empty string that
		//is the root, and in the LNR traversal, the root would come between the right most
		//child of the left tree (j) and the left most child of the right tree (b).
		String correctResult = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		String s = m.printTree();
		s = s.trim(); // take off preceding or succeeding spaces
		assertEquals(correctResult, s);
	}
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = m.convertToEnglish(".... --- .-.. .-.. .- / .. / .-.. --- ...- . / ... .--. .- -. .. ... .... ");
		assertEquals("holla i love spanish",converter1);
		
		String test2="the weather is nice today";		
		String converter2 = m.convertToEnglish("- .... . / .-- . .- - .... . .-. / .. ... / -. .. -.-. . / - --- -.. .- -.-- ");
		assertEquals(test2, converter2);
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1="i will not lose";		
		getFile("promise.txt");
		String converter1 = m.convertToEnglish(inputFile);
		assertEquals(test1,converter1);
		
		String test2="a promise is a debt";		
		getFile("Debt.txt");
		String converter2 = m.convertToEnglish(inputFile);
		assertEquals(test2,converter2);
}
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
			}
			catch (Exception e) {
				
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}