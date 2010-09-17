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
 * @see <a href='http://refcardz.dzone.com/assets/download/refcard/2bfde79c85c0c1ee91a91c273c36fc3d/rc112-010d-uml.pdf'>Refcard about UML</a>
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
