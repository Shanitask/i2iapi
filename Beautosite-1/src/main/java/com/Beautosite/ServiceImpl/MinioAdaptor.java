package com.Beautosite.ServiceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.messages.Bucket;
import io.minio.messages.Tags;

@Service
public class MinioAdaptor {

	@Autowired
    MinioClient minioClient;

    @Value("${spring.minio.bucket}")
    String defaultBucketName;

    @Value("${minio.default.folder}")
    String defaultBaseFolder;

    public List<Bucket> getAllBuckets() {
        try {
            return minioClient.listBuckets();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
 
	public void uploadFile(String name, byte[] content) {
        File file = new File("" + name);
        file.canWrite();
        file.canRead();
        try {
            FileOutputStream iofs = new FileOutputStream(file);
            iofs.write(content);
            minioClient.uploadObject(
            	    UploadObjectArgs.builder()
            	        .bucket("beautosite").object(name).filename(file.getAbsolutePath()).build());
        } catch (Exception e) {
           throw new RuntimeException(e.getMessage());
        }

    }
	public byte[] getFile(String key) {
		try {
			InputStream stream = minioClient.getObject(
				  GetObjectArgs.builder()
				  .bucket("beautosite")
				  .object(key)
				  .build());
			byte[] content = IOUtils.toByteArray(stream);
			stream.close();
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //defaultBucketName, defaultBaseFolder + name, file.getAbsolutePath())

}
