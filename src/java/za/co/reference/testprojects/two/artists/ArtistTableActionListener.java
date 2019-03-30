package za.co.reference.testprojects.two.artists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import za.co.reference.testprojects.two.common.button.ButtonName;
import za.co.reference.testprojects.two.common.form.Form;
import za.co.reference.testprojects.two.common.form.FormState;

public class ArtistTableActionListener implements ActionListener{
	
	public ArtistTableActionListener(ArtistListWindow artistListWindow){
		this.artistListWindow = artistListWindow;
	}

	@Override
	public void actionPerformed(ActionEvent event){
		if (event.getActionCommand().equals(ButtonName.ADD.getName())){
			
			Form form = new ArtistFormPanel(this, "Add Artist", FormState.ADD, artistListWindow);
		}
		else if (event.getActionCommand().equals(ButtonName.MODIFY.getName())){
			Form form = new ArtistFormPanel(this, "Modify Artist", FormState.MODIFY, artistListWindow);
		}
		else if (event.getActionCommand().equals(ButtonName.DELETE.getName())){
			Form form = new ArtistFormPanel(this, "Delete Artist", FormState.DELETE, artistListWindow);
		}
		else if (event.getActionCommand().equals(ButtonName.VIEW.getName())){
			Form form = new ArtistFormPanel(this, "View Artist", FormState.VIEW, artistListWindow);
		}
		else if (event.getActionCommand().equals(ButtonName.SEARCH.getName())){
			System.out.println("Search");
		}
		else if (event.getActionCommand().equals(ButtonName.SAVE.getName())){
			System.out.println("Save");
		}
		else if (event.getActionCommand().equals(ButtonName.CANCEL.getName())){
			System.out.println("Cancel");
		}
	}
	
	private ArtistListWindow artistListWindow;

}
