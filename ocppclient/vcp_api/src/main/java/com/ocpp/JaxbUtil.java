package com.ocpp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

public class JaxbUtil
{
   @SuppressWarnings("unchecked")
   public static <T> T load(String path, Class<T> clazz) throws Exception
   {
      JAXBContext jaxbContext = null;
      InputStream inputStream = null;
      try
      {
         inputStream = new FileInputStream(path);
         if (inputStream == null)
         {
            throw new Exception("File Missing");
         }
         jaxbContext = JAXBContext.newInstance(clazz.getPackage().getName());
         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         JAXBElement<?> jaxbElementProtection = (JAXBElement<?>)unmarshaller.unmarshal(inputStream);
         Object obj = jaxbElementProtection.getValue();
         return (T)obj;
      }
      
      finally
      {
         if (inputStream != null)
         {
            try
            {
               inputStream.close();
            }
            catch (IOException e)
            {
               e.printStackTrace();
            }
         }
      }
   }
}
