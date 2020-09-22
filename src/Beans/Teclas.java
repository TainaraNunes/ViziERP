package Beans;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Teclas extends PlainDocument{
    
    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet atr)
        throws BadLocationException{
            super.insertString(offset, str.toUpperCase(), atr);
    }
}
