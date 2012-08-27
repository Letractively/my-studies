package br.com.experian.pbd.plugin;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import br.com.experian.pbd.plugin.file.FileCreator;
import br.com.experian.pbd.plugin.file.PBDFileCreator;
import br.com.experian.pbd.plugin.information.JavassistClassInformation;
import br.com.experian.pbd.plugin.scanner.ClassScanner;
import br.com.experian.pbd.plugin.scanner.DependencyClassScanner;
import br.com.experian.pbd.plugin.scanner.ProjectClassScanner;

/**
 *
 *  @goal pbd
 * 	@phase compile
 *
 */

public class PBDMojo extends AbstractMojo{

    /**
     * The Maven project.
     *
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;


    /**
     * The directory for compiled classes.
     *
     * @parameter default-value="${project.build.outputDirectory}"
     * @required
     * @readonly
     */
    private File outputDirectory;

    /**
     * The dependencies in project for scanner class.
     *
     * @parameter
     */
    private Dependency[] dependenciesScanner;



	public void execute() throws MojoExecutionException, MojoFailureException {


		getLog().info("Scannig class..");

		List<String> classNames = getClassNamesInProject();


		if(dependenciesScanner != null && dependenciesScanner.length > 0 ){
			for (Dependency  dependency : dependenciesScanner) {
				if(containsDependecy(dependency)){
					classNames.addAll(getClassNamesInDependencies(dependency));
				}
			}
		}

		getLog().info("Scannig class finished");


		FileCreator fileCreator =
				PBDFileCreator.builder(project.getName(), outputDirectory.getAbsolutePath());

		getLog().info("Creating file..");

		fileCreator.createFile(classNames);

		getLog().info("Creating file finished");

	}



	private List<String> getClassNamesInProject() {
		ClassScanner classScanner =
				ProjectClassScanner.builder(new JavassistClassInformation()).setClassPath(outputDirectory.getAbsolutePath());
		return classScanner.getClassNames();
	}



	private List<String> getClassNamesInDependencies(Dependency dependency) {
		ClassScanner classScanner =
				DependencyClassScanner.builder(new JavassistClassInformation()).setClassPath(getArtifactPath(dependency));
		return classScanner.getClassNames();
	}




	private String getArtifactPath(Dependency dependency) {

		@SuppressWarnings("rawtypes")
		Set artifacts = project.getArtifacts();

		for (Object object : artifacts) {
			Artifact artifact = (Artifact) object;
			if(artifact.getArtifactId().equals(dependency.getArtifactId())
					&& artifact.getGroupId().equals(dependency.getGroupId())
					&& artifact.getVersion().equals(dependency.getVersion())){
				return artifact.getFile().getAbsolutePath();
			}
		}

		return null;
	}


	private boolean containsDependecy(Dependency dependency) {

		@SuppressWarnings("rawtypes")
		List dependencies = project.getDependencies();

		for (Object object : dependencies) {
			Dependency d = (Dependency) object;
			if(d.getArtifactId().equals(dependency.getArtifactId())
					&& d.getGroupId().equals(dependency.getGroupId())
					&& d.getVersion().equals(dependency.getVersion())){
				return true;
			}
		}

		return false;
	}



	public void setDependenciesScanner(Dependency[] dependenciesScanner) {
		this.dependenciesScanner = dependenciesScanner;
	}

}
