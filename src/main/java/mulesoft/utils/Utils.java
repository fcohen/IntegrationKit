package mulesoft.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class Utils {
	
	public static byte[] readFile(File files) throws IOException {
		FileInputStream inputStream = new FileInputStream(files);
		byte[] data = IOUtils.toByteArray((InputStream) inputStream);
		inputStream.close();
		return data;
	}

	public static String substitute(final String pageContents,
			final Map substitutions) {
		StringBuffer patternBuf = new StringBuffer();
		int i = 0;
		Iterator<?> keys = substitutions.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			patternBuf.append(i++ == 0 ? "" : "|").append("\\$").append(key);
		}
		Pattern pattern = Pattern.compile(patternBuf.toString());
		patternBuf = null;
		Matcher matcher = pattern.matcher(pageContents);
		StringBuffer buf = new StringBuffer();
		while (matcher.find()) {
			String key = matcher.group(0).substring(1);
			String replaceStr = ((String) substitutions.get(key)).replace("\\",
					"\\\\").replaceAll("\\$", "SDLR");
			matcher.appendReplacement(buf, replaceStr);
		}
		matcher.appendTail(buf);
		return buf.toString().replaceAll("SDLR", "\\$");
	}
}
