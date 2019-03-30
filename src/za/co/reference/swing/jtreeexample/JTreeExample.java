package za.co.reference.swing.jtreeexample;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import za.co.reference.swing.rootwindow.Window;
import za.co.reference.swing.rootwindow.WindowDecorator;

public class JTreeExample extends WindowDecorator implements TreeSelectionListener{

	public JTreeExample(Window decoratedWindow){
		super(decoratedWindow);
		DefaultMutableTreeNode animals = new DefaultMutableTreeNode("Animals");
		DefaultMutableTreeNode dogs = new DefaultMutableTreeNode("Dogs");
		DefaultMutableTreeNode cats = new DefaultMutableTreeNode("Cats");
		DefaultMutableTreeNode birds = new DefaultMutableTreeNode("Birds");
		animals.add(dogs);
		animals.add(cats);
		animals.add(birds);
		dogs.add(new DefaultMutableTreeNode("German Shepherd"));
		dogs.add(new DefaultMutableTreeNode("Fox Terrier"));
		cats.add(new DefaultMutableTreeNode("Siamese Cat"));
		cats.add(new DefaultMutableTreeNode("Ginger Cat"));
		birds.add(new DefaultMutableTreeNode(new Bird("Budgie", "Bruce")));
		birds.add(new DefaultMutableTreeNode(new Bird("Parrot", "Jim")));
		tree = new JTree(animals);
//		tree.setRootVisible(false);
//		tree.setShowsRootHandles(true);
//		tree.putClientProperty("JTree.lineStyle", "Horizontal"); //"None", "Angled", "Horizontal"
		JScrollPane scrollPane = new JScrollPane(tree);
		tree.addTreeSelectionListener(this);
		
		JPanel panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);
		panel.add(scrollPane);
		addPanel(panel);
	}

	@Override
	public void addPanel(JPanel panel){
		decoratedWindow.addPanel(panel);
	}

	@Override
	public void valueChanged(TreeSelectionEvent e){
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		//It's also possible to cast the node into it's original class (Bird)
		if (node == null){
			System.out.println("None selected");
		}
		else{
			if (node.isLeaf()){
				System.out.println(node + " selected is a leaf");
			}
			else{
				System.out.println(node + " selected is not a leaf");
			}
		}
	}
	
	public class Bird{
		
		public Bird(String species, String name){
			this.species = species;
			this.name = name;
		}
		
		public String getSpecies(){
			return species;
		}
		
		public void setSpecies(String species){
			this.species = species;
		}
		
		public String getName(){
			return name;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public String toString(){
			return species + " - " + name;
		}
		
		private String species;
		private String name;
		
	}
	
	private JTree tree = null;
	
}
