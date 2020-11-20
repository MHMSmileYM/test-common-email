//Mostafa ELMajzoub
//JUNIT Homework
package org.apache.commons.mail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	private static final String[] TEST_EMAILS = { "ab@bc.com", "a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd" };
	private static final String[] TEST_NULL = null;
	private static final String[] TEST_ENCODING = {"sdadsadsadsa","adssadsadsadsa","sdadsadsa" };
	private static final String TEST_EMAIL = "ab@bc.com";
	private static final String TEST_NAME = "test";
	private static final String TEST_SUBJECT = "test";
	private static final String TEST_VALUE = "test";	
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
	}
	
	@After
	public void tearDownEmaiLtest() throws Exception{
		
	}
	
	@Test
	public void testAddBcc() throws Exception{
		email.addBcc(TEST_EMAILS);
		assertEquals(3, email.getBccAddresses().size());
		email.addBcc(TEST_NULL);
		assertEquals(0, email.getBccAddresses().size());
	}
	
	@Test
	public void testAddCc() throws Exception{
		email.addCc(TEST_EMAILS);
		assertEquals(3, email.getCcAddresses().size());
		email.addCc(TEST_NULL);
		assertEquals(0, email.getCcAddresses().size());
	}
	
	@Test
	public void testAddHeader() throws Exception{
		email.addHeader("", TEST_VALUE);
		assertEquals(3, email.headers.size());
		email.addHeader(TEST_NAME, "");
		assertEquals(3, email.headers.size());
		email.addHeader(TEST_NAME, TEST_VALUE);
		assertEquals(3, email.headers.size());
		email.addHeader("", "");
		assertEquals(3, email.headers.size());
	}
	
	@Test
	public void testAddReplyTo() throws Exception{
		email.addReplyTo(TEST_EMAIL, TEST_NAME);
		assertEquals(3, email.replyList.size());
		email.addReplyTo("", "");
		assertEquals(3, email.replyList.size());
	
	}
}