import java.rmi.RemoteException;

public class CalcClass implements CalcInterface{

    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a-b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a*b;
    }

    @Override
    public double divide(int a, int b) throws RemoteException, ArithmeticException {
        return (double)a/b;
    }
}
