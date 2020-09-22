package DAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DaoFuncoes {
    public boolean stringNumerica(String cString){
        boolean lStringNumerica = true;
            
        for (int x = 0; x < cString.length(); x++){
            if (!cString.matches("[0-9]*")){
                lStringNumerica = false;
            } else {
                lStringNumerica = true;
            }
        }
        return lStringNumerica;
    }
    
    public LocalDate DataFormatoLocalDate(String data){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataString = LocalDate.parse(data, formato);
        
        return dataString;
    }
}
