package action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpload extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -79070811354184957L;

	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private long fileSize;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Action(value = "fileUpload", interceptorRefs = {
			@InterceptorRef(value = "fileUpload", params = { "allowedTypes",
					"image/*" }),
			@InterceptorRef(value = "defaultStack") }, results = {
					@Result(name = "success", location = "/succFileUpload.jsp"),
					@Result(name = "input", location = "/fileUpload.jsp") })
	public String fileUpload() throws Exception {
		setFileSize(upload.length());

		return SUCCESS;
	}
}
