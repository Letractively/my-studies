package br.com.experian.pbd.plugin;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class PBDMojoTest {

    @InjectMocks
    private PBDMojo pbdMojo;


    @Mock
    private File outputDirectory;


    @Mock
    private MavenProject mavenProject;


    @Mock
    private Artifact artifact;


    @Mock
    private File artifactFile;


    @Before
    public void setUp() throws Exception {
        pbdMojo = new PBDMojo();
        initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        pbdMojo = null;
    }


    @Test
    public void shouldExecuteNotException() throws MojoExecutionException, MojoFailureException {


    	// set of dependency in project mocked
    	Set<Artifact> dependencyMock = new HashSet<Artifact>();
    	dependencyMock.add(artifact);

    	Dependency dependency = new Dependency();
    	dependency.setArtifactId("experian-pbd-plugin");
    	dependency.setGroupId("br.com.experina");
    	dependency.setVersion("1.0.0");

    	Dependency[] dependenciesScanner = {dependency};
    	pbdMojo.setDependenciesScanner(dependenciesScanner);

    	List<Dependency> dependencies = new ArrayList<Dependency>();
    	dependencies.add(dependency);


    	when(outputDirectory.getAbsolutePath()).thenReturn(System.getProperty("user.dir") + "\\src\\test\\resources\\file");
    	when(mavenProject.getArtifacts()).thenReturn(dependencyMock);
    	when(mavenProject.getName()).thenReturn("experian-pbd-plugin");
    	when(mavenProject.getDependencies()).thenReturn(dependencies);
    	when(artifactFile.getAbsolutePath()).thenReturn(System.getProperty("user.dir") + "\\src\\test\\resources\\dependency\\dependency-1.0.0.jar");
    	when(artifact.getArtifactId()).thenReturn("experian-pbd-plugin");
    	when(artifact.getGroupId()).thenReturn("br.com.experina");
    	when(artifact.getVersion()).thenReturn("1.0.0");
    	when(artifact.getFile()).thenReturn(artifactFile);


    	pbdMojo.execute();


    	verify(outputDirectory, times(2)).getAbsolutePath();
    	verify(mavenProject).getDependencies();
    	verify(mavenProject).getName();
    	verify(mavenProject).getDependencies();
    	verify(artifactFile).getAbsolutePath();
    	verify(artifact).getFile();
    	verify(artifact).getArtifactId();
    	verify(artifact).getGroupId();
    	verify(artifact).getVersion();


    }

}
