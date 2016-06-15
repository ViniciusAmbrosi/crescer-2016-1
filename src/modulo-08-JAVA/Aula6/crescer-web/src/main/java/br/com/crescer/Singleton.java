package br.com.crescer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinicius.ambrosi
 */
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private List<String> list = new ArrayList();

    private Singleton() {
    }

    public static Singleton getINSTANCE() {
        return INSTANCE;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
