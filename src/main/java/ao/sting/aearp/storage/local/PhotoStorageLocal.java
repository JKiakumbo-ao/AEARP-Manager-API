package ao.sting.aearp.storage.local;

import static java.nio.file.FileSystems.getDefault;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import ao.sting.aearp.storage.PhotoStorage;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;


public class PhotoStorageLocal implements PhotoStorage {

	private static final Logger logger = LoggerFactory.getLogger(PhotoStorageLocal.class);
	private static final String THUMBNAIL_PREFIX = "thumbnail.";

	private Path local;
	private Path localTemporary;

	public PhotoStorageLocal() {
		this(getDefault().getPath(System.getenv("HOME"), ".sgestorPhotos"));
	}

	public PhotoStorageLocal(Path path) {
		this.local = path;
		createFolder();
	}

	@Override
	public String saveTemporarily(MultipartFile[] files) {
		String newName = null;
		if (files != null && files.length > 0) {
			MultipartFile arquivo = files[0];
			newName = renameFile(arquivo.getOriginalFilename());
			try {
				arquivo.transferTo(new File(
						this.localTemporary.toAbsolutePath().toString() + getDefault().getSeparator() + newName));
			} catch (IOException e) {
				throw new RuntimeException("Error to save the photo in temporary folder", e);
			}
		}

		return newName;
	}
	
	@Override
	public byte[] takeTemporaryPhoto(String name) {
		try {
			return Files.readAllBytes(this.localTemporary.resolve(name));
		} catch (IOException e) {
			throw new RuntimeException("Erro lendo a foto temporária", e);
		}
	}

	private void createFolder() {
		try {
			Files.createDirectories(this.local);
			this.localTemporary = getDefault().getPath(this.local.toString(), "temp");
			Files.createDirectories(this.localTemporary);

			if (logger.isDebugEnabled()) {
				logger.debug("Folder created for save photos.");
				logger.debug("Default folder: " + this.local.toAbsolutePath());
				logger.debug("Temporary folder: " + this.localTemporary.toAbsolutePath());
			}
		} catch (IOException e) {
			throw new RuntimeException("Error to create folder for save photo", e);
		}
	}

	private String renameFile(String originalName) {
		String newName = UUID.randomUUID().toString() + "_" + originalName;

		if (logger.isDebugEnabled()) {
			logger.debug(String.format("Original name: %s, new name: %s", originalName, newName));
		}

		return newName;

	}

	@Override
	public void save(String photo) {
		try {
			Files.move(this.localTemporary.resolve(photo), this.local.resolve(photo));
		} catch (IOException e) {
			throw new RuntimeException("Error for moving photo to destination", e);
		}
		
		try {
			Thumbnails.of(this.local.resolve(photo).toString()).size(40, 68).toFiles(Rename.PREFIX_DOT_THUMBNAIL);
		} catch (IOException e) {
			throw new RuntimeException("Error for generate thumbnail", e);
		}
		
	}

	@Override
	public byte[] take(String photo) {
		try {
			return Files.readAllBytes(this.local.resolve(photo));
		} catch (IOException e) {
			throw new RuntimeException("Error for load photo", e);
		}
	}

	@Override
	public byte[] takeThumbnail(String photo) {
		return take(THUMBNAIL_PREFIX + photo);
	}

	@Override
	public void delete(String photo) {
		try {
			Files.deleteIfExists(this.local.resolve(photo));
			Files.deleteIfExists(this.local.resolve(THUMBNAIL_PREFIX + photo));
		} catch (IOException e) {
			logger.warn(String.format("Error for deleting Photo '%s'. Mensage: %s", photo, e.getMessage()));
		}
		
	}
	
	
}
