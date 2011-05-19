/**
 * 
 */
package br.com.mystudies.log4j;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.MDC;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.spi.LoggingEvent;

/**
 * 
 * This class is adaptation this post:
 * <br><br>
 * http://veerasundar.com/blog/2011/05/log4j-tutorial-writing-different-log-levels-in-different-log-files/
 * 
 * @author robson
 *
 */
public class LogLevelFilterFileAppender extends FileAppender{

	private static final String ORIG_LOG_FILE_NAME = "OrginalLogFileName";

	public LogLevelFilterFileAppender() {
		super();
	}


	public LogLevelFilterFileAppender(Layout layout, String filename,
			boolean append) throws IOException {
		super(layout, filename, append);
	}

	public LogLevelFilterFileAppender(Layout layout, String filename)
	throws IOException {
		super(layout, filename);
	}

	@Override
	public void activateOptions() {
		MDC.put(ORIG_LOG_FILE_NAME, fileName);
	}	

	@Override
	public void append(LoggingEvent event) {
		try {
			setFile(
					appendLevelToFileName(
							(String) MDC.get(ORIG_LOG_FILE_NAME), 
							event.getLevel().toString()
					), 
					fileAppend, 
					bufferedIO, 
					bufferSize
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.append(event);
	}


	private String appendLevelToFileName(String oldLogFileName, String level){
		
		return new StringBuffer()
			.append(oldLogFileName.substring(0, oldLogFileName.indexOf(".")))
			.append("-")
			.append(level)
			.append("-")
			.append(oldLogFileName.substring(oldLogFileName.indexOf("."), oldLogFileName.length()))
			.toString();
	}

}
