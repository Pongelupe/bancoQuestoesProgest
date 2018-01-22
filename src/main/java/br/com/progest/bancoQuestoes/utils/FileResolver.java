package br.com.progest.bancoQuestoes.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileResolver {

	@Autowired
	private HttpServletRequest request;

	public String write(String folder, MultipartFile foto) {
		try {
			String realPath = request.getServletContext().getRealPath(folder);
			new File(realPath).mkdir();
			String agora = System.currentTimeMillis() + "";
			String extensao = "." + foto.getOriginalFilename().split("\\.")[1];
			foto.transferTo(new File(realPath + "/" + agora + extensao));

			return folder + "/" + agora + extensao;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
