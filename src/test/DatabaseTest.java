package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import data.Database;

import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import domain.Conference;
import domain.Affiliation;
import domain.Article;
import domain.Researcher;




public class DatabaseTest {
	private Database data= new Database();
	private String st;
	List<String> stl;
	private Researcher res;
	private List<Researcher> resList;
	private Article article;
	private List<Article> articleList;
	private int articleId;
	private int researcherId;
	
	@Before
	public void setUp() {
		
		data= new Database();
		st="st";
		stl = new ArrayList();
		stl.add(st);
		researcherId=111;
		res=new Researcher(researcherId,"Res","aa",stl);
		resList = Arrays.asList(res);
		articleId=123;
		article=new Article(articleId,"como fazer unit tests",res.getResearcherID(),null,st);
		articleList= Arrays.asList();

	}
	@Test
	public void testSaveConference() {

		Conference conf1=new Conference("mds",resList,articleList);
		data.save(conf1);
		
		assertTrue(conf1==data.getAllConferences().get(0));
		
		
	}
	
	@Test
	public void testSaveArticle() {
		data.save(article);
		List<Article> testList=data.getAllArticles();
		assertTrue(article==testList.get(0));
	}

	
	@Test
	public void testSaveResearcher() {
		data.save(res);
		assertTrue(res==data.getAllResearchers().get(0));
	}
	
	

	@Test
	public void testGetConference() {

		Conference conf1=new Conference("mds",resList,articleList);
		data.save(conf1);
		Conference conf2=data.getConference("mds");
		assertTrue(conf1==conf2);
		
		
	}
	
	@Test
	public void testGetArticle() {
		data.save(article);
		
		assertTrue(article==data.getArticle(articleId));
	}

	
	@Test
	public void testGetResearcher() {
		data.save(res);
		assertTrue(res==data.getResearcher(researcherId));
	}
	
	@Test
	public void testEmptyListConference() {
		assertTrue(data.getAllConferences().isEmpty());
		
		
	}
	
	@Test
	public void testEmptyListArticle() {

		assertTrue(data.getAllArticles().isEmpty());
	}

	
	@Test
	public void testEmptyListResearcher() {

		assertTrue(data.getAllResearchers().isEmpty());
	}
	
	@Test
	public void testConferenceNotFound() {
		assertTrue(null==data.getConference("mds"));
	}
	
	@Test
	public void testArticleNotFound() {
		assertTrue(null==data.getArticle(0));
	}

	
	@Test
	public void testResearcherNotFound() {
		assertTrue(null==data.getResearcher(0));
	}
	/*
	@Test
	public void testGetNotAllocatedConferences() {
		Conference conf1=new Conference("mds",resList,articleList);
		data.save(conf1);
		assertTrue(conf1==data.getNotAllocatedConferences().get("mds"));
	}
	*/
}
