package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Engine {
	private final String gamePath = GameFilesPaths.gamePath;
	private final String defaultSavePath = GameFilesPaths.defaultSavePath;
	
	private final String launcherSavesPath = defaultSavePath + "\\Launcher Saves";
	private String currentSaveSlotPath;
	
	public void play(int slotNum) throws IOException, InterruptedException {
		this.currentSaveSlotPath = launcherSavesPath + "\\Save " + slotNum;
		validateDirectory(launcherSavesPath);
		load();
		startPlaying();
		save();
	}

	private void startPlaying() throws IOException, InterruptedException {
		final String batchFilePath = launcherSavesPath + "\\Game Batch File.bat";
		createBatchFile(batchFilePath);
		Process process = new ProcessBuilder("\"" + batchFilePath + "\"").start();
		process.waitFor();
		new File(batchFilePath).delete();// game finished, delete batch file
	}

	private void createBatchFile(String batchFilePath) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(batchFilePath);
		writer.println("\"" + gamePath + "\"");
		writer.close();
	}

	private void load() throws IOException {
		validateDirectory(currentSaveSlotPath);
		if(!isEmptyDirectory(currentSaveSlotPath)) {// if not empty then it is an old player (load saveFiles)
			deleteFilesIn(defaultSavePath);
			copySaveFiles(currentSaveSlotPath, defaultSavePath);	
		}
	}
	
	private boolean isEmptyDirectory(String directoryPath) {
		File directory =  new File(directoryPath);
		if(directory.isDirectory() && directory.list().length == 0) {
		    return true;
		}
		return false;
	}

	private void save() throws IOException {
		validateDirectory(currentSaveSlotPath);
		deleteFilesIn(currentSaveSlotPath);
		copySaveFiles(defaultSavePath, currentSaveSlotPath);
		deleteFilesIn(defaultSavePath);
	}

	private void copySaveFiles(String source, String destination) throws IOException {
		File sourceDir = new File(source);
		for(File file: sourceDir.listFiles()) {
		    if (!file.isDirectory()) {
		    	Files.copy(file.toPath(), (new File(destination + "\\" + file.getName())).toPath(), StandardCopyOption.REPLACE_EXISTING);
		    }
		}
	}
	
	private void deleteFilesIn(String directoryPath) {
		File directory = new File(directoryPath);
		for(File file: directory.listFiles()) {
		    if (!file.isDirectory()) {
		        file.delete();
		    }
		}
	}
	
	private void validateDirectory(String directoryPath) {
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			directory.mkdirs();
		}	
	}
}
