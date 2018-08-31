package com.util;

import java.io.File;
import java.util.List;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class ZipUtil {
	
	public static void main(String[] args) {
//		String[] filePath = {"d:/2.png","d:/3.png","d:/4.png"};
//		compress(filePath, "d:/t.zip");
		
		
	}
	
//	
//	public static void compress(String[] filePath,String desPathName) {
//		Zip zip = new Zip();
//		for (String string : filePath) {
//			File srcdir = new File(string);
//			if (!srcdir.exists())
//				throw new RuntimeException(filePath + "不存在！");
//			Project prj = new Project();
//			
//			zip.setProject(prj);
//			zip.setDestFile(new File(desPathName));
//			FileSet fileSet = new FileSet();
//			fileSet.setProject(prj);
//			fileSet.setFile(new File(string));
//			//fileSet.setIncludes("**/*.java"); 包括哪些文件或文件夹 eg:zip.setIncludes("*.java");
//			//fileSet.setExcludes(...); 排除哪些文件或文件夹
//			zip.addFileset(fileSet);
//		}
//		
//		
//		
//		zip.execute();
//		
//	}
//

	public static void compress1(List<String> filePath, String zipFilePath) {
		Zip zip = new Zip();
		for (String string : filePath) {
			File srcdir = new File(string);
			if (!srcdir.exists())
				throw new RuntimeException(filePath + "不存在！");
			Project prj = new Project();
			zip.setProject(prj);
			zip.setDestFile(new File(zipFilePath));
			FileSet fileSet = new FileSet();
			fileSet.setProject(prj);
			fileSet.setFile(new File(string));
			//fileSet.setIncludes("**/*.java"); 包括哪些文件或文件夹 eg:zip.setIncludes("*.java");
			//fileSet.setExcludes(...); 排除哪些文件或文件夹
			zip.addFileset(fileSet);
		}
		zip.execute();
		
	}
}
