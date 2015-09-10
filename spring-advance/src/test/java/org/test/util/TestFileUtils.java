package org.test.util;

import java.io.File;

import org.junit.Test;

import com.mcnc.util.FileUtils;

public class TestFileUtils {

	@Test
	public void test() {
		File file = new File(TestImageUtils.class.getClassLoader().getResource("aa.jpg").getFile());
		String extension = FileUtils.getExtension(file);
		System.out.println(extension);
	}

}
