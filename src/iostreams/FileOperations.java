package iostreams;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Charset charset = Charset.forName("US-ASCII");
		// String s = "hello word.";
		// // the compiler automatically generates the code to close the
		// resource(s) when no longer required
		// try (BufferedWriter writer =
		// Files.newBufferedWriter(Paths.get("out.txt"), charset)) {
		// writer.write(s, 0, s.length());
		// } catch (IOException x) {
		// System.err.format("IOException: %s%n", x);
		// }

		Path file = Paths.get("out.txt");
		System.out.println(Files.isRegularFile(file));
		System.out.println(Files.isReadable(file));
		System.out.println(Files.isExecutable(file));
		Path file2 = Paths.get("in.txt");
		System.out.println(Files.isSameFile(file, file2));

		// Files.delete(path);
		// copy, move

		// Read and Write by bytes
		// Path file = ...;
		// byte[] fileArray;
		// fileArray = Files.readAllBytes(file);
		// Path file = ...;
		// byte[] buf = ...;
		// Files.write(file, buf);

		// Read and Write by Buffered Stream I/O
		// Charset charset = Charset.forName("US-ASCII");
		// try (BufferedReader reader = Files.newBufferedReader(file, charset))
		// {
		// String line = null;
		// while ((line = reader.readLine()) != null) {
		// System.out.println(line);
		// }
		// } catch (IOException x) {
		// System.err.format("IOException: %s%n", x);
		// }
		//
		// Charset charset = Charset.forName("US-ASCII");
		// String s = ...;
		// try (BufferedWriter writer = Files.newBufferedWriter(file, charset))
		// {
		// writer.write(s, 0, s.length());
		// } catch (IOException x) {
		// System.err.format("IOException: %s%n", x);
		// }

		// Read and Write by UnBuffered Stream I/O
		// Path file = ...;
		// try (InputStream in = Files.newInputStream(file);
		// BufferedReader reader =
		// new BufferedReader(new InputStreamReader(in))) {
		// String line = null;
		// while ((line = reader.readLine()) != null) {
		// System.out.println(line);
		// }
		// } catch (IOException x) {
		// System.err.println(x);
		// }
		// // Convert the string to a
		// // byte array.
		// String s = "Hello World! ";
		// byte data[] = s.getBytes();
		// Path p = Paths.get("./logfile.txt");
		//
		// try (OutputStream out = new BufferedOutputStream(
		// Files.newOutputStream(p, CREATE, APPEND))) {
		// out.write(data, 0, data.length);
		// } catch (IOException x) {
		// System.err.println(x);
		// }

		// Channel I/O
		// Temporary Files
	}

}
