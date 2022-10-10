//import random from "Math";
function guessingGame(amount){
	var  answer=Math.floor(Math.random()*10);
	answer=7;
	let guesses=1;
	return function game(guess){
		if(guesses>amount)
		{				
			console.log(`no more guess the answer was ${answer}`);
			return;
		}
		guesses++
		if(guesses==amount){
			console.log(" you're correct")

			return ;
		}
		if(guess>answer)
			console.log("too high")
		if(guess<answer)
			console.log("too low")
		if (guess==answer){
			console.log("you guessed it right")
			guesses=amount+1
		}}}

var game = guessingGame(5)
 game(1) // "You're too low!"
 game(8) // "You're too high!"
 game(5) // "You're too low!"
 game(7) // "You got it!"
 game(1) // "You are all done playing!"
