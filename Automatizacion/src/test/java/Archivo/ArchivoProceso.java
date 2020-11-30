package Archivo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ArchivoProceso {
	
	public String ruta = "C:\\Users\\Diana\\eclipse-workspace\\Automatizacion\\Archivo\\";
	
	ArrayList<ArchivoRegistro> datos = new ArrayList<ArchivoRegistro>();

	public void leerArchivo(String Hoja) {

		String nombreArchivo = "Archivo.xlsx";
		String rutaArchivo = ruta + nombreArchivo;

		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			// leer archivo excel
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			// obtener la hoja que se va leer
			XSSFSheet sheet = worbook.getSheet(Hoja);
			// obtener todas las filas de la hoja excel
			Iterator<Row> rowIterator = sheet.iterator();
			Row row;
			// se recorre cada fila hasta el final
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				// se obtiene las celdas por fila
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				// se recorre cada celda
				while (cellIterator.hasNext()) {
					// se obtiene la celda en específico
					cell = cellIterator.next();
					// Creamos la instancia del la clase
					ArchivoRegistro data = new ArchivoRegistro();
					// Se asigna la linea a un arreglo de String
					String[] cortarString = cell.getStringCellValue().split(";");
					// Se setean los valores a la clase por medio de cada posicion
					data.setEmail(cortarString[1]);
					data.setFirtName(cortarString[3]);
					data.setLastName(cortarString[5]);
					data.setPassword(cortarString[7]);
					data.setFname(cortarString[9]);
					data.setLname(cortarString[11]);
					data.setAddres(cortarString[13]);
					data.setCity(cortarString[15]);
					data.setMobile(cortarString[17]);
					data.setState(cortarString[19]);
					data.setZipCode(cortarString[21]);
					data.setCountry(cortarString[23]);
					datos.add(data);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<ArchivoRegistro> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<ArchivoRegistro> datos) {
		this.datos = datos;
	}
}



