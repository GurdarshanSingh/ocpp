package com.ocpp;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

public class ReaderUtil {

	public static List<ChargingData> getChargingData(String filePath) throws IOException, IntrospectionException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// String fileName = filePath;

		String fileName = System.getProperty("user.home")+"/data.csv";
		Path myPath = Paths.get(fileName);
		List<ChargingData> listCharging = new ArrayList<ChargingData>();

		try (BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8)) {

			HeaderColumnNameMappingStrategy<ChargingData> strategy = new HeaderColumnNameMappingStrategy<ChargingData>();
			strategy.setType(ChargingData.class);

			CsvToBean csvToBean = new CsvToBeanBuilder(br).withType(ChargingData.class).withMappingStrategy(strategy)
					.withIgnoreLeadingWhiteSpace(true).build();

			listCharging = csvToBean.parse();

			ChargingData bean = listCharging.get(0);
			BeanInfo beanInfo = Introspector.getBeanInfo(ChargingData.class);
			for (PropertyDescriptor propertyDesc : beanInfo.getPropertyDescriptors()) {
				String propertyName = propertyDesc.getName();
				Object value = propertyDesc.getReadMethod().invoke(bean);
				System.out.println(propertyName + "--" + value);
			}

		}

		return listCharging;
	}
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, IntrospectionException {
		
		//System.out.println(ReaderUtil.getChargingData(""));
		System.out.println(ReaderUtil.getChargingData(""));
	}

}
