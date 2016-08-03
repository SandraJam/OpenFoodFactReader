package com.example.octo_sdu.openfoodfactreader.bean;

public class Ingredients {
    private String rank;

    private String text;

    private String percent;

    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getPercent ()
    {
        return percent;
    }

    public void setPercent (String percent)
    {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "rank='" + rank + '\'' +
                ", text='" + text + '\'' +
                ", percent='" + percent + '\'' +
                '}';
    }
}
