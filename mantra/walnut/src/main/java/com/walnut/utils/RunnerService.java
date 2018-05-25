package com.walnut.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class RunnerService {

	public static void run(String content, RunnerCallback runnerCallback) {

		try {

			File wd = new File("/bin");
			Process p = Runtime.getRuntime().exec("/bin/bash", null, wd);
			new Thread(new SyncPipe(p.getErrorStream(), System.err,runnerCallback)).start();
			new Thread(new SyncPipe(p.getInputStream(), System.out,runnerCallback)).start();
			PrintWriter stdin = new PrintWriter(p.getOutputStream());
			File file = new File("glot-code-runner-master/runner.go");
			stdin.println("/usr/local/go/bin/go run " + file.getAbsolutePath());
			stdin.println(content);
			// write any other commands you want here
			stdin.close();
			int returnCode = p.waitFor();
			System.out.println("Return code = " + returnCode);
		} catch (IOException e) {
			System.out.println("kjhajkdh");

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("kjhajkdh");

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class SyncPipe implements Runnable {

		RunnerCallback runnerCallback;

		public SyncPipe(InputStream istrm, OutputStream ostrm, RunnerCallback runnerCallback) {
			istrm_ = istrm;
			ostrm_ = ostrm;
			this.runnerCallback = runnerCallback;
		}

		public void run() {
			try {
				final byte[] buffer = new byte[1024];
				for (int length = 0; (length = istrm_.read(buffer)) != -1;) {
					ostrm_.write(buffer, 0, length);
					String string =  new String(buffer,0,length);
					runnerCallback.output(string);
					break;
				}
			

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("kjhajkdh");

			}
		}

		private final OutputStream ostrm_;
		private final InputStream istrm_;
	}

	public interface RunnerCallback {
		void output(String str);
	}

}
