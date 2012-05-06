package vo;

import java.util.Calendar;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *
 * @author Daniel
 */
public class FaturaTelefonicaVO {
    
    private int mes;
    
    private int ano;
    
    private Calendar vencimento;

    public FaturaTelefonicaVO(Calendar vencimento) {
        super();
        this.mes = Calendar.getInstance().get(Calendar.MONTH);
        this.ano = Calendar.getInstance().get(Calendar.YEAR);
        this.vencimento = vencimento;
    }  

    public FaturaTelefonicaVO(int mes, int ano, Calendar vencimento) {
        super();
        this.mes = mes;
        this.ano = ano;
        this.vencimento = vencimento;
    }
    
    public FaturaTelefonicaVO(Calendar mesAno, Calendar vencimento){
        super();
        this.mes = mesAno.get(Calendar.MONTH);
        
        /*	
         * Não precisa do - 1900, o problema é na classe Calendar.
         * A classe Calendar retorna o ano correto. 
         * this.ano = cal.get(Calendar.YEAR) - 1900;
         */
        
        this.ano = mesAno.get(Calendar.YEAR);
        this.vencimento = vencimento;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setAno(int ano) throws VOException {
        if(ano > 0 && ano <= 9999) this.ano = ano;
        else this.ano = Calendar.getInstance().get(Calendar.YEAR);        
    }

    public void setMes(int mes) {
        if(mes >= 1 && mes <= 12) this.mes = mes;
        else this.mes = Calendar.getInstance().get(Calendar.MONTH);
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }
}
