package com.app.bo;
import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.File;

public interface FileBO {
	
	public List<File> getAllFiles();	
	public File createFile(File file);
	public void removeFileById(int id);
	public File getFileById(int id) throws BusinessException;
	public List<File> getFilesByName(String name) throws BusinessException;
	
}
