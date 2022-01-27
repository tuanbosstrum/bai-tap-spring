package com.blog.springmvc.core;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public class Render {

	public String View() {
		return "layouts/site";
	}

	public String View(String site) {
		return "layouts/" + site;
	}

	public void SetPage(Model model, String title, String page) {
		model.addAttribute("title", title);
		model.addAttribute("page", page);
	}

	public void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
		
		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
		}
	}
}
