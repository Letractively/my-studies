package br.com.mystudies.niotwo;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;

public class ScannerPath implements Runnable{


	private boolean scan;


	private List<Path> paths = new ArrayList<>();


	private WatchService watchService;



	public void scan(Path path) throws IOException, InterruptedException {

		watchService =
				FileSystems.getDefault().newWatchService();


		/*WatchKey watchKey =*/
				path.register(watchService, ENTRY_CREATE);


		scan = true;


		new Thread(this).start();

	}


	public void stopScan() {
		scan = false;
		System.out.println("stoping scan");
	}


	public List<Path> getNewFiles() {
		return paths;
	}



	@SuppressWarnings("unchecked")
	@Override
	public void run() {


		System.out.println("starting scan");


		while (scan) {

			WatchKey watchKey = null;

			try {
				watchKey = watchService.take();
				System.out.println("getting new file...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			List<WatchEvent<?>> watchEvents =
					watchKey.pollEvents();

			for (WatchEvent<?> watchEvent : watchEvents) {

				WatchEvent<Path> ev = (WatchEvent<Path>) watchEvent;

				paths.add(ev.context());

			}
			watchKey.reset();
		}

	}

}
