package com.example.game;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.game.exceptions.ControllerException;
import com.example.game.resources.numPicker;

@RestController
public class gameController {
	private numPicker NumPicker;
    
	
	
	@GetMapping
	public String help(){
		return "Hello, this is a number picking game, it should be simple\nYou have infinite tries, but in the start you have 5 points and every try that is not succesful consts you one point, try to get them all\nSo, how the game works, type the address of your server and\n/start?name=YourName to start the game, it's mandatory\n/attempt?n=YourNumber to try the number you think is correct or is very close to it\n/hints to print the hints, hints are free and the game was designed that player uses it\nAdditionally you can get /stats , it will give you player's statistics.\nGood luck!";
	}
	@PostMapping("/start")
	public String startGame(@RequestParam(value="name") String name) throws ControllerException{
		this.NumPicker= new numPicker(name);
		return "The game started, and the number is... \nYou need to guess it, that's what game is about";
	}

	@PostMapping("/attempt")
	public String attempt(@RequestParam(value="n") int n) throws ControllerException {
		 return this.NumPicker.newAttempt(n);
	}
	@GetMapping("/hints")
	public String getHints(){
		return this.NumPicker.getHints();
	}
	@GetMapping("/stats")
	public String stats(){
		return this.NumPicker.getStats();
	}
}
