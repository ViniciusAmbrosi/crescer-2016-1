package br.com.crescer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinicius.ambrosi
 */
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private List<Pessoa> list = new ArrayList();

    private Singleton() {
    }

    public static Singleton getINSTANCE() {
        return INSTANCE;
    }

    public List<Pessoa> getList() {
        return list;
    }

    public void setList(List<Pessoa> list) {
        this.list = list;
    }
}
