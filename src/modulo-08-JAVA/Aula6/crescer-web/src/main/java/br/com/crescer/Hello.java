package br.com.crescer;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author vinicius.ambrosi
 */
@ManagedBean
@ViewScoped
public class Hello implements Serializable{

//    private String helloWorld;
//
//    @PostConstruct
//    public void init(){
//        helloWorld = "Hello World";
//        System.out.println("........................................ E");
//    } 
    
//    @PreDestroy
//    public void out(){
//        System.out.println("........................................ S");
//    }
    
//    public String getHelloWorld() {
//        return helloWorld;
//    }
//
//    public void setHelloWorld(String helloWorld) {
//        this.helloWorld = helloWorld;
//    }
    
        
    public String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<String> getList() {
        return Singleton.getINSTANCE().getList();
    }
    
    public void processa(){
        Singleton.getINSTANCE().getList().add(mensagem);
    }
}
