#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <math.h>

#define NUM_SONS 3

int main()
{

    pid_t pid;
    int i;

    for (i = 0; i < NUM_SONS ; i++)
    {
        pid = fork();

        if (pid == 0)
        {
            switch (i)
            {
            case 0:
                printf("I am the son [%d] my pid [%d] and my ppid[%d]\n",i,getpid(),getppid());
                exit(pid);
                break;
            case 1:
                printf("I am the son [%d] my pid [%d] and my ppid[%d]\n",i,getpid(),getppid());
                exit(pid);
                break;
            case 2:
                printf("I am the son [%d] my pid [%d] and my ppid[%d]\n",i,getpid(),getppid());
                exit(pid);
                break;
            
            default:
                break;
            }
        }
    }
    
    for (size_t i = 0; i < NUM_SONS; i++)
    {
        wait(NULL);     
    } 

    printf("I am the parent pid[%d] and ppid[%d]",getpid(),getppid());
}
