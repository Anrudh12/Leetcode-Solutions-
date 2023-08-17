class Solution {
    public String convert(String s, int numRows) {
         int col = 0;                  // variable that will store the number of columns the extended matrix have
        int l = s.length() ;
        while( l > 0){                // calculating number of columns
            l -= numRows;
            col++;
            for( int i = 0; i < numRows - 2; i++){
                if( l > 0){
                    l--;
                    col++;
                }
            }
        }
        //System.out.println( col);
        Character m[][] = new Character[ numRows][ col];    // creating matrix to store the asked arrangement
        l = s.length();
        int c = 0; int p = 0;
        while( l > 0){                                     // storing string in the matrix in the asked arrangement
            //l -= numRows;
            for( int i = 0; i < numRows; i++){
                if( l > 0){
                    l--;
                    m [i][c] = s.charAt(p++);
                    //p++;
                }
            }
            c++;
            for( int i = numRows - 2; i > 0; i--){
                if( l > 0){
                    l--;
                    m [ i][ c++] = s.charAt(p++);
                    //p++;
                    //c++;
                }
            }
        }
        /*for( int i = 0; i < numRows; i++){       // to print the created matrix
            for( int j = 0; j < col; j++){
                System.out.print( m[i][j] + " " );
            }
            System.out.println("\n");
        }*/
        String f = "";                            // traverse the matrix row-wise and answer is achieved
        for( int i = 0; i < numRows; i++){
            for( int j = 0; j < col; j++){
                if( m[i][j] != null){
                    f += m[i][j];
                }
            }
        }
        return f;
    }
}
