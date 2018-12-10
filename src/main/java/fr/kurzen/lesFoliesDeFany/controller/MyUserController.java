package fr.kurzen.lesFoliesDeFany.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.kurzen.lesFoliesDeFany.model.MyUser;
import fr.kurzen.lesFoliesDeFany.service.MyUserService;

@RestController
@RequestMapping("/api/MyUsers")
public class MyUserController
{

	@Autowired
	MyUserService myUserService;
	
	@GetMapping("/")
	@CrossOrigin(origins = "*")
    public List<MyUser> greeting()
	{
        return myUserService.findAll();
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
    public Optional<MyUser> greeting(@PathVariable long id)
	{
        return myUserService.findById(id);
    }
	
	@CrossOrigin(origins = "*")
	@PostMapping("/connexion")
    public MyUser verifPassword(@RequestBody MyUser user)
	{
        return myUserService.verifPassword(user);
    }
	
	@CrossOrigin(origins = "*")
	@PostMapping("/connexionAuto/{id}")
    public boolean verifierConnexionAuto(@PathVariable(required = false) Long id, @RequestBody(required = false) String password)
	{
		if( id == null || password == null) {
			return false;
		}else {
			return myUserService.verifPassword(id, password);
		}
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping("/findUser/{login}")
    public MyUser findBylogin(@PathVariable String login)
	{
        return myUserService.findBylogin(login);
    }
	
	@CrossOrigin(origins = "*")
	@PostMapping("/addMyUser")
    public MyUser insertMyUser(@RequestBody MyUser user)
	{
        return myUserService.insertMyUser(user);
    }
	

	@CrossOrigin(origins = "*")
	@PutMapping("/updateMyUser")
    public MyUser updateMyUser(@RequestBody MyUser user)
	{
		return myUserService.updateMyUser(user);
    }
	

	@CrossOrigin(origins = "*")
	@PutMapping("/updateListMyUser")
    public List<MyUser> updateListMyUser(@RequestBody List<MyUser> users)
	{
		return myUserService.updateMyUser(users);
    }
}