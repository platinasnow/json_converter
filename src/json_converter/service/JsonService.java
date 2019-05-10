package json_converter.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import json_converter.dto.AsIsSms;
import json_converter.dto.SmsType2;
import json_converter.dto.SmsType3;
import json_converter.dto.cust;
import json_converter.dto.datas;

public class JsonService {

	public AsIsSms[] loadJson(String filePath) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			AsIsSms[] list = mapper.readValue(new FileReader(filePath), AsIsSms[].class);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SmsType2> convertType2(AsIsSms[] list) throws ParseException {
		List<SmsType2> type2List = new ArrayList<SmsType2>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (AsIsSms item : list) {
			SmsType2 type2 = new SmsType2();
			type2.setBoard_idx(this.parseIntIfNotNull(item.getBoard_idx()));
			type2.setReg_date(sdf.parse(item.getReg_date()));
			type2.setSale_man_cd(item.getSale_man_cd());

			List<cust> custList = new ArrayList<cust>();
			if(item.getCust_seq() != null) {
				String[] custSeqs = item.getCust_seq().split(",");
				String[] hphones = item.getHphone().split(",");
				if(custSeqs.length != hphones.length) {
					System.out.println(item);
					return null;
				}
				for (int i = 0, size = custSeqs.length; i < size; i++) {
					cust custItem = new cust();
					custItem.setCust_seq(this.parseIntIfNotNull(custSeqs[i]));
					custItem.setHphone(hphones[i]);
					custList.add(custItem);
				}
				type2.setCust(custList);
			}
			type2List.add(type2);
		}
		return type2List;
	}
	
	public List<SmsType3> convertType3(AsIsSms[] list) throws ParseException {
		List<SmsType3> type3List = new ArrayList<SmsType3>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (AsIsSms item : list) {
			SmsType3 type3 = new SmsType3();
			type3.setSale_man_cd(item.getSale_man_cd());

			List<datas> dataList = new ArrayList<datas>();
			if(item.getCust_seq() != null) {
				String[] custSeqs = item.getCust_seq().split(",", -1);
				String[] hphones = item.getHphone().split(",", -1);
				String[] regDates = item.getReg_date().split(",", -1);
				String[] boardIdxs = item.getBoard_idx().split(",", -1);
				if(custSeqs.length != hphones.length || hphones.length != regDates.length || regDates.length != boardIdxs.length ) {
					System.out.println(item.getSale_man_cd());
					System.out.println("custSeqs.length : " + custSeqs.length);
					System.out.println("hphones.length : " + hphones.length);
					System.out.println("regDates.length : " + regDates.length);
					System.out.println("boardIdxs.length : " + boardIdxs.length);
					return null;
				}
				for(int i = 0, size = custSeqs.length; i < size; i++) {
					datas dataItem = new datas();
					dataItem.setBoard_idx(this.parseIntIfNotNull(boardIdxs[i]));
					dataItem.setCust_seq(this.parseIntIfNotNull(custSeqs[i]));
					dataItem.setHphone(hphones[i]);
					dataItem.setReg_date(sdf.parse(regDates[i]));
					dataList.add(dataItem);
				}
				type3.setDatas(dataList);
			}
			type3List.add(type3);
		}
		return type3List;
	}
	
	private Integer parseIntIfNotNull(String num) {
		if(num != null && !"".equals(num)){
			return Integer.parseInt(num);
		}
		return null;
	}
	
	
	public <T> void writeJson(String filePath, List<T> list) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(filePath), list);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
