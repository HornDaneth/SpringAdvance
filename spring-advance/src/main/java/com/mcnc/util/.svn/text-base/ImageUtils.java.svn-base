package com.mcnc.util;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import net.coobird.thumbnailator.Thumbnails;

public abstract class ImageUtils {
	
	public static ByteArrayOutputStream reduceQuality(File file, Scale scale) throws IOException{
		InputStream inputStream = new FileInputStream(file);
		ByteArrayOutputStream outputStream = null;
		try {
			String fileExtension = FileUtils.getExtension(file);
			outputStream = ImageUtils.reduceQuality(inputStream, fileExtension, scale);
			
		} catch (Exception e) {
		} finally {
			inputStream.close();
		}
		
		return outputStream;
		
	}
	
	
	
	public static ByteArrayOutputStream reduceQuality(InputStream inputStream, String fileExtension, Scale scale) throws IOException{
		// response in byte array
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		// create image from file
		RenderedImage renderedImage = ImageIO.read(inputStream);
		
		IIOImage image = new IIOImage(renderedImage, null, null);
		
		
		// Get a ImageWriter by suffix
		ImageWriter writer = ImageUtils.getImageWriterBySuffix(fileExtension);
		
		if(writer != null){
			// Create the ImageWriteParam to compress the image.
			ImageWriteParam param = writer.getDefaultWriteParam();
			param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			param.setCompressionQuality(scale.getValue());
			
			// The output will be a ByteArrayOutputStream (in memory)
			ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
			
			// Write to output stream
			writer.setOutput(imageOutputStream);
			writer.write(null, image, param);
			
		}
		return outputStream;
	}
	
	
	public static ByteArrayOutputStream resizeImage(File file, Dimension dimension) throws IOException{
		InputStream inputStream = new FileInputStream(file);
		ByteArrayOutputStream outputStream = null;
		try {
			String fileExtension = FileUtils.getExtension(file);
			outputStream = ImageUtils.resizeImage(inputStream, fileExtension, dimension);
			
		} catch (Exception e) {
		} finally {
			inputStream.close();
		}
		
		return outputStream;
	} 
	
	
	
	public static ByteArrayOutputStream resizeImage(File file, Scale scale) throws IOException{
		InputStream inputStream = new FileInputStream(file);
		ByteArrayOutputStream outputStream = null;
		try {
			// get original size
			BufferedImage originalImage = ImageIO.read(inputStream);
			int oldHeight = originalImage.getHeight();
			int oldWidth = originalImage.getWidth();
			
			
			int newHeight = (int) (oldHeight * scale.getValue());
			int newWidth = (int) (oldWidth * scale.getValue());
			
			Dimension dimension = new Dimension(newHeight, newWidth);
			outputStream = ImageUtils.resizeImage(file, dimension);
			
		} catch (Exception e) {
		} finally {
			inputStream.close();
		}
		
		return outputStream;
	} 
	
	
	public static ByteArrayOutputStream resizeImage(InputStream inputStream, String fileExtension, Dimension dimension) throws IOException{
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		BufferedImage originalImage = ImageIO.read(inputStream);
	    BufferedImage resizedImage = new BufferedImage(dimension.getWidth(), dimension.getHeight(), 
	    		BufferedImage.TYPE_INT_RGB );
	    Graphics2D g = resizedImage.createGraphics();
	    
	    g.drawImage(originalImage, 0, 0, dimension.getWidth(), dimension.getHeight(), null);
	    g.dispose();    
	    
	    //increase the re-sized image quality
	    g.setComposite(AlphaComposite.Src);
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	
	    ImageIO.write(resizedImage, fileExtension, outputStream);

	    return outputStream;
	}   
	
	
	public static ByteArrayOutputStream generateThumbnail(File file) throws IOException{
		String fileExtension = FileUtils.getExtension(file);
		InputStream inputStream = new FileInputStream(file);
		return ImageUtils.generateThumbnail(inputStream, fileExtension);
	}   
	
	
	public static ByteArrayOutputStream generateThumbnail(InputStream inputStream, String fileExtension) throws IOException{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		Thumbnails.of(inputStream)
			.size(640,  480)
			.outputFormat(fileExtension)
			.toOutputStream(outputStream);
		
		return outputStream;
	}   
	
	private static ImageWriter getImageWriterBySuffix(String suffix){
		Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix(suffix);
		
		if (!writers.hasNext()){
			throw new IllegalStateException("No writers found");
		}

		return writers.next();
	}
	
	
}
