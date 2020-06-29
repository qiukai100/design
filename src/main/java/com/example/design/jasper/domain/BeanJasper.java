package com.example.design.jasper.domain;

import com.example.design.jasper.domain.base.BaseEntity;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.Collection;

public class BeanJasper extends BaseEntity {

    private Collection<?> beanCollection;

    private Object[] beanArray;

    public BeanJasper(InputStream jasperFile) {
        super(jasperFile);
    }

    @Override
    public JasperPrint getJasperPrint() throws JRException {
        JRDataSource jrDataSource = null;
        if (getBeanCollection() != null && !getBeanCollection().isEmpty()) {
            jrDataSource = new JRBeanCollectionDataSource(getBeanCollection());
        } else if (getBeanArray() != null && getBeanArray().length > 0) {
            jrDataSource = new JRBeanArrayDataSource(getBeanArray());
        }
        return getJasperPrint(jrDataSource);
    }

    public Collection<?> getBeanCollection() {
        return beanCollection;
    }

    public void setBeanCollection(Collection<?> beanCollection) {
        this.beanCollection = beanCollection;
    }

    public Object[] getBeanArray() {
        return beanArray;
    }

    public void setBeanArray(Object[] beanArray) {
        this.beanArray = beanArray;
    }
}
