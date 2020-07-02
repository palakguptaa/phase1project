package com.app.bo.impl;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.app.bo.FileBO;
import com.app.exception.BusinessException;
import com.app.model.File;

public class FileBOImpl implements FileBO {
	
	private static Map<Integer, File> fileMap=new TreeMap<>();
	private static int count=0;

	@Override
	public List<File> getAllFiles() {
		List<File> fileList= new ArrayList<>(fileMap.values());
		return fileList;
	}

	@Override
	public File createFile(File file){
		file.setId(++count);
		fileMap.put(file.getId(), file);		
		return file;
	}

	@Override
	public void removeFileById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public File getFileById(int id) throws BusinessException {
		File file=null;
		if(fileMap.containsKey(id)) {
			file=fileMap.get(id);			
		}
		else {
			throw new BusinessException("File with id"+id+"not found");
		}
		return file;
	}

	@Override
	public List<File> getFilesByName(String name) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
