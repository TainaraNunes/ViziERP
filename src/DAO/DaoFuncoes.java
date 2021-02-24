package DAO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    
    public LocalDate StringParaLocalDate(String data){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataString = LocalDate.parse(data, formato);
        
        return dataString;
    }
    
    public BigDecimal StringParaBigDecimal(String valor){
        String valorString = valor.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        BigDecimal valorBigDecimal = new BigDecimal(valorString);
        
        return valorBigDecimal;
    }    
}
