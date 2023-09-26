class InsufficientFundsException extends Exception {
    private double amount;
    public InsufficientFundsException(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
}

class A{
    private double balance;
    private double number;
    public A(double number){
        this.number = number;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount <= balance){
            balance -= amount;
        }
        else{
            System.out.println("Insufficent funds");
            double need = amount - balance;
            throw new InsufficientFundsException(need);
        }
    }
    public double getBalance(){
        return balance;
    }
    public double getNumber(){
        return number;
    }
}

public class hello{
    public static void main(String[] args){
        A a = new A(101);
        a.deposit(500.00);
        try{
            a.withdraw(100.00);
            a.withdraw(600.00);
        }
        catch(InsufficientFundsException e){
            System.out.println(e.getAmount());
            e.printStackTrace();
        }
    }
}