package com.mcnc.controller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriUtils;

import com.mcnc.service.ResourceService;
import com.mcnc.util.Dimension;
import com.mcnc.util.FileUtils;
import com.mcnc.util.ImageUtils;
import com.mcnc.util.Scale;

@Controller
@RequestMapping("/resources")
public class ResourceController {
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * Download
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/{fileName:.+}/download")
	public @ResponseBody ResponseEntity<byte[]> getFile() throws UnsupportedEncodingException {
		
		File file = resourceService.getFile();
		String fileName = file.getName();
		
		HttpHeaders headers = this.generateImageResponseHeaders(fileName, (int) file.length());
		
		ByteArrayOutputStream outputStream = FileUtils.readFile(file);
		
		return new ResponseEntity<byte[]>( outputStream.toByteArray(), headers, HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * http://localhost:8080/advance/resources/tx/quality?scale=THIRD_QUALTER
	 * 
	 * view by quality scale
	 * @param quality
	 * @return
	 */
	@RequestMapping("/{fileName:.+}/quality")
	public @ResponseBody ResponseEntity<byte[]> viewFileByQuality(@RequestParam Scale scale){
		File file = resourceService.getFile();
		//String fileName = file.getName();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		try {
			ByteArrayOutputStream outputStream =  null;
			
			outputStream = ImageUtils.reduceQuality(file, scale);
			
			return new ResponseEntity<byte[]>( outputStream.toByteArray(), headers, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<byte[]>(headers, HttpStatus.BAD_GATEWAY);
		
	}
	
	
	/**
	 * http://localhost:8080/advance/resources/tx/size?scale=HALF
	 * view by size scale
	 * @param quality
	 * @return
	 */
	@RequestMapping("/{fileName:.+}/size")
	public @ResponseBody ResponseEntity<byte[]> viewFileBySize(@RequestParam Scale scale){
		File file = resourceService.getFile();
		//String fileName = file.getName();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		try {
			ByteArrayOutputStream outputStream =  null;
			
			outputStream = ImageUtils.resizeImage(file, scale);
			
			return new ResponseEntity<byte[]>( outputStream.toByteArray(), headers, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<byte[]>(headers, HttpStatus.BAD_GATEWAY);
		
	}
	
	
	
	/**
	 * http://localhost:8080/advance/resources/tx/dimension?height=160&width=120
	 * 
	 * view by dimension
	 * @param quality
	 * @return
	 */
	@RequestMapping("/{fileName:.+}/dimension")
	public @ResponseBody ResponseEntity<byte[]> viewFileBySize(@ModelAttribute Dimension dimension){
		File file = resourceService.getFile();
		//String fileName = file.getName();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		try {
			ByteArrayOutputStream outputStream =  null;
			
			outputStream = ImageUtils.resizeImage(file, dimension);
			
			return new ResponseEntity<byte[]>( outputStream.toByteArray(), headers, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<byte[]>(headers, HttpStatus.BAD_GATEWAY);
		
	}
	
	
	/**
	 * View Image in thumbnail
	 * 
	 * Thumbnail: all resized to a maximum dimension of 640 pixels by 480 pixels while 
	 * 
	 * http://localhost:8080/advance/resources/tx/thumbnail
	 * @return
	 */
	@RequestMapping("/{fileName:.+}/thumbnail")
	public @ResponseBody ResponseEntity<byte[]> viewInThumbnail(){
		File file = resourceService.getFile();
		//String fileName = file.getName();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		try {
			ByteArrayOutputStream outputStream =  null;
			
			
			outputStream = ImageUtils.generateThumbnail(file);
			
			return new ResponseEntity<byte[]>( outputStream.toByteArray(), headers, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<byte[]>(headers, HttpStatus.BAD_GATEWAY);
		
	}
	
	
	private HttpHeaders generateImageResponseHeaders(String fileName, int fileSize){
		try {
			String encodeFileName = UriUtils.encodePath( fileName, "UTF-8");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentLength((int) fileSize);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("inline", encodeFileName);
			return headers;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}