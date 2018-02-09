package ao.sting.aearp.storage;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoStorage {

	public String saveTemporarily(MultipartFile[] files);

	public byte[] takeTemporaryPhoto(String name);
	
	public void save(String photo);

	public byte[] take(String photo);
	
	public byte[] takeThumbnail(String photo);

	public void delete(String photo);
	
	
}
