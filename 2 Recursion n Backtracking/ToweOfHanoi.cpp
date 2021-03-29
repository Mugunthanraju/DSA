#include <iostream>

using namespace std;

void TOH(int n, char A, char B, char C)
{
    if(n > 0)                       //?Base Condition should be satisfied 
    {
        TOH(n - 1, A, C, B);    //? Calling the Recursion to move the Hanoi from A to B

        printf("\nShifting the top disk ( # %d ) from [ %c ] to [ %c ]\n", n, A, C);

        TOH(n - 1, B, A, C);    //? Calling the Recursion to move the Hanoi from B to C
    }
}

int main()
{
    int num{};
    printf("Enter the number of disks : ");
    scanf("%d", &num);

    //! Calling the function Tower of Hanoi > TOH <
    TOH(num, 'A', 'B', 'C');

    return 0;
}