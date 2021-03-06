package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import actions.GradeAssignment;
import command.GradeAssignmentCommand;
import data.Database;
import domain.Affiliation;
import domain.Article;
import domain.Conference;
import domain.Grade;
import domain.Researcher;
import org.junit.*;
import static org.junit.Assert.*;
public class testConference {
	Article ArticleTest;
	Article ArticleTest2;
	Researcher AuthorTest;
	Affiliation AffiliationAll;
	Researcher Reviewer1;
	Researcher Reviewer2;
	Researcher Reviewer3;
	Researcher Reviewer4;
	Researcher Reviewer5;
	Researcher Reviewer6;
	Conference ConferenceTest;
	String STAll;
	List<Researcher> Researchers;
	List<Article> ArticlesGrade;
	List<Article> ArticlesNoGrade;
	List<String> stl;
	Grade GradeLessThanMin;
	Grade GradeGreaterThanMax;
	Database DB;
	GradeAssignmentCommand GradeAssigCom;
	GradeAssignment GradAssig;
	Grade GradeR3;
	Grade notaR4;
	Grade notaR5;
	Grade notaR6;
	GradeAssignment GraAssig;
	Conference ConfArticlesNoGrade;
	Conference ConfArticlesGrade;
	@Before
	public void setUp() throws Exception{
		
		AffiliationAll =new Affiliation(10,"UFRGS");
		STAll = "Viagem No Tempo";
		Researchers = new ArrayList<Researcher>();
		stl = new ArrayList();
		stl.add(STAll);
		AuthorTest = new Researcher(10,"Kurisu","UFRGS",stl);
		Reviewer1 = new Researcher(9,"Alexis","UFRGS",stl);
		Reviewer2 = new Researcher(8,"Arthur","UFRGS",stl);
		Reviewer3 = new Researcher(7,"Magnum","UFRGS",stl);
		Reviewer4 = new Researcher(6,"Mario","UFRGS",stl);
		Reviewer5 = new Researcher(5,"Okabe","UFRGS",stl);
		Reviewer6 = new Researcher(4,"Rintaro","UFRGS",stl);
		Researchers.add(Reviewer1);
		Researchers.add(Reviewer2);
		Researchers.add(Reviewer3);
		Researchers.add(Reviewer4);
		Researchers.add(Reviewer5);
		Researchers.add(Reviewer6);
		Researchers.add(AuthorTest);
		Conference conferenceTest=new Conference("aaa",new ArrayList<Researcher>(),new ArrayList<Article>());
		ArticleTest = new Article(99,"Viagem no Tempo No Jap�o",AuthorTest.getResearcherID(),conferenceTest.getInitials(),STAll);
		GradeR3 = new Grade(3,Reviewer3);
		ArticleTest2=ArticleTest;
		ArticlesNoGrade = new ArrayList<Article>();
		ArticlesGrade = new ArrayList<Article>();
		ArticleTest.saveGrade(GradeR3);
		ArticlesGrade.add(ArticleTest);
		ArticlesNoGrade.add(ArticleTest2);
		ConfArticlesNoGrade = new Conference("Conferencia do tempo",Researchers,ArticlesNoGrade);
		ConfArticlesGrade = new Conference("Conferencia do espa�o",Researchers,ArticlesGrade);
	}
	@Test
	public void TestAllArticlesHaveGradesTrue() {
		assertTrue(ConfArticlesGrade.allArticlesHaveGrades());
	}
	@Test
	public void TestAllArticlesHaveGradesFalse() {
		assertTrue(ConfArticlesGrade.allArticlesHaveGrades());
	}
}
