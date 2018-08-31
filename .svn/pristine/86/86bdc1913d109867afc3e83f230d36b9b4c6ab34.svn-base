package com.util;


/**
 *  缩略图实现，将图片(jpg、bmp、png、gif等等)真实的变成想要的大小
 */


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/*******************************************************************************
 * 缩略图类（通用） 本java类能将jpg、bmp、png、gif图片文件，进行等比或非等比的大小转换。 具体使用方法
 * compressPic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度,是否等比缩放(默认为true))
 */
 public class PicUtil { 
	
	 
	 // 图片处理 
	 public  static boolean compressPic(String oldFileName, String outputFileName, int outputWidth, int outputHeight, boolean proportion) { 
		 try { 
			 //获得源文件 
			 File file = new File(oldFileName); 
			 if (!file.exists()) { 
				 return false; 
			 } 
			 Image img = ImageIO.read(file); 
			 // 判断图片格式是否正确 
			 if (img.getWidth(null) == -1) {
				 ////System.out.println(" can't read,retry!" + "<BR>"); 
				 return false; 
			 } else { 
				 int newWidth=0; int newHeight=0; 
				 // 判断是否是等比缩放 
				 if (proportion == true) { 
					 // 为等比缩放计算输出的图片宽度及高度 
					 double rate1 = ((double) img.getWidth(null)) / (double)
					 outputWidth ;
					 double rate2 = ((double) img.getHeight(null)) / (double)
					 outputHeight ;
					 // 根据缩放比率大的进行缩放控制
					 double rate = rate1 > rate2 ? rate1 : rate2;
					 newWidth = (int) (((double) img.getWidth(null)) / rate);
					newHeight = (int) (((double) img.getHeight(null)) /
					 rate);
				 } else { 
					 newWidth = outputWidth; // 输出的图片宽度 
					 newHeight = outputHeight; // 输出的图片高度 
				 } 
			 	BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB); 
			 	
			 	/*
				 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的
				 * 优先级比速度高 生成的图片质量比较好 但速度慢
				 */ 
			 	tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_FAST), 0, 0, null);
			 	FileOutputStream out = new FileOutputStream(outputFileName);
			 	// JPEGImageEncoder可适用于其他图片类型的转换 
			 	//JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
			 	//encoder.encode(tag);
			 	ImageIO.write(tag, "png", out);
			 	out.close(); 
			 	return true;
			 } 
		 } catch (IOException ex) { 
			 ex.printStackTrace(); 
		 } 
		 return false; 
	} 
  
 	// main测试 
 	// compressPic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度,是否等比缩放(默认为true))
 	public static void main(String[] arg) { 
// 		boolean f = PicUtil.compressPic("e:/2.jpg", "e:/2.jpg", 172, 192, true);
// 		System.out.println(f);
// 		System.out.println("我来了");
 	} 
 }