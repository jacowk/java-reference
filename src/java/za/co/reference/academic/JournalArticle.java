package za.co.reference.academic;

public class JournalArticle {
	
	private String author = "";
	private String year = "";
	private String articleTitle = "";
	private String journalTitle = "";
	private String volumeNo = "";
	private String partNoOrIssueOrMonth = "";
	private String pages = "";
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getArticleTitle() {
		return articleTitle;
	}
	
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	
	public String getJournalTitle() {
		return journalTitle;
	}
	
	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}
	
	public String getVolumeNo() {
		return volumeNo;
	}
	
	public void setVolumeNo(String volumeNo) {
		this.volumeNo = volumeNo;
	}
	
	public String getPartNoOrIssueOrMonth() {
		return partNoOrIssueOrMonth;
	}
	
	public void setPartNoOrIssueOrMonth(String partNoOrIssueOrMonth) {
		this.partNoOrIssueOrMonth = partNoOrIssueOrMonth;
	}
	
	public String getPages() {
		return pages;
	}
	
	public void setPages(String pages) {
		this.pages = pages;
	}
	
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append(getAuthor());
		output.append(" (");
		output.append(getYear());
		output.append(") ");
		output.append(getArticleTitle());
		output.append(". ");
		output.append(getJournalTitle());
		output.append(", ");
		output.append(getVolumeNo());
		output.append(" (");
		output.append(getPartNoOrIssueOrMonth());
		output.append("), ");
		output.append("pp. ");
		output.append(getPages());
		output.append(".");
		return output.toString();
	}
	
	
	
}
