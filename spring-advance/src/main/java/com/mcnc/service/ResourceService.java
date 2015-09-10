package com.mcnc.service;
import java.io.File;
import java.io.IOException;

import org.springframework.core.io.Resource;

public class ResourceService {
	private File file;
	public ResourceService(Resource file) throws IOException{
		this.file = file.getFile();
	}
	public File getFile() {
		return file;
	}
}
