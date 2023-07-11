package custom_exception;

import java.util.Scanner;

class Balance{
	 private int account_balance=10000; 
	public int getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}	
}
public class Atm
{
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter your option");
    	System.out.println("1.Account balance");
    	System.out.println("2.Deposit");
    	System.out.println("3.withdraw");
    	System.out.println("4.exit");
    	int option = scan.nextInt();
    	Balance accbalance = new Balance();
    	while(true) {
    	switch(option) {
    	case 1:
    		System.out.println(accbalance.getAccount_balance());
    		break;
    	case 2:
    		System.out.print("Enter the amount to deposite");
    		int deposit =scan.nextInt();
    		System.out.println(accbalance.getAccount_balance()+deposit);
    		break;
    	case 3:
    		int withdraw = scan.nextInt();
    		try{
    			if(accbalance.getAccount_balance()!=0) {
    				System.out.println("Enter the amount to withdraw");
            	validiteamount(withdraw);
            	System.out.println(accbalance.getAccount_balance()-withdraw);
    			}
    			else {
    				System.out.println("Your account balance is 0");
    			}
            }
            catch(InsufficentFundsException exception){
                System.out.println(exception.getMessage());
            }
            catch(InvalidAmountException exception) {
            	System.out.println(exception.getMessage());
            }
    		break;
    	case 4:
    		System.exit(0);
    		System.out.println("Exited");
    	}
    	}
    	
        
    }

    public static void validiteamount(int withdrawamount) throws InsufficentFundsException,InvalidAmountException {
    	Balance accbalance = new Balance();
        if ( withdrawamount>= 0 && withdrawamount<=accbalance.getAccount_balance()) {
            System.out.println("Succesfully withdrawn");
        } 
        else if(withdrawamount>accbalance.getAccount_balance()) {
            throw new InsufficentFundsException("Balance is Insufficent");
        }
        else {
        	throw new InsufficentFundsException("Plese enter positive value");
        }
    }
}
class InsufficentFundsException extends Exception
{
    public InsufficentFundsException(String errorMessage)
    {
        super(errorMessage);
    }
}
class InvalidAmountException extends Exception
{
    public InvalidAmountException(String errorMessage)
    {
        super(errorMessage);
    }
}