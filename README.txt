This is solving Exercise two.

The main proof class is:
test->
	com.gmatney.card
		TestFiveCardRanking

but eventually would be 
	com.gmatney.main
		TestEverything



Summary proof of this working:

2012-03-12 00:19:09 TestFiveCardRanking [INFO] ##############################################################
2012-03-12 00:19:09 TestFiveCardRanking [INFO] # setUp() called testGetHandRank
2012-03-12 00:19:09 TestFiveCardRanking [INFO] ##############################################################
2012-03-12 00:19:09 TestFiveCardRanking [INFO] # Initializing FiveCardRanking ranker
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (AH,KH,QH,JH,10H) is ROYAL_FLUSH
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (AC,2C,3C,4C,5C) is STRAIGHT_FLUSH
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (AH,AC,AS,AD,KD) is FOUR_OF_A_KIND
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (AH,AC,AS,KH,KD) is FULL_HOUSE
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (3D,3H,3S,2D,2H) is FULL_HOUSE
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (AD,2D,QD,JD,7D) is FLUSH
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (AH,KH,QH,JH,8H) is FLUSH
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (AC,KD,QH,JS,10S) is STRAIGHT
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (AC,2D,3H,4S,5S) is STRAIGHT
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (10C,KS,10H,JS,10S) is THREE_OF_A_KIND
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (7C,AD,7H,7S,4S) is THREE_OF_A_KIND
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (AC,AD,5H,5S,4S) is TWO_PAIR
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (AC,AD,3H,3S,5S) is TWO_PAIR
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (AC,AD,7H,5S,4S) is PAIR
2012-03-12 00:19:09 FiveCardRanking [INFO] The Rank of (2C,3D,7H,8S,4S) is HIGH_CARD
2012-03-12 00:19:09 TestFiveCardRanking [INFO] # tearDown testGetHandRank