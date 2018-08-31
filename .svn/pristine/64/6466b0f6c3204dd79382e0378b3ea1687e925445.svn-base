package com.util;

import java.io.*;
import java.util.Iterator;
import java.awt.*;
import java.awt.image.*;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageCut {

	/**
	 * 对图片裁剪，并把裁剪完蛋新图片保存 。
	 * 
	 * @param srcpath
	 *            源图片路径
	 * @param subpath
	 *            剪切图片存放路径
	 * @param x
	 *            剪切点x坐标
	 * @param y
	 *            剪切点y坐标
	 * @param width
	 *            剪切宽度
	 * @param height
	 *            剪切高度
	 * @throws IOException
	 */
	public static void abscut(String srcpath, String subpath, int x, int y,
			int width, int height) {

		FileInputStream is = null;
		ImageInputStream iis = null;

		try {
			// 读取图片文件
			is = new FileInputStream(srcpath);

			/**//*
				 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
				 * 参数：formatName - 包含非正式格式名称 . （例如 "jpeg" 或 "tiff"）等 。
				 */
			String suffix = srcpath.substring(srcpath.lastIndexOf(".") + 1);

			Iterator<ImageReader> it = ImageIO
					.getImageReadersByFormatName(suffix);
			ImageReader reader = it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(is);

			/**//*
				 * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。
				 * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader
				 * 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
				 */
			reader.setInput(iis, true);

			/**//*
				 * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O
				 * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
				 * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
				 */
			ImageReadParam param = reader.getDefaultReadParam();

			/**//*
				 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
				 * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
				 */
			Rectangle rect = new Rectangle(x, y, width, height);

			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);

			/**//*
				 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
				 * BufferedImage 返回。
				 */
			BufferedImage bi = reader.read(0, param);

			// 保存新图片
			ImageIO.write(bi, "jpg", new File(subpath));
		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			try {
				if (is != null)
					is.close();
				if (iis != null)
					iis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 缩放图像
	 * 
	 * @param srcImageFile
	 *            源图像文件地址
	 * @param result
	 *            缩放后的图像地址
	 * @param scale
	 *            缩放比例
	 * @param flag
	 *            缩放选择:true 放大; false 缩小;
	 */
	public static void scale(String srcImageFile, String result, int scale,
			boolean flag) {
		try {
			BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件
			int width = src.getWidth(); // 得到源图宽
			int height = src.getHeight(); // 得到源图长
			if (flag) {
				// 放大
				width = width * scale;
				height = height * scale;
			} else {
				// 缩小
				width = width / scale;
				height = height / scale;
			}
			Image image = src.getScaledInstance(width, height,
					Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 重新生成按指定宽度和高度的图像
	 * 
	 * @param srcImageFile
	 *            源图像文件地址
	 * @param result
	 *            新的图像地址
	 * @param _width
	 *            设置新的图像宽度
	 * @param _height
	 *            设置新的图像高度
	 */
	public static void scale(String srcImageFile, String result, int _width,
			int _height) {
		scale(srcImageFile, result, _width, _height, 0, 0);
	}

	public static void scale(String srcImageFile, String result, int _width,
			int _height, int x, int y) {
		try {

			BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件

			int width = src.getWidth(); // 得到源图宽
			int height = src.getHeight(); // 得到源图长

			if (width > _width) {
				width = _width;
			}
			if (height > _height) {
				height = _height;
			}
			Image image = src.getScaledInstance(width, height,
					Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, x, y, null); // 绘制缩小后的图
			g.dispose();
			ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 图像类型转换 GIF->JPG GIF->PNG PNG->JPG PNG->GIF(X)
	 */
	public static void convert(String source, String result) {
		try {
			File f = new File(source);
			f.canRead();
			f.canWrite();
			BufferedImage src = ImageIO.read(f);
			ImageIO.write(src, "JPG", new File(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 彩色转为黑白
	 * 
	 * @param source
	 * @param result
	 */
	public static void gray(String source, String result) {
		try {
			BufferedImage src = ImageIO.read(new File(source));
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			src = op.filter(src, null);
			ImageIO.write(src, "JPEG", new File(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 晕。。。搞成多个了...
		// cut("c:/images/ipomoea.jpg", "c:/images/t/ipomoea.jpg", 200, 150);
		// ok
		// gray("c:/images/ipomoea.jpg", "c:/images/t/ipomoea.jpg");
		// convert("c:/images/ipomoea.jpg", "c:/images/t/ipomoea.gif");
		// scale("c:/images/5105049910001020110718648723.jpg",
		// "c:/images/t/5105049910001020110718648725.jpg",154,166,157,208);
		// scale("c:/images/rose1.jpg",
		// "c:/images/t/rose1.jpg",154,166,157,208);
		// scale("c:/images/rose1.jpg", "c:/images/t/rose2.jpg",154,166,10,10);
		abscut("C:/Users/Administrator/Desktop/1422424579634.jpeg",
				"C:/Users/Administrator/Desktop/1422424579475.jpeg", 100, 100,
				100, 100);
		
	}
	 public static void cutImageByProportion(String srcImageFile,String dirImageFile, float x, float y, float destWidth,
			 float destHeight){
		 try {
			BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件
			 float width = src.getWidth(); // 得到源图宽
			 float height = src.getHeight(); // 得到源图长
			 int newx=Math.round(x*width);
			 int newy=Math.round(y*height);
			 int newdestWidth=Math.round(destWidth*width);
			 int newdestHeight=Math.round(destHeight*height);
			 abscut(srcImageFile,dirImageFile,newx,newy,newdestWidth,newdestHeight);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }
	
}