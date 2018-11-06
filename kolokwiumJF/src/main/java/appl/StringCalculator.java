package appl;

import excp.BadInputException;
import excp.NothingToSubstractFromException;
import excp.TooBigNumberException;

public class StringCalculator extends Calculator implements Cloneable {
    public StringCalculator() {
        this.result = "";
    }

    public String getResult() {
        return result;
    }

    private String result;

    @Override
    public void Add(String x) {
        result = new StringBuilder().append(result).append(x).toString();
    }

    @Override
    public void Substract(String x) throws NothingToSubstractFromException, BadInputException {
        int test = result.length();
        for (int j = 0; j< test; j++) {
            for (int i = 0; i < result.length() - x.length(); i++) {
                if (result.substring(0, x.length()).equals(x)) {
                    result = new StringBuilder().append(result.substring(0, i)).append(result.substring(i + x.length(), result.length())).toString();
                    
                }
            }
        }
    }

    @Override
    public void Multiply(int x) throws TooBigNumberException {
        if (x > 5){
            throw new TooBigNumberException();
        }
        String temp = result;
        for (int i = 1; i < x; i++) {
            this.Add(temp);
        }
    }

    public static void main(String[] argv){
        StringCalculator mySCalc = new StringCalculator();
        mySCalc.Add("test");
        System.out.println(mySCalc.getResult());
        mySCalc.Add("no bad");
        System.out.println(mySCalc.getResult());
        try {
            mySCalc.Multiply(5);
        } catch (TooBigNumberException e) {
            e.printStackTrace();
        }
        System.out.println(mySCalc.getResult());
        try {
            mySCalc.Substract("test");
        } catch (NothingToSubstractFromException e) {
            e.printStackTrace();
        } catch (BadInputException e) {
            e.printStackTrace();
        }
        System.out.println(mySCalc.getResult());
    }
}
