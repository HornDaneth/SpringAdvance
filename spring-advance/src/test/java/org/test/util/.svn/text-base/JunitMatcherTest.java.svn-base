package org.test.util;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class JunitMatcherTest {

	@Test
	public void test() {
		String string = "dara";
		assertThat(string, notNullValue());
		assertThat(string, is("dara")); 
		assertThat(string, not( is("sara") ) );
		assertThat(string, either(containsString("dara")).or(containsString("dar")));
	}
}
