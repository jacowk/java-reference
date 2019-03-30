package za.co.reference.designpatterns.behavioralpatterns.mediator;

public class Mediator{
	
	public void registerView(BtnView btnView){
		this.btnView = btnView;
	}
	
	public void registerSearch(BtnSearch btnSearch){
		this.btnSearch = btnSearch;
	}
	
	public void registerDisplay(DisplayLabel show){
		this.show = show;
	}
	
	public void view(){
		btnView.setEnabled(false);
		btnSearch.setEnabled(true);
		show.setText("Viewing...");
	}
	
	public void search(){
		btnSearch.setEnabled(false);
		btnView.setEnabled(true);
		show.setText("Searching...");
	}
	
	private BtnView btnView;
	private BtnSearch btnSearch;
	private DisplayLabel show;

}
