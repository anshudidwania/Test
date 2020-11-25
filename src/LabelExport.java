import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LabelExport {


	public static void main(String[] args) {
		List<Record> totalList = new ArrayList<Record>();
		Record header = new Record();
		header.labelName = "LABEL_KEY";
		header.keepLabel=true;
		header.compName = "COMPONENT";
		header.listlVals = new ArrayList<String>();
		
		//int[] genLang = {1,2,3,9,20};
		//int[] genLang = {1,3,9,20};
		int[] genLang = {1};
		//String[] genHeader = {"GEN EN", "GEN AR", "GEN DE", "GEN IT", "GEN FR"};
		//String[] genHeader = {"GEN EN", "GEN DE", "GEN IT", "GEN FR"};
		String[] genHeader = {"EN"};
		
		//int[] brdLangSeq = {1, 1, 1, 9, 1, 1, 2, 1, 3, 9, 20, 1, 3, 9, 20};
		//String[] brdPrgSeq = {"ETH", "JPREX", "MMBS", "MMBS", "DDREX", "ODREX", "ODREX", "SCCRREX", "SCCRREX", "SCCRREX", "SCCRREX", "SCMRREX", "SCMRREX", "SCMRREX", "SCMRREX"};
		//String[] brdPrgHead = {"ETH EN", "JPREX EN", "MMBS EN", "MMBS IT", "DDREX EN", "ODREX EN", "ODREX AR", "SCCR EN", "SCCR DE", "SCCR IT", "SCCR FR", "SCMR EN", "SCMR DE", "SCMR IT", "SCMR FR"};
		
		//int[] brdLangSeq = {1, 3, 9, 20};
		//String[] brdPrgSeq = {"SCCRREX", "SCCRREX", "SCCRREX", "SCCRREX"};
		//String[] brdPrgHead = {"SCCR EN", "SCCR DE", "SCCR IT", "SCCR FR"};
		
		int[] brdLangSeq = {};
		String[] brdPrgSeq = {};
		String[] brdPrgHead = {};
		
		String labelKeysFile = "D:\\Work\\LabelKeys_lessLangValues.txt";
		HashMap<String, String> map = new HashMap<String, String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(labelKeysFile))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       map.put(line, line);
		    }
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try
		{
			String genMQuery = "select A.label_name, B.component_name from rex_label_mst A, rex_component_mst B, rex_component_label C where A.label_id=C.LABEL_ID and B.COMPONENT_ID=C.COMPONENT_ID order by 1";
			String genQuery = "select A.label_name, coalesce(D.label_value, '') from rex_label_mst A left join rex_label_loc_info D on A.label_id=D.label_id and D.lang_id=? order by 1";
			String brdQuery = "select A.label_name, coalesce(D.label_value, '') from rex_label_mst A left join rex_label_branded_info D on A.label_id=D.label_id and D.lang_id=? and D.prg_id=? order by 1";
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("org.postgresql.Driver");
			// EUMRT_FAT
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@172.30.1.102:1521:LLPORCL","EUMRT_FAT","jETk8nZW");
			// PROD
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@94.103.24.137:1521:DB02PROD","LL_MRT_EU_RD","s34jBr2kQzwskgF28rUX");
			String url = "jdbc:postgresql://postgres-prod.c1wbwqpbzaeq.eu-west-1.rds.amazonaws.com:6590/postgres_prod?user=loylogic_dev&password=igjOr0am&ssl=false";
			//String url = "jdbc:postgresql://postgres-uat.c1wbwqpbzaeq.eu-west-1.rds.amazonaws.com:5432/postgres_uat?user=postgres&password=9aDDuWNWCyic2hD&ssl=false";
			Connection con = DriverManager.getConnection(url);
			//Connection con=DriverManager.getConnection("jdbc:postgresql:// server-name : server-port / database-name Note – NOTE: Default server port is 5432.");
			
			PreparedStatement stmtM=con.prepareStatement(genMQuery);
			
			ResultSet rs=stmtM.executeQuery();
			
			while(rs.next())  {
				Record r = new Record();
				r.labelName = rs.getString(1);
				//map.put(r.labelName, r.labelName);
				//if(map.containsKey(r.labelName)) {
				//	r.keepLabel=true;
				//}
				
				r.keepLabel=true;
				r.compName = rs.getString(2);
				r.listlVals = new ArrayList<String>();
				totalList.add(r);
			}

			System.out.println("Total languages = " + genLang.length);
			System.out.println("Languages = " + genLang);
			
			System.out.println("Total labels = " + totalList.size());
			PreparedStatement stmt=con.prepareStatement(genQuery);
			
			for(int x=0;x<genLang.length;x++) 
			{
				header.listlVals.add(genHeader[x]);				
				int cnt=0;
				stmt.setInt(1, genLang[x]);
				//step4 execute query  
				ResultSet rs1=stmt.executeQuery();  
				while(rs1.next())  {
					Record rr = totalList.get(cnt++);
					rr.listlVals.add(rs1.getString(2));
				}
			}
			
			System.out.println("Generated generic Labels");
//			PreparedStatement stmt2=con.prepareStatement(brdQuery);
//			
//			for(int x=0;x<brdLangSeq.length;x++) 
//			{
//				header.listlVals.add(brdPrgHead[x]);				
//				int cnt=0;
//				stmt2.setInt(1, brdLangSeq[x]);
//				stmt2.setString(2, brdPrgSeq[x]);
//				//step4 execute query  
//				ResultSet rs2=stmt2.executeQuery();  
//				while(rs2.next())  {
//					Record rr = totalList.get(cnt++);
//					rr.listlVals.add(rs2.getString(2));
//				}
//			}
//			System.out.println("Generated branded Labels");

			//step5 close the connection object  
			con.close();
			
			
			}catch(Exception e){ 
				e.printStackTrace();
			}  

			
		Map<String, XSSFSheet> sheetMap = new HashMap<>();
		Map<String, Integer> sheetRowCountMap = new HashMap<>();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = null;//workbook.createSheet("REx Labels");
 
        int rowCount = -1;
        totalList.add(0, header); 
        for (Record rec : totalList) {
        	if(!rec.keepLabel) continue;
        	
        	String compName = rec.compName;
        	
        	if(sheetMap.get(compName) == null) {
        		sheetMap.put(compName, workbook.createSheet(compName));
        		sheetRowCountMap.put(compName,  new Integer(0));
        		addHeader(sheetMap.get(compName), header);
        	}
        	
        	sheet = sheetMap.get(compName);
        	rowCount = sheetRowCountMap.get(compName);
        	
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = -1;
             
            //for (Object field : rec) {
            Cell cell = row.createCell(++columnCount);
            cell.setCellValue((String) rec.labelName);
            sheet.setColumnWidth(0, 12000);
            
            //Cell cell1 = row.createCell(++columnCount);
            //cell1.setCellValue((String) rec.compName);
            //sheet.setColumnWidth(1, 12000);

            for(int x=0;x<rec.listlVals.size();x++) {
            	sheet.setColumnWidth(x+1, 15000);
            } 
            
            for(int x=0;x<rec.listlVals.size();x++) {
            	Cell cell2 = row.createCell(++columnCount);
            	cell2.setCellValue((String) rec.listlVals.get(x));
            	
            	CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
            	cellStyle.setWrapText(true);
            	
            	cell2.setCellStyle(cellStyle);
            }
            
            sheetRowCountMap.put(compName,  rowCount);
        }
         
        System.out.println("Excel Objects created. Total components = " + sheetMap.size());
        
        try (FileOutputStream outputStream = new FileOutputStream("D:\\Work\\LABEL_EXPORT\\THAI_Labels_LANGS.xlsx", false)) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void addHeader(XSSFSheet sheet, Record header) {
		 Row row = sheet.createRow(0);
         
         int columnCount = -1;
          
         //for (Object field : rec) {
         Cell cell = row.createCell(++columnCount);
         cell.setCellValue((String) header.labelName);
         sheet.setColumnWidth(0, 12000);
         
         //Cell cell1 = row.createCell(++columnCount);
         //cell1.setCellValue((String) rec.compName);
         //sheet.setColumnWidth(1, 12000);

         for(int x=0;x<header.listlVals.size();x++) {
         	sheet.setColumnWidth(x+1, 15000);
         } 
         
         for(int x=0;x<header.listlVals.size();x++) {
         	Cell cell2 = row.createCell(++columnCount);
         	cell2.setCellValue((String) header.listlVals.get(x));
         	
         	CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
         	cellStyle.setWrapText(true);
         	
         	cell2.setCellStyle(cellStyle);
         }		
	}

}

class Record
{
	public String labelName;
	public String compName;
	public boolean keepLabel;
	public List<String> listlVals;
	
}