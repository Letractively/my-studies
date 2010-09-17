/**
 * 
 */
package br.com.studies.uml.composition;

/**
 * 
 * This is container in relation , when the container is destroyed, so are the contents.
 * 
 * @author rduarte
 *
 */
public class Window {

	private StatusBar statusBar;

	public StatusBar getStatusBar() {
		return statusBar;
	}

	public void setStatusBar(StatusBar statusBar) {
		this.statusBar = statusBar;
	}	
}
