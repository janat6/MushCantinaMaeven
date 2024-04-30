/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;

/**
 *
 * @author aluno
 */
public interface InterfaceDAO<T> {
    public abstract void create(T objeto);
    public abstract List<T> retrieve();
    public abstract T retrieve(int parPK);
    public abstract List<T> retrieve(String parString);
    public abstract void update(T objeto);
    public abstract void delete(T objeto);
}
