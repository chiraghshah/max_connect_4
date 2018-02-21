# max_connect_4
This is an agent that plays the Max-Connect-4 game using search.
Programming Language : Java

Code Structure:
1. The code is split in to three classes named maxconnect4, Gameboard and AiPlayer.
2. The classes are in the format of .java file extensions.
3. The class Gameboard is a class which implements various functions such as PrintGameBoard, getCurrentTurn, getScore, playPiece, etc. 
4. The class AiPlayer is a class with best play method to find out best move for a computer player. This class implements Alpha Beta MinMax Algorithm with depth limit, and requires depth parameter to be specified.
5. The class maxconnect4 is a class with main method.
This class requires run time arguments such as input file(.txt), game mode(interactive/one-move) and depth.
In interactive mode, computer and human can play the game and each player can play until 21 moves.
In one-move mode, only one move is made and the program terminates.


Run Code:
Please follow below steps to run the code:
1. The code is kept in folder: max_connect_4
2. Folder contains maxconnect4.java, Gameboard.java, AiPlayer.java, input1.txt, 
input2.txt.
3. Now compile the java file before excecuting it by following command :
javac maxconnect4.java Gameboard.java AiPlayer.java
4. For Interactive mode, run code by giving command: 
java maxconnect4 interactive [inputfile] [computer-next/human-next] [depth]
example: java maxconnect4 interactive input1.txt computer-next 7
5. For one-move mode, run code by giving command: 
java maxconnect4 one-move [inputfile] [outputfile] [depth]
example: java maxconnect4 one-move input1.txt output.txt 8
6. The input files are used for initialization of game board, you can change the 
input file where 1's indicate player 1, 2's indicate player 2 and 0's indicate empty.
7.If the input text file to be used is placed at other folder then make sure you give 
correct path for it.
E.g. java maxconnect4 interactive input1.txt computer-next 7
