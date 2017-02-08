package iostreams;

import java.io.File;
import java.nio.file.*;

public class ShowFileTree {

	public static void main(String[] args) {
		File[] roots = File.listRoots();
		for (int i = 0; i < roots.length; i++) {
			File file = roots[i];
			findAllFiles(file);
		}
	}

	private static int fileCount = 0;

	// 遍历盘符中所有的文件
	private static void findAllFiles(File file) {
		if (fileCount == 100)
			return;
		if (!file.isDirectory()) {
			System.out.println(file.getName());
			fileCount++;
		} else {
			File[] childFile = file.listFiles();
			if (childFile != null)
				for (int i = 0; i < childFile.length; i++) {
					findAllFiles(childFile[i]);
				}
		}
		System.out.println(file.getName() + "has" + fileCount + "files");
	}

}
