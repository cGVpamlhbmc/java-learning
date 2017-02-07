package IOStreams;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DicOperate {
	public static void main(String[] args) throws IOException {
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path name : dirs) {
			System.out.println(name);
		}

		Files.createDirectories(Paths.get("foo/bar/test"));

		Path dir = Paths.get("");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir,"*.{txt}")) {
			for (Path file : stream) {
				System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can only be thrown by newDirectoryStream.
			System.err.println(x);
		}
		
	}
}
