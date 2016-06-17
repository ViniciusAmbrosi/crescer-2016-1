package br.com.crescer.entity;

import java.io.Serializable;

/**
 * @author Carlos H. Nonnemacher
 * @param <ID>
 */
public abstract class SerializableID<ID extends Serializable> implements Serializable {

    public abstract ID getId();

}
