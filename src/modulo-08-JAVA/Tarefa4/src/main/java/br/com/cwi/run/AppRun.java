package br.com.cwi.run;

import br.com.tarefa4.DAO.CidadeDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author vinicius.ambrosi
 */
public class AppRun {
    public static void main(String[] args) {
        
        CidadeDAO cid = new CidadeDAO();
        try {
            cid.exportarCsv("cidades");
        } catch (IOException ex) {
            Logger.getLogger(AppRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
