package com.ushara.dengigo.controller;

@Controller
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping(value ="/{login}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("login") String login){
        userDao.delete(userDao.getByLogin(login));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody User createUser(@RequestBody User user, BindingResult result, HttpServletResponse response) throws BindException {
        if(result.hasErrors()){
            throw new BindException(result);
        }
        userDao.save(user);
        return user;
    }

}
