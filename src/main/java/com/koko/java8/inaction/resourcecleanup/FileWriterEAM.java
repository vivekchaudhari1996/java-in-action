package com.koko.java8.inaction.resourcecleanup;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEAM {

	public static void main(String[] args) {
		try {
			FileWriterEAM.use("eam.txt", writerEAM -> writerEAM.writeStuff("sweet"));

			//
			FileWriterEAM.use("eam2.txt", writerEAM -> {
				writerEAM.writeStuff("how");
				writerEAM.writeStuff("sweet");
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private final FileWriter writer;

	private FileWriterEAM(final String fileName) throws IOException {
		writer = new FileWriter(fileName);
	}

	public static void use(final String fileName, final UseInstance<FileWriterEAM, IOException> block)
			throws IOException {
		final FileWriterEAM writerEAM = new FileWriterEAM(fileName);
		try {
			block.accept(writerEAM);
		} finally {
			writerEAM.close();
		}
	}

	private void close() throws IOException {
		System.out.println("close called automatically...");
		writer.close();
	}

	public void writeStuff(final String message) throws IOException {
		writer.write(message);
	}

}