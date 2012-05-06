package vo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 *
 * @author Daniel
 */
public class FaturaTelefonicaVO {
    
    private int mes;
    
    private int ano;
    
    private Date vencimento;

    public FaturaTelefonicaVO(Date vencimento) {
        super();
        this.mes = Calendar.getInstance().get(Calendar.MONTH);
        this.ano = Calendar.getInstance().get(Calendar.YEAR);
        this.vencimento = vencimento;
    }  

    public FaturaTelefonicaVO(int mes, int ano, Date vencimento) {
        super();
        this.mes = mes;
        this.ano = ano;
        this.vencimento = vencimento;
    }
    
    public FaturaTelefonicaVO(Date mesAno, Date vencimento){
        super();
        Calendar cal = new GregorianCalendar();
        cal.setTime(mesAno);                
        this.mes = cal.get(Calendar.MONTH);
        this.ano = cal.get(Calendar.YEAR) - 1900;
        this.vencimento = vencimento;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public Date getVencimento() {
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

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
}
