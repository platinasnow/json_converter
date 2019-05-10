package json_converter.main;

import java.text.ParseException;
import java.util.List;

import json_converter.dto.AsIsSms;
import json_converter.dto.SmsType3;
import json_converter.service.JsonService;

public class Main {

	private static final String FILE_PATH = "C:\\Users\\Sanghak\\Documents\\";
	private static final String FILE_NAME = "test3"; 
	private static final String FILE_TYPE = ".json";
	
	public static void main(String[] args) throws ParseException {
		JsonService jsonService = new JsonService();
		AsIsSms[] list = jsonService.loadJson(FILE_PATH+ FILE_NAME+FILE_TYPE);
		//List<SmsType2> type2List = jsonService.convertType2(list);
		//jsonService.writeJson(FILE_PATH+FILE_NAME+"_convert"+FILE_TYPE, type2List);
		
		
		List<SmsType3> type3List = jsonService.convertType3(list);
		jsonService.writeJson(FILE_PATH+FILE_NAME+"_convert"+FILE_TYPE, type3List);
		
		
	
		System.out.println("end");
	}

}

