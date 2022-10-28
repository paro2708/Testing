# ICA 8- Testing

Question Description-
How many urinals are free? 
In men's public toilets with urinals, there is this unwritten rule that you leave at least one urinal free between you and 
the next person peeing. For example if there are 3 urinals and one person is already peeing in the left one, you will 
choose the urinal on the right and not the one in the middle. That means that a maximum of 3 people can pee at the 
same time on public toilets with 5 urinals when following this rule (Only 2 if the first person pees into urinal 2 or 4). 

Write a function that returns the maximum of free urinals as an integer according to the unwritten rule. 
Examples 
10001 returns 1 (10101) 
1001 returns 0 (1001) 
00000 returns 3 (10101) 
0000 returns 2 (1001) 
01000 returns 1 (01010 or 01001)

Input 
A String containing 1s and 0s (Example:  10001 ) (1 <= Length <= 20). This string can come from a file called urinal.dat. 
The program will continue processing until a -1 or <eof> is reached. (This means you handle unusual input without crashing.) 
A one stands for a taken urinal and a zero for a free one. 

Output 
Output the contents to rule.txt. If the file rule.txt already exists, increment a counter and rename the file using the 
following rule pattern:  rule1.txt, rule2.txt, etc. The output is JUST THE NUMBER of free urinals. Given the above output, 
your rule.txt file should contain: 
1 
0 
3 
2 
1


Code Description-
Urinals.java contains the logic for finding the maximum number of urinals according to the question.
UrinalsTest.java contains eight test cases consisting of successful inputs and unsuccessful inputs.