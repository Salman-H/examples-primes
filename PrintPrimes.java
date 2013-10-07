public class PrintPrimes {
  int numberOfPrimes;
  int rows;
  int columns;

  int ORDMAX;
  int listOfPrimes[];
 
  
  public PrintPrimes(int numberOfPrimes, int rows, int columns , int ORDMAX) {
    this.numberOfPrimes   = numberOfPrimes;
    this.rows  = rows;
    this.columns   = columns ;
    
    this.ORDMAX = ORDMAX;
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
     
      int multiples[] = new int[ORDMAX + 1];

      int currentOddNumber = 1;
      int index = 2;
      int square = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          currentOddNumber = currentOddNumber + 2;
          if (currentOddNumber == square) {
            index= index+ 1;
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
        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        while (PAGEOFFSET <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + PAGENUMBER);
          System.out.println("");
          for (int ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + rows; ROWOFFSET++){
            for (int C = 0; C < columns ;C++)
              if (ROWOFFSET + C * rows <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[ROWOFFSET + C * rows]);
            System.out.println("");
          }
          System.out.println("\f");
          PAGENUMBER = PAGENUMBER + 1;
          PAGEOFFSET = PAGEOFFSET + rows * columns ;
        }
    }
}

					 
