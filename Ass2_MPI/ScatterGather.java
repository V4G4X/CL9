import mpi.*;

public class ScatterGather {
    public static void main(String[] args) {
        // Initialize MPI Execution Environment
        MPI.Init(args);
        // Get the id of the process
        int rank = MPI.COMM_WORLD.Rank();

        // Total number of processes
        int size = MPI.COMM_WORLD.Size();
        int root = 0;

        // Array which will be filled with data by root process
        int sendbuf[]=null;
        int recvbuf[]=null;

        sendbuf = new int[size];
        recvbuf = new int[size];

        // Creates data to be scattered
        if (rank == root) {
            sendbuf[0] = 10;
            sendbuf[1] = 20;
            sendbuf[2] = 30;
            sendbuf[3] = 40;

            // Print Current process number
            System.out.printf("Process %02d has data: ", rank);
            for (int i = 0; i < size; i++) 
                System.out.print(sendbuf[i] + " ");
            System.out.println();
        }

        // Following are the args of the scatter method
        MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.INT, recvbuf, 0, 1, MPI.INT, root);
        System.out.printf("Processor %02d has data: %02d\n",rank, recvbuf[0]);
        System.out.printf("Processor %02d is doubling the data\n",rank);
        recvbuf[0]*=2;

        MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.INT, sendbuf, 0, 1, MPI.INT, root);

        if( rank == root ){
            System.out.printf("Process %02d has data: ",rank);
            for (int i = 0; i < sendbuf.length; i++) 
                System.out.print(sendbuf[i] + " ");                
        }
        MPI.Finalize();
    }
}