public class PrintPrimes {
  int numberOfPrimes;
  int rows;
  int columns;
  int ordMax;
  int listOfPrimes[];
 
  
  public PrintPrimes(int numberOfPrimes, int rows, int columns , int ordMax) {
    this.numberOfPrimes = numberOfPrimes;
    this.rows = rows;
    this.columns = columns ;
    this.ordMax = ordMax;
    this.listOfPrimes = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) {
      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4, 30);
      printPrimes.calculatePrimes();
      printPrimes.printPrimes();
  }

  
  public void calculatePrimes() {
      /* Two is the only even prime. All other prime numbers are odd.
       * To simplify the code, we simply add 2 as a prime number, and
       * delegate the task of finding all odd prime numbers to a helper
       * function.
       */
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  
  private void calculateOddPrimes() {
      boolean isPrime;
      int multiples[] = new int[ordMax + 1];
      int currentOddNumber = 1;
      int index = 2;
      int square = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          currentOddNumber = currentOddNumber + 2;
          
          if (currentOddNumber == square) {
            index = index + 1;
            square = listOfPrimes[index] * listOfPrimes[index];
            multiples[index- 1] = currentOddNumber;
          }
         
          isPrime = true;
         
         for (int n = 2; n < index && isPrime; n++) {
            while (multiples[n] < currentOddNumber)
              multiples[n] = multiples[n] + listOfPrimes[n] + listOfPrimes[n];
            if (multiples[n] == currentOddNumber)
              isPrime = false;
          }
        
        } while (!isPrime);
        listOfPrimes[primesFoundSoFar] = currentOddNumber;
      }
    }

    public void printPrimes() {
        int pageNumber = 1;
        int pageOffSet = 1;
        
        while (pageOffSet <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + pageNumber);
          System.out.println("");
         
          for (int rowOffSet = pageOffSet; rowOffSet < pageOffSet + rows; rowOffSet++){
            for (int c = 0; c < columns; c++)
              if (rowOffSet + c * rows <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[rowOffSet + c * rows]);
            System.out.println("");
          }
          System.out.println("\f");
          pageNumber = pageNumber + 1;
          pageOffSet = pageOffSet + rows * columns ;
        }
    }
}

					 
