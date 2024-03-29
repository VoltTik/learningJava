package model.score;

import model.account.Account;
import model.constants.Constants;
import model.money.Money;
import model.money.MoneyInterface;


public abstract class Score implements MoneyInterface {
    private Money balance;
    private Account owner;
    private Integer number;

    public Score(Money balance, Account owner, Integer number) {
        this.balance = balance;
        this.owner = owner;
        this.number = number;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public void addMoney(Money money){
        double usdValueIn = money.getValue() * money.getCurrency().getUsdCourse();
        double usdValueThis = this.balance.getValue() * this.balance.getCurrency().getUsdCourse();
        if(addMoneyRules(money)) {
            this.balance.setValue((usdValueThis + usdValueIn) * this.balance.getCurrency().getUsdCourse());
        } else {
            throw new IllegalArgumentException("Unknown Add Money operation");
        }
    }

    protected abstract boolean addMoneyRules (Money money);
    @Override
    public Money getMoney(double balanceLess){
        if(balanceLess > Constants.MAX_GET_VALUE) {
            throw new IllegalArgumentException("Unable to get more than " + Constants.MAX_GET_VALUE);
        }
        this.balance.setValue(this.balance.getValue() - balanceLess);
        return this.balance;
    }
    @Override
    public Money getMoneyWithoutLess(){
        return this.balance;
    }
}
