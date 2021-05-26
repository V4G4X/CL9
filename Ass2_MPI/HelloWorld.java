import mpi.*;

public class HelloWorld {
    public static void main(String args[]) throws Exception {
        MPI.Init(args);
        int me = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        System.out.printf("Hi from <%02d>\n",me);
        MPI.Finalize();
    }
}