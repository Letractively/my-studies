package br.com.experian.pbd.plugin.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

public class PBDFileCreator implements FileCreator{


	private static final String EXTENSAO_PBD = ".pbd";

	private String projectName;
	private String outputDirectory;
	private MessageFormat messageFormat;


	private PBDFileCreator(String projectName, String outputDirectory) {
		if(projectName == null || outputDirectory == null)
			throw new IllegalArgumentException("project name and outputDirecotory isn't null ");
		this.projectName = projectName;
		this.outputDirectory = outputDirectory;
		this.messageFormat = new MessageFormat("TraceAllMethodsOfClass: {0} BlamePointTracer \"SERASA|{1}|'{'classname'}'|'{'method'}'\"");

	}


	public static FileCreator builder(String projectName, String outputDirectory) {
		return new PBDFileCreator(projectName,outputDirectory);
	}


	public void createFile(List<String> classNames) {
		BufferedWriter bufferedWriter = null;
		try {
				bufferedWriter =
						new BufferedWriter(new FileWriter(new File(outputDirectory, projectName + EXTENSAO_PBD)));
			for (String className : classNames) {
				bufferedWriter.write(messageFormat.format(new String[]{className, projectName}));
				bufferedWriter.newLine();
			}

		} catch (IOException e) {
			throw new IllegalArgumentException("outputDirectory is invalid", e);
		}finally{
			try {
				if(bufferedWriter != null)
					bufferedWriter.close();
			} catch (IOException e) {

			}
		}
	}

}
