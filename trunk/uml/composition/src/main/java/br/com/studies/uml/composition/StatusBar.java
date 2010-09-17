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
 * @see <a href='http://refcardz.dzone.com/assets/download/refcard/2bfde79c85c0c1ee91a91c273c36fc3d/rc112-010d-uml.pdf'>Refcard about UML</a>
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
