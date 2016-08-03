package com.example.octo_sdu.openfoodfactreader.bean;

public class Search
{
    private Product product;

    private String status_verbose;

    private String status;

    private String code;

    public Product getProduct ()
    {
        return product;
    }

    public void setProduct (Product product)
    {
        this.product = product;
    }

    public String getStatus_verbose ()
    {
        return status_verbose;
    }

    public void setStatus_verbose (String status_verbose)
    {
        this.status_verbose = status_verbose;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [product = "+product+", status_verbose = "+status_verbose+", status = "+status+", code = "+code+"]";
    }
}