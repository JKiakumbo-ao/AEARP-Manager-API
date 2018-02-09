package ao.sting.aearp.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import ao.sting.aearp.dto.PhotoDTO;

public class PhotoStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<PhotoDTO> result;
	private PhotoStorage photoStorage;
	
	public PhotoStorageRunnable(MultipartFile[] files, DeferredResult<PhotoDTO> resultado, PhotoStorage fotoStorage) {
		this.files = files;
		this.result = resultado;
		this.photoStorage = fotoStorage;
	}

	@Override
	public void run() {
		String photoName = this.photoStorage.saveTemporarily(files);
		String contentType = files[0].getContentType();
		result.setResult(new PhotoDTO(photoName, contentType));
}
}
