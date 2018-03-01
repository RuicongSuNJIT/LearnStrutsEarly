package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownload extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4384469196935532848L;

	private String path;
	private String contentType;
	private String fileName;
	private InputStream targetFile;

	public void setPath(String path) {
		this.path = path;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getTargetFile() {
		return targetFile;
	}

	@Action(value = "download", results = {
			@Result(name = "success", type = "stream", params = { "contentType",
					"${contentType}", "inputName", "targetFile",
					"contentDisposition",
					"attachment;filename=\"${fileName}\"" }),
			@Result(name = "error", location="/error.jsp") })
	public String download() throws Exception {
		File file = new File("D:/JavaDevelopment/Data/" + path);
		if (!file.exists()) {
			return ERROR;
		}
		contentType = Files.probeContentType(file.toPath());
		String[] pathSplit = path.split("/");
		fileName = pathSplit[pathSplit.length - 1];
		fileName = new String(fileName.getBytes(),"iso-8859-1");
		targetFile = new FileInputStream(file);
		return SUCCESS;
	}

}
