package za.co.reference.academic;

public class GenerateAcademicReference {
	
	public static void main(String[] args) {
		GenerateAcademicReference generateAcademicReference = new GenerateAcademicReference();
		generateAcademicReference.generateJournalArticle();
	}
	
	public void generateJournalArticle() {
		JournalArticle journalArticle = new JournalArticle();
		journalArticle.setAuthor("IMRAN, N.");
		journalArticle.setYear("2010");
		journalArticle.setArticleTitle("Electronic Media, Creativity and Plagiarism");
		journalArticle.setJournalTitle("ACM SIGCAS Computers and Society");
		journalArticle.setVolumeNo("40");
		journalArticle.setPartNoOrIssueOrMonth("4");
		journalArticle.setPages("25-44");
		System.out.println(journalArticle.toString());
	}
	
}
