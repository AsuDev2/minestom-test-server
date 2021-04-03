package com.example.server.anvil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import net.minestom.server.storage.StorageOptions;
import net.minestom.server.storage.StorageSystem;

public class FileSystemStorage implements StorageSystem {
	
	private static final boolean readOnly = true;
	
    @Override
    public void open(String folderPath, StorageOptions options) {}

    @Override
    public void close() {}

    @Override
    public boolean exists(String folderPath) {
        return Files.exists(Path.of(folderPath));
    }

    @Override
    public byte[] get(String key) {
        try {
            Path path = getPath(key);
            if(!Files.exists(path)) {
                return null;
            }
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Path getPath(String key) {
        return Path.of(key+".dat");
    }

    @Override
    public void set(String key, byte[] data) {
    	if (!readOnly)
	        try {
	            Files.write(getPath(key), data);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
    }

    @Override
    public void delete(String key) {
    	if (!readOnly)
	        try {
	            Files.delete(getPath(key));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
    }
}
