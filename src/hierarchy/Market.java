package hierarchy;

import hierarchy.valut.Currency;

import java.util.List;

public class Market {
    private String name;
    private List<Currency> currencyList;
    private Emmitent emmitent;

    public Market(String name, Emmitent emmitent, List<Currency> currencyList) {
        this.name = name;
        this.emmitent = emmitent;
        this.currencyList = currencyList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public String getName() {
        return name;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public Emmitent getEmmitent() {
        return emmitent;
    }

    public void setEmmitent(Emmitent emmitent) {
        this.emmitent = emmitent;
    }
}
