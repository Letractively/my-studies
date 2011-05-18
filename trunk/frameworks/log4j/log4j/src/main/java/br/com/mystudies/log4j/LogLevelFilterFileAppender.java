/**
 * 
 */
package br.com.mystudies.log4j;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

/**
 * 
 * This class is reproduction this post:
 * <br><br>
 * http://veerasundar.com/blog/2011/05/log4j-tutorial-writing-different-log-levels-in-different-log-files/
 * 
 * @author robson
 *
 */
public class LogLevelFilterFileAppender extends FileAppender{

	public LogLevelFilterFileAppender() {
		super();
	}

	public LogLevelFilterFileAppender(Layout layout, String filename,
			boolean append, boolean bufferedIO, int bufferSize)
			throws IOException {
		super(layout, filename, append, bufferedIO, bufferSize);
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
	public void append(LoggingEvent event) {
		System.out.println("temp");
/*		// TODO Auto-generated method stub
		super.append(event);*/
	}

	
	
}
