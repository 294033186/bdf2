package com.bstek.bdf2.export.utils;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.bstek.dorado.core.Configure;

public class ExportUtils {

	public static String getFileStorePath() {
		String fileLocation = Configure.getString("bdf2.export.location");
		if (StringUtils.isNotEmpty(fileLocation)) {
			return fileLocation.endsWith(File.separator) ? fileLocation : fileLocation + File.separator;
		} else {
			fileLocation = System.getProperty("java.io.tmpdir");
			if (!fileLocation.endsWith(File.separator)) {
				fileLocation += File.separator;
			}
			return fileLocation + "bdf2-export-temp"+ File.separator;
		}
	}

	public static File getFile(String id, String name) {
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(name)) {
			String fullName = id + "_" + name;
			return new File(ExportUtils.getFileStorePath(), fullName);
		}
		return null;
	}

	public static SimpleDateFormat getSimpleDateFormat() {
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf;
	}

}
