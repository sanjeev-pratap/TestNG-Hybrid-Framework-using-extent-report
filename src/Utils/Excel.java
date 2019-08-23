package Utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;

public class Excel {


    public static Object[][] getBulkTestData(String path) throws Exception{
        Object[][] dataArray = null;
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int noOfRecords = sheet.getLastRowNum();
//        LinkedHashMap<String, String>[] dataArray = new LinkedHashMap[noOfRecords];

        Row headerRow = sheet.getRow(0);
        dataArray = new LinkedHashMap[noOfRecords][];
        try{
        for(int i = 1; i<= noOfRecords; i++){
            LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
            Row row = sheet.getRow(i);
            for(int j=0; j<=row.getLastCellNum(); j++){
                try{
                    data.put(headerRow.getCell(j).getStringCellValue(), row.getCell(j).getStringCellValue());
                }
                catch (NullPointerException e){
                    data.put("", "");
                }
            }
            dataArray[i-1] = new LinkedHashMap[]{data};
        }}
        catch (Exception e){
            System.out.println(e.toString());
        }

        return dataArray;
    }

    public static Object[][] getBulkTestDataExecutionFlag(String path) throws Exception{
        Object[][] dataArray = null;
        Object[][] dataArrayWithYesFlag = null;
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int noOfRecords = sheet.getLastRowNum();
//        LinkedHashMap<String, String>[] dataArray = new LinkedHashMap[noOfRecords];

        Row headerRow = sheet.getRow(0);
        dataArray = new LinkedHashMap[noOfRecords][];
        try{
            int count = 0;
            for(int i = 1; i<= noOfRecords; i++){
                LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
                Row row = sheet.getRow(i);
                for(int j=0; j<=row.getLastCellNum(); j++){
                    try{
                        data.put(headerRow.getCell(j).getStringCellValue(), row.getCell(j).getStringCellValue());
                    }
                    catch (NullPointerException e){
                        data.put("", "");
                    }
                }
                if(data.get("ExecutionFlag").equalsIgnoreCase("yes")){
                    dataArray[count] = new LinkedHashMap[]{data};
                    count++;
                }

            }

            dataArrayWithYesFlag = new LinkedHashMap[count][];
            for(int i= 0 ; i<dataArrayWithYesFlag.length; i++){
                dataArrayWithYesFlag[i] = dataArray[i];
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        fileInputStream.close();
        workbook.close();
        return dataArrayWithYesFlag;
    }

    public static Object[][] getBulkTestDataExecutionFlag(String path, String sheetName) throws Exception{
        Object[][] dataArray = null;
        Object[][] dataArrayWithYesFlag = null;
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int noOfRecords = sheet.getLastRowNum();
//        LinkedHashMap<String, String>[] dataArray = new LinkedHashMap[noOfRecords];

        Row headerRow = sheet.getRow(0);
        dataArray = new LinkedHashMap[noOfRecords][];
        try{
            int count = 0;
            for(int i = 1; i<= noOfRecords; i++){
                LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
                Row row = sheet.getRow(i);
                for(int j=0; j<=row.getLastCellNum(); j++){
                    try{
                        data.put(headerRow.getCell(j).getStringCellValue(), row.getCell(j).getStringCellValue());
                    }
                    catch (NullPointerException e){
                        data.put("", "");
                    }
                }
                if(data.get("ExecutionFlag").equalsIgnoreCase("yes")){
                    dataArray[count] = new LinkedHashMap[]{data};
                    count++;
                }

            }

            dataArrayWithYesFlag = new LinkedHashMap[count][];
            for(int i= 0 ; i<dataArrayWithYesFlag.length; i++){
                dataArrayWithYesFlag[i] = dataArray[i];
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        fileInputStream.close();
        workbook.close();
        return dataArrayWithYesFlag;
    }

    public static Object[][] getBulkTestDataByTestCaseName(String path, String sheetName, String testCaseName) throws Exception{
        Object[][] dataArray = null;
        Object[][] dataArrayWithYesFlag = null;
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int noOfRecords = sheet.getLastRowNum();
//        LinkedHashMap<String, String>[] dataArray = new LinkedHashMap[noOfRecords];

        Row headerRow = sheet.getRow(0);
        dataArray = new LinkedHashMap[noOfRecords][];
        try{
            int count = 0;
            for(int i = 1; i<= noOfRecords; i++){
                LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
                Row row = sheet.getRow(i);
                for(int j=0; j<=row.getLastCellNum(); j++){
                    try{
                        data.put(headerRow.getCell(j).getStringCellValue(), row.getCell(j).getStringCellValue());
                    }
                    catch (NullPointerException e){
                        data.put("", "");
                    }
                }
                if(data.get("ExecutionFlag").equalsIgnoreCase("yes") && data.get("TestCaseName").equalsIgnoreCase(testCaseName)){
                    dataArray[count] = new LinkedHashMap[]{data};
                    count++;
                }

            }

            dataArrayWithYesFlag = new LinkedHashMap[count][];
            for(int i= 0 ; i<dataArrayWithYesFlag.length; i++){
                dataArrayWithYesFlag[i] = dataArray[i];
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        fileInputStream.close();
        workbook.close();
        return dataArrayWithYesFlag;
    }
}
