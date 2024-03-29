package Bank;

import java.util.Arrays;

public class Account implements Transferable {

  // private int balance; // derived by transactions

  private Transaction[] transactions;

  private AccountHolder accountHolder; // name, age, occupation, etc

  // Create Account, accountHolder must be there.
  public Account(AccountHolder accountHolder) {
    // this.balance = 0;
    this.accountHolder = accountHolder;
    this.transactions = new Transaction[0];
  }

  public Account(String name, int age) {
    // this.balance = 0;
    this.accountHolder = new AccountHolder(name, age);
    this.transactions = new Transaction[0];
  }

  private boolean addTransaction(Transaction transaction) {
    Transaction[] newArr =
        Arrays.copyOf(this.transactions, this.transactions.length + 1);
    newArr[newArr.length - 1] = transaction;
    this.transactions = newArr;
    return true;
  }


  public int balance() {
    int sum = 0;
    for (int i = 0; i < this.transactions.length; i++) {
      // isCredit true/ false
      if (this.transactions[i].isCredit())
        sum += this.transactions[i].getAmount();
      else
        sum -= this.transactions[i].getAmount();
    }
    return sum;
  }

  // private String type; // Saving, ABC, etc ...
  public boolean credit(int amount) { // add
    return this.addTransaction(Transaction.now(true, amount));
  }

  public boolean debit(int amount) { // deduct
    if (this.balance() < amount)
      return false;
    return this.addTransaction(Transaction.now(false, amount));
  }

  @Override
  public boolean transfer(Transferable to, int amount) { // design???
    if (amount <= 0)
      return false; // throw
    if (this.balance() < amount)
      return false;
    Account target = (Account) to;
    if (!target.credit(amount))
      return false;
    return this.addTransaction(Transaction.now(false, amount));
  }

  @Override
  public String toString() {
    return "Account(transactions=" //
        + Arrays.toString(this.transactions) //
        + " ,accountHolder=" //
        + this.accountHolder.toString() //
        + ")";
  }

  public static void main(String[] args) {
    Account johnAccount = new Account("John", 30);
    johnAccount.credit(3000); // Includes Add Transaction
    johnAccount.credit(1500);
    johnAccount.debit(4000);
    System.out.println(johnAccount.balance()); // 500

    Account peterAccount = new Account("Peter", 25);
    johnAccount.transfer(peterAccount, 350);

    System.out.println(johnAccount.balance()); // 150
    System.out.println(peterAccount.balance()); // 350

    Transferable maryAccount = new Account("Mary", 10);
    System.out.println(maryAccount.transfer(peterAccount, 200)); // false

    Account maryAccount2 = (Account) maryAccount;
    maryAccount2.credit(1000);
    System.out.println(maryAccount.transfer(peterAccount, 200)); // true
    System.out.println(maryAccount2.balance()); // 800
    System.out.println(peterAccount.balance()); // 550

    Object topmost = new Object();

    Object floatObject = Float.valueOf(10.0f);
    Float floatObject2 = Float.valueOf(10.0f);

    if (floatObject2.compareTo(8.2f) > 0) {
      System.out.println("yes");
    }

    // compile error, because type of the reference cannot reach compareTo()
    // floatObject.compareTo() 
    
    Object accountObject = new Account("Jenny", 25);
    System.out.println(accountObject.toString()); // bank.Account@15db9742

    // toString():
    // after overrding toString() in Account, we got ...
    // Account(transactions=[Lbank.Transaction;@15db9742 ,accountHolder=bank.AccountHolder@6d06d69c)
    // after overrding toString() in AccountHolder, we got ...
    // Account(transactions=[Lbank.Transaction;@15db9742 ,accountHolder=AccountHolder(name=Jenny ,age=25))
    // after overrding toString() in Transaction, we got ...
    // Arrays.toString(this.transaction)
    // Account(transactions=[] ,accountHolder=AccountHolder(name=Jenny ,age=25))

  }

}