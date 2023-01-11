package com.traditional.yoga.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@Service
public class FileUploadservice {

	private static final Logger LOG = LoggerFactory.getLogger(FileUploadservice.class);

	@Autowired
	AmazonS3 s3Client;

//	@Autowired
//	StrogaeConfig strogaeConfig;

	@Value("${application.bucket.name}")
	private String bucketName;

	public void uploadFile(MultipartFile file) {

		File fileobj = convertMultipartFileToFile(file);

		String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileobj));

		fileobj.delete();
	}

	public String uploadMultipleFile(List<MultipartFile> multipartfiles) {

		if (!multipartfiles.isEmpty()) {
			multipartfiles.forEach(multipartfile -> {
				String filePathName = multipartfile.getOriginalFilename();
				File file = convertMultipartFileToFile(multipartfile);

				String fileName = System.currentTimeMillis() + "_" + filePathName;
				s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
				file.delete();
			});
			return "File Uplaod :";
		}

		return null;
	}

	private File convertMultipartFileToFile(MultipartFile multipartFile) {
		File file = new File(multipartFile.getOriginalFilename());
		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public byte[] downloadFile(String fileName) {
		S3Object s3Object = s3Client.getObject(bucketName, fileName);
		S3ObjectInputStream inputStream = s3Object.getObjectContent();
		try {
			byte[] content = IOUtils.toByteArray(inputStream);
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
