package com.student.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.student.service.ExportService;
@Service
public class ExportServiceImpl implements ExportService {

	public boolean export(String json) {
		
		
		try {
			FileWriter fileWriter=new FileWriter("f:\\grade.txt", false);
			BufferedWriter bWriter=new BufferedWriter(fileWriter);
			bWriter.write(json);
			bWriter.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}

	public boolean exportInfo(String json) {
		try {
			FileWriter fileWriter=new FileWriter("f:\\StudentInfo.txt", false);
			BufferedWriter bWriter=new BufferedWriter(fileWriter);
			bWriter.write(json);
			bWriter.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}

}
