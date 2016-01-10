package jp.kobe_u.cs27.primitive_eca.random_helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.primitive_eca.util.RandomGenerator;

public class RandomGeneratorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRandomUniqueId() {
		String actual = RandomGenerator.getRandomUniqueId();
		System.out.println(actual);
		assertNotEquals("a", actual);
	}

}
