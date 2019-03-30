package za.co.reference.testprojects.one;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class TableButtonsPanel extends JPanel{
	
	public TableButtonsPanel(){
		
	}
	
	public TableButtonsPanel(ArtistListWindow artistListWindow){
		tableButtonsPresenter.setArtistListWindow(artistListWindow);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		addButton = new FormButton("Add", "add", tableButtonsPresenter.getTableButtonAction());
		modifyButton = new FormButton("Modify", "modify", tableButtonsPresenter.getTableButtonAction());
		deleteButton = new FormButton("Delete", "delete", tableButtonsPresenter.getTableButtonAction());
		viewButton = new FormButton("View", "view", tableButtonsPresenter.getTableButtonAction());
		add(addButton);
		add(modifyButton);
		add(deleteButton);
		add(viewButton);
	}
	
	public FormButton getAddButton(){
		return addButton;
	}

	public FormButton getModifyButton(){
		return modifyButton;
	}

	public FormButton getDeleteButton(){
		return deleteButton;
	}

	public FormButton getViewButton(){
		return viewButton;
	}

	private ArtistListWindow artistListWindow;
	private TableButtonsPresenter tableButtonsPresenter = new TableButtonsPresenter();;
	private FormButton addButton;
	private FormButton modifyButton;
	private FormButton deleteButton;
	private FormButton viewButton;

}
