package org.test.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

import com.mcnc.util.Dimension;
import com.mcnc.util.ImageUtils;
import com.mcnc.util.Scale;

public class TestImageUtils extends Assert{

	@Test
	public void testReduceQuality() throws UnsupportedEncodingException {
		System.out.println(TestImageUtils.class.getClassLoader().getResource("aa.jpg").getFile());
		File file = new File(TestImageUtils.class.getClassLoader().getResource("aa.jpg").getFile());
		try {
			assertTrue(file.exists());
			ByteArrayOutputStream reduceQuality = ImageUtils.reduceQuality(file, Scale.QUALTER);
			assertNotNull(reduceQuality);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testResize() throws UnsupportedEncodingException {
		File file = new File(TestImageUtils.class.getClassLoader().getResource("aa.jpg").getFile());
		try {
			Dimension dimension = new Dimension(100, 100) ;
			ByteArrayOutputStream resizeImage = ImageUtils.resizeImage(file, dimension );
			assertNotNull(resizeImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
