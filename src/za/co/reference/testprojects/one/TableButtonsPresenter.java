package za.co.reference.testprojects.one;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableButtonsPresenter{
	
	public TableButtonsPresenter(){
		
	}
	
	private class TableButtonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event){
			if (event.getActionCommand().equals("add")){
				new ArtistForm(artistListWindow, ButtonAction.ADD);
			}
			else if (event.getActionCommand().equals("modify")){
				new ArtistForm(artistListWindow, ButtonAction.MODIFY);
			}
			else if (event.getActionCommand().equals("delete")){
				new ArtistForm(artistListWindow, ButtonAction.DELETE);
			}
			else if (event.getActionCommand().equals("view")){
				new ArtistForm(artistListWindow, ButtonAction.VIEW);
			}
		}
		
	}
	
	public TableButtonAction getTableButtonAction(){
		return tableButtonAction;
	}
	
	public void setArtistListWindow(ArtistListWindow artistListWindow){
		this.artistListWindow = artistListWindow;
	}
	
	private TableButtonAction tableButtonAction = new TableButtonAction();
	private ArtistListWindow artistListWindow;
	
}
