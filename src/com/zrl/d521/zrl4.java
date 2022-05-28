import javax.annotation.processing.Filer;
import javax.jws.soap.SOAPBinding;
import java.io.*;

public class zrl4 {
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.err.println("usage: java txtcp souse_file target_file");
			return;
		}
		BufferedReader bf = new BufferedReader(new FileReader(args[0]));
		String s = args[1];
		String c;
		Integer cnt = 0;
		boolean cpr = true;

		while ((c = bf.readLine()) != null) {
			String[] al = c.split(" ");
			for (String value : al) {
				String res = value;
				while (res.contains(s)) {
					res = res.substring(res.indexOf(s) + 1);
					++cnt;
				}
			}
		}
		System.out.println(cnt);
		System.out.println("end");
		bf.close();
	}
}
