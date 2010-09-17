/**
 * 
 */
package br.com.studies.uml.composition;

/**
 * 
 * this is content in relation, when the container is destroyed , so are the content.
 * 
 * @author rduarte
 *
 */
public class StatusBar {

	private Window window;

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}
}
