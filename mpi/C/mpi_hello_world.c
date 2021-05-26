#include <mpi.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
    MPI_Init(NULL, NULL);

    int world_size;
    MPI_Comm_size(MPI_COMM_WORLD, &world_size);

    int world_rank;
    MPI_Comm_rank(MPI_COMM_WORLD, &world_rank);

    char processor_name[MPI_MAX_PROCESSOR_NAME];
    int name_len; 
    MPI_Get_processor_name(processor_name, &name_len);

    printf("Hello World from processor %s, rank %2d out of %2d processors\n", processor_name, world_rank, world_size);

    MPI_Finalize();
    return 0;
}