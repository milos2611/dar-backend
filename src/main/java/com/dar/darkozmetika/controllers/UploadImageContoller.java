package com.dar.darkozmetika.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dar.darkozmetika.models.CategoryModel;
import com.dar.darkozmetika.models.FileUploadDto;
import com.dar.darkozmetika.repository.CategoryRepository;
import com.dar.darkozmetika.services.FileStorageService;

@RestController
@RequestMapping("api/upload/image")
public class UploadImageContoller {

	CategoryModel ct;
	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	private CategoryRepository categoryRepository;

	/*
	 * @PostMapping("/uploadFile") public String uploadFile(@RequestParam("file")
	 * MultipartFile file) { String fileName = fileStorageService.storeFile(file);
	 * 
	 * String fileDownloadUri =
	 * ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
	 * .path(fileName).toUriString();
	 * 
	 * return fileName;// new UploadFileResponse(fileName, fileDownloadUri,
	 * file.getContentType(), // file.getSize()); }
	 */

	@PostMapping(consumes = {  "multipart/form-data" } )
	public void uploadFile(@ModelAttribute FileUploadDto fileUploadDto) {
		// logger.info("File upladed, category= {}, fileSize = {} bytes",
		// fileUploadDto.getCategory(), fileUploadDto.getFile().getSize());

		// this.fileStorageService.storeFile(fileUploadDto.getFile());
		System.out.println(fileUploadDto.getCategory().getCategory_name());

		// this.categoryRepository.save(fileUploadDto.getCategory().getCategory_name());
	}

	@PostMapping("/deleteImage")
	public void deleteImage(@RequestParam String deleteModel_) {
		System.out.println(deleteModel_);

		this.fileStorageService.deleteImage(deleteModel_);
	}

}
